import java.util.ArrayList;
import java.util.List;

/**
 * AeroPack X1 ADT
 *
 * A futuristic smart backpack with:
 * - Biometric security
 * - Anti-gravity assistance
 * - AI item locator
 * - Solar charging
 *
 * @author Roger Alfonso A. Mancera
 * @course DSA_A223
 */
public class AeroPack {

    // =========================
    // ATTRIBUTES / DATA
    // =========================

    private String owner;
    private String color;
    private float capacity;
    private float currentWeight;
    private int batteryLevel;
    private boolean locked;
    private boolean antiGravityMode;
    private String biometricID;

    private final List<String> items;


    // =========================
    // CONSTRUCTOR
    // =========================

    public AeroPack(
            String owner,
            String color,
            float capacity,
            String biometricID
    ) {

        this.owner = owner;
        this.color = color;

        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            this.capacity = 20.0f;
        }

        this.biometricID = biometricID;

        this.currentWeight = 0.0f;
        this.batteryLevel = 50;
        this.locked = true;
        this.antiGravityMode = false;

        this.items = new ArrayList<>();
    }


    // =========================
    // ADD ITEM
    // =========================

    public void addItem(String item, float weight) {

        if (locked) {
            System.out.println(
                    "Cannot add " + item +
                    ". AeroPack is locked."
            );
            return;
        }

        if (weight <= 0) {
            System.out.println(
                    "Invalid item weight."
            );
            return;
        }

        if (currentWeight + weight > capacity) {
            System.out.println(
                    item +
                    " cannot be added. Capacity exceeded."
            );
            return;
        }

        items.add(item);
        currentWeight += weight;

        System.out.println(
                item + " added successfully."
        );
    }


    // =========================
    // REMOVE ITEM
    // =========================

    public void removeItem(
            String item,
            float weight
    ) {

        if (locked) {

            System.out.println(
                    "Cannot remove item. AeroPack is locked."
            );

            return;
        }

        if (weight <= 0) {

            System.out.println(
                    "Invalid item weight."
            );

            return;
        }

        if (items.contains(item)) {

            items.remove(item);

            currentWeight -= weight;

            if (currentWeight < 0) {
                currentWeight = 0;
            }

            System.out.println(
                    item +
                    " removed successfully."
            );

        } else {

            System.out.println(
                    item +
                    " was not found."
            );
        }
    }


    // =========================
    // BIOMETRIC SECURITY
    // =========================

    public void biometricUnlock(
            String scan
    ) {

        if (
                scan != null
                &&
                scan.equals(biometricID)
        ) {

            locked = false;

            System.out.println(
                    "Biometric scan accepted."
            );

            System.out.println(
                    "AeroPack unlocked."
            );

        } else {

            System.out.println(
                    "ACCESS DENIED: Invalid biometric scan."
            );
        }
    }


    // =========================
    // LOCK
    // =========================

    public void lock() {

        locked = true;

        System.out.println(
                "AeroPack locked."
        );
    }


    // =========================
    // ANTI-GRAVITY
    // =========================

    public void activateAntiGravity() {

        if (batteryLevel < 10) {

            System.out.println(
                    "Not enough battery for Anti-Gravity Mode."
            );

            return;
        }

        antiGravityMode = true;

        batteryLevel -= 10;

        System.out.println(
                "Anti-Gravity Mode activated."
        );

        System.out.println(
                "Carried weight reduced by 70%."
        );
    }


    public void deactivateAntiGravity() {

        antiGravityMode = false;

        System.out.println(
                "Anti-Gravity Mode deactivated."
        );
    }


    // =========================
    // SOLAR CHARGING
    // =========================

    public void solarCharge(
            int minutes
    ) {

        if (minutes <= 0) {

            System.out.println(
                    "Invalid charging time."
            );

            return;
        }

        int energy = minutes / 2;

        batteryLevel += energy;

        if (batteryLevel > 100) {
            batteryLevel = 100;
        }

        System.out.println(
                "Solar charging complete."
        );

        System.out.println(
                "Battery Level: "
                +
                batteryLevel
                +
                "%"
        );
    }


    // =========================
    // AI ITEM LOCATOR
    // =========================

    public boolean locateItem(
            String item
    ) {

        System.out.println(
                "AI scanning AeroPack for "
                +
                item
                +
                "..."
        );

        if (items.contains(item)) {

            System.out.println(
                    item +
                    " detected inside AeroPack."
            );

            return true;
        }

        System.out.println(
                item +
                " was not detected."
        );

        return false;
    }


    // =========================
    // OBSERVERS / GETTERS
    // =========================

    public float getCurrentWeight() {

        return currentWeight;
    }


    public float getEffectiveWeight() {

        if (antiGravityMode) {

            return currentWeight * 0.30f;
        }

        return currentWeight;
    }


    public float remainingCapacity() {

        return capacity - currentWeight;
    }


    public int getBatteryLevel() {

        return batteryLevel;
    }


    public boolean isLocked() {

        return locked;
    }


    public boolean isAntiGravityActive() {

        return antiGravityMode;
    }


    public String getOwner() {

        return owner;
    }


    public String getColor() {

        return color;
    }


    public float getCapacity() {

        return capacity;
    }


    public List<String> getItems() {

        return new ArrayList<>(items);
    }


    // =========================
    // DISPLAY INFORMATION
    // =========================

    public void showInfo() {

        System.out.println(
                "\n========== AEROPACK X1 =========="
        );

        System.out.println(
                "Owner\t\t: " + owner
        );

        System.out.println(
                "Color\t\t: " + color
        );

        System.out.printf(
                "Capacity\t: %.2f kg%n",
                capacity
        );

        System.out.printf(
                "Actual Weight\t: %.2f kg%n",
                currentWeight
        );

        System.out.printf(
                "Weight Felt\t: %.2f kg%n",
                getEffectiveWeight()
        );

        System.out.printf(
                "Remaining\t: %.2f kg%n",
                remainingCapacity()
        );

        System.out.println(
                "Battery\t\t: "
                +
                batteryLevel
                +
                "%"
        );

        System.out.println(
                "Locked\t\t: "
                +
                locked
        );

        System.out.println(
                "Anti-Gravity\t: "
                +
                antiGravityMode
        );

        System.out.println(
                "Items\t\t: "
                +
                items
        );

        System.out.println(
                "================================="
        );
    }
}   