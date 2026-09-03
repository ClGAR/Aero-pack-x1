/**
 * AeroPack X1 Tester / Driver Program
 *
 * @author Roger Alfonso A. Mancera
 * @course DSA_A223
 */
public class TestAeroPack {

    public static void main(String[] args) {

        // Roger Alfonso A. Mancera - DSA_A223
        AeroPack bag = new AeroPack(
                "Roger Alfonso A. Mancera",
                "Quantum Black",
                20.0f,
                "RAM-2026"
        );

        System.out.println("=== AEROPACK X1 FUTURISTIC OBJECT SIMULATION ===");

        // Initial information
        bag.showInfo();

        // Biometric security test
        System.out.println("\n--- BIOMETRIC SECURITY TEST ---");
        bag.biometricUnlock("WRONG-ID");
        bag.biometricUnlock("RAM-2026");

        // Add items
        System.out.println("\n--- ADDING ITEMS ---");
        bag.addItem("Laptop", 3.0f);
        bag.addItem("Power Bank", 1.0f);
        bag.addItem("Notebook", 0.5f);
        bag.addItem("Water Bottle", 1.5f);

        bag.showInfo();

        // AI item locator
        System.out.println("\n--- AI ITEM LOCATOR ---");
        bag.locateItem("Laptop");
        bag.locateItem("Headphones");

        // Anti-gravity test
        System.out.println("\n--- ANTI-GRAVITY TEST ---");
        bag.activateAntiGravity();

        System.out.printf("Actual Weight: %.2f kg%n", bag.getCurrentWeight());
        System.out.printf("Weight Felt by User: %.2f kg%n", bag.getEffectiveWeight());

        // Solar charging
        System.out.println("\n--- SOLAR CHARGING TEST ---");
        bag.solarCharge(60);

        // Remove an item
        System.out.println("\n--- REMOVING ITEM ---");
        bag.removeItem("Notebook", 0.5f);

        // Lock backpack
        System.out.println("\n--- SECURITY TEST ---");
        bag.lock();
        bag.removeItem("Laptop", 3.0f);

        // Final information
        bag.showInfo();

        System.out.println("\n=== SIMULATION COMPLETE ===");
    }
}
