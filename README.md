
**ADT Activity: Futuristic Object Simulation**  
**Student:** Roger Alfonso A. Mancera  
**Section:** DSA_A223  



📌 Project Description

AeroPack X1 is a futuristic redesign of an ordinary backpack. It is designed for students, travelers, and professionals who want a smarter, safer, and easier way to carry personal belongings.

The project demonstrates the use of an Abstract Data Type (ADT) by separating the object's internal data from the operations that control and observe its behavior.



 Futuristic Features

🔐 Biometric Security
The AeroPack remains locked until the correct biometric identification is provided. Unauthorized access attempts are rejected.

🪶 Anti-Gravity Assistance
Anti-Gravity Mode reduces the weight felt by the user by **70%**, making heavy items easier to carry.

☀️ Solar Charging
The AeroPack uses futuristic solar materials to convert sunlight into battery power.

🤖 AI Item Locator
The built-in AI can scan the contents of the AeroPack and determine whether a requested item is stored inside.



ADT Design

Attributes / Data

| Attribute | Purpose |
|---|---|
| `owner` | Stores the owner's name |
| `color` | Stores the AeroPack color |
| `capacity` | Maximum carrying capacity |
| `currentWeight` | Current weight of stored items |
| `batteryLevel` | AeroPack battery percentage |
| `locked` | Indicates whether the AeroPack is locked |
| `antiGravityMode` | Indicates whether anti-gravity is active |
| `biometricID` | Stores the authorized biometric identity |
| `items` | Stores the names of items inside the AeroPack |

Operations / Methods

| Method | Function |
|---|---|
| `addItem()` | Adds an item if the pack is unlocked and has enough capacity |
| `removeItem()` | Removes an item from the pack |
| `biometricUnlock()` | Unlocks the AeroPack using biometric authentication |
| `lock()` | Locks the AeroPack |
| `activateAntiGravity()` | Activates weight-reduction technology |
| `deactivateAntiGravity()` | Turns off anti-gravity mode |
| `solarCharge()` | Recharges the internal battery |
| `locateItem()` | Uses AI to search for an item |
| `getEffectiveWeight()` | Returns the weight felt by the user |
| `remainingCapacity()` | Returns available carrying capacity |
| `showInfo()` | Displays the current AeroPack status |


Project Structure

AeroPack-X1/
│
├── AeroPack.java
├── TestAeroPack.java
├── README.md
├── .gitignore
│
└── screenshots/
    
 How to Run

1. Compile


javac AeroPack.java TestAeroPack.java


### 2. Run

```bash
java TestAeroPack
```

---

## 🖥️ Sample Simulation Output

```text
=== AEROPACK X1 FUTURISTIC OBJECT SIMULATION ===

========== AEROPACK X1 ==========
Owner           : Roger Alfonso A. Mancera
Color           : Quantum Black
Capacity        : 20.00 kg
Actual Weight   : 0.00 kg
Weight Felt     : 0.00 kg
Remaining       : 20.00 kg
Battery         : 50%
Locked          : true
Anti-Gravity    : false
Items           : []
=================================

--- BIOMETRIC SECURITY TEST ---
ACCESS DENIED: Invalid biometric scan.
Biometric scan accepted.
AeroPack unlocked.

--- ADDING ITEMS ---
Laptop added successfully.
Power Bank added successfully.
Notebook added successfully.
Water Bottle added successfully.

--- AI ITEM LOCATOR ---
AI scanning AeroPack for Laptop...
Laptop detected inside AeroPack.

AI scanning AeroPack for Headphones...
Headphones was not detected.

--- ANTI-GRAVITY TEST ---
Anti-Gravity Mode activated.
Carried weight reduced by 70%.
Actual Weight: 6.00 kg
Weight Felt by User: 1.80 kg

--- SOLAR CHARGING TEST ---
Solar charging complete.
Battery Level: 70%

=== SIMULATION COMPLETE ===
```

---

## 🧠 What I Learned

This activity helped me understand how an **Abstract Data Type** can represent a futuristic real-world object. The attributes store the AeroPack's state, while its methods control how that state can be changed or observed.

I also learned that validation and controlled access are important because they prevent invalid operations and keep the object in a consistent state.

---

## 🤖 AI Use Disclosure

I used **ChatGPT** to assist with brainstorming the futuristic object, organizing the ADT structure, developing the Java code, debugging, and testing ideas. I reviewed the code and explanations to understand how the attributes, methods, and simulation work. The final submitted project reflects my understanding of Abstract Data Types and object-oriented programming.

---

## 👤 Author

**Roger Alfonso A. Mancera**  
**DSA_A223**
