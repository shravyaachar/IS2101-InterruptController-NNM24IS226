```markdown
# 🖥️ Interrupt Controller Simulation (Java)

## 📘 Overview
This project simulates the working of an **Interrupt Controller** to demonstrate how interrupts from multiple devices (Keyboard, Mouse, and Printer) are handled based on **priority and masking** in a computer system.

The simulation uses **Java multithreading concepts** and demonstrates **interrupt handling logic**, **masking**, and **logging** of ISR (Interrupt Service Routine) executions.

---

## ⚙️ Features
- Simulates interrupts from **Keyboard**, **Mouse**, and **Printer**
- Handles interrupt priorities:
  - **Keyboard** → Highest Priority (1)
  - **Mouse** → Medium Priority (2)
  - **Printer** → Lowest Priority (3, masked at start)
- Keeps a log of all handled and masked interrupts
- Automatically stops after 10 interrupts
- Displays a final log summary after simulation

---

## 🧩 Classes

### **InterruptController**
Handles the core logic:
- `handleInterrupt(String deviceName)` → Processes interrupts and maintains a log
- `showFinalLog()` → Displays the ISR log after simulation
- `isSimulationComplete()` → Stops simulation after 10 interrupts

### **InterruptSimulation**
The main driver class:
- Initializes devices and their priorities
- Randomly generates interrupts
- Simulates interrupt handling with random delays

---

## 📄 Output Example

```

Keyboard enabled
Mouse enabled
Printer masked
Mouse ? ISR done
Keyboard ? ISR done
Printer masked
Keyboard ? ISR done
...
=== ISR Log ===
10:15:21 - Keyboard
10:15:22 - Mouse
10:15:23 - Printer Masked
10:15:24 - Keyboard
...
Simulation complete.
=== Code Execution Successful ===

````

---

## 🧠 Concepts Covered
- Interrupt handling mechanism
- Thread synchronization (`synchronized` block)
- Priority and masking
- Logging with timestamps
- Java `Random`, `List`, and `SimpleDateFormat` classes

---

## 🚀 How to Run

### **In Eclipse / IntelliJ:**
1. Create a new **Java Project** (e.g., `InterruptSimulation`).
2. Create a new **class file** named `InterruptSimulation.java`.
3. Paste the full code from this repository.
4. **Run** the program (`Run → Run As → Java Application`).

### **Using Command Line:**
```bash
javac InterruptSimulation.java
java InterruptSimulation
````

---

## 🧾 Notes

* Printer is masked initially (disabled), so its interrupts will show as “masked”.
* The simulation automatically ends after handling 10 interrupts.
* Time format for logs: `HH:mm:ss`.

---
