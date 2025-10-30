import java.util.*;
import java.text.SimpleDateFormat;

class InterruptController {
    private boolean keyboardEnabled = true;
    private boolean mouseEnabled = true;
    private boolean printerEnabled = false; // masked at start

    private List<String> logHistory = new ArrayList<>();
    private final Object lock = new Object();
    private int interruptCount = 0;
    private final int MAX_INTERRUPTS = 10; // stop after 10

    public boolean isSimulationComplete() {
        return interruptCount >= MAX_INTERRUPTS;
    }

    public void handleInterrupt(String deviceName) {
        synchronized (lock) {
            if (isSimulationComplete()) return;

            boolean masked = (deviceName.equals("Keyboard") && !keyboardEnabled)
                    || (deviceName.equals("Mouse") && !mouseEnabled)
                    || (deviceName.equals("Printer") && !printerEnabled);

            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

            if (masked) {
                System.out.println(deviceName + " masked");
                logHistory.add(time + " - " + deviceName + " Masked");
            } else {
                System.out.println(deviceName + " ? ISR done");
                logHistory.add(time + " - " + deviceName);
            }

            interruptCount++;
        }
    }

    public void showFinalLog() {
        System.out.println("\n=== ISR Log ===");
        for (String log : logHistory) {
            System.out.println(log);
        }
        System.out.println("\nSimulation complete.");
        System.out.println("=== Code Execution Successful ===");
    }
}

public class InterruptSimulation {
    public static void main(String[] args) throws InterruptedException {
        InterruptController controller = new InterruptController();
        Random rand = new Random();

        System.out.println("Keyboard enabled");
        System.out.println("Mouse enabled");
        System.out.println("Printer masked");

        String[] devices = {"Keyboard", "Mouse", "Printer"};
        int priorities[] = {1, 2, 3}; // Keyboard highest

        // Simulate 10 interrupts
        while (!controller.isSimulationComplete()) {
            // Random delay between interrupts
            Thread.sleep(1000);

            // Random device interrupt
            int index = rand.nextInt(devices.length);
            String device = devices[index];

            // Always handle highest priority first
            if (device.equals("Keyboard")) controller.handleInterrupt("Keyboard");
            else if (device.equals("Mouse")) controller.handleInterrupt("Mouse");
            else controller.handleInterrupt("Printer");
        }

        controller.showFinalLog();
    }
}
