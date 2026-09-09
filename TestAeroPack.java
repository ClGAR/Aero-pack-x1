import java.util.Scanner;

/**
 * AeroPack X1 Interactive Driver Program
 *
 * @author Roger Alfonso A. Mancera
 * @course DSA_A223
 */
public class TestAeroPack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("       AEROPACK X1 SETUP");
        System.out.println("==================================");

        System.out.print("Enter owner name: ");
        String owner = input.nextLine();

        System.out.print("Enter AeroPack color: ");
        String color = input.nextLine();

        System.out.print("Enter capacity in kg: ");
        float capacity = Float.parseFloat(input.nextLine());

        System.out.print("Create biometric ID: ");
        String biometricID = input.nextLine();

        AeroPack bag = new AeroPack(
                owner,
                color,
                capacity,
                biometricID
        );

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("        AEROPACK X1 MENU");
            System.out.println("==================================");
            System.out.println("1. Show AeroPack Information");
            System.out.println("2. Biometric Unlock");
            System.out.println("3. Add Item");
            System.out.println("4. Remove Item");
            System.out.println("5. AI Item Locator");
            System.out.println("6. Activate Anti-Gravity");
            System.out.println("7. Deactivate Anti-Gravity");
            System.out.println("8. Solar Charge");
            System.out.println("9. Lock AeroPack");
            System.out.println("0. Exit");
            System.out.println("==================================");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:
                    bag.showInfo();
                    break;

                case 2:
                    System.out.print("Enter biometric ID: ");
                    String scan = input.nextLine();

                    bag.biometricUnlock(scan);
                    break;

                case 3:
                    System.out.print("Enter item name: ");
                    String item = input.nextLine();

                    System.out.print("Enter item weight (kg): ");
                    float weight =
                            Float.parseFloat(input.nextLine());

                    bag.addItem(item, weight);
                    break;

                case 4:
                    System.out.print("Enter item name to remove: ");
                    String removeItem = input.nextLine();

                    System.out.print("Enter item weight (kg): ");
                    float removeWeight =
                            Float.parseFloat(input.nextLine());

                    bag.removeItem(
                            removeItem,
                            removeWeight
                    );
                    break;

                case 5:
                    System.out.print("Enter item to locate: ");
                    String searchItem = input.nextLine();

                    bag.locateItem(searchItem);
                    break;

                case 6:
                    bag.activateAntiGravity();

                    System.out.printf(
                            "Actual Weight: %.2f kg%n",
                            bag.getCurrentWeight()
                    );

                    System.out.printf(
                            "Weight Felt: %.2f kg%n",
                            bag.getEffectiveWeight()
                    );
                    break;

                case 7:
                    bag.deactivateAntiGravity();
                    break;

                case 8:
                    System.out.print(
                            "Enter charging time in minutes: "
                    );

                    int minutes =
                            Integer.parseInt(input.nextLine());

                    bag.solarCharge(minutes);
                    break;

                case 9:
                    bag.lock();
                    break;

                case 0:
                    System.out.println(
                            "\nAeroPack X1 shutting down..."
                    );
                    System.out.println(
                            "Thank you for using AeroPack X1!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        input.close();
    }
}