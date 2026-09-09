import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AeroPackGUI extends JFrame {

    private AeroPack bag;

    private JLabel ownerLabel;
    private JLabel statusLabel;
    private JLabel weightLabel;
    private JLabel effectiveWeightLabel;
    private JLabel remainingLabel;
    private JLabel antiGravityLabel;

    private JProgressBar batteryBar;
    private JProgressBar capacityBar;

    private DefaultListModel<String> itemModel;
    private JList<String> itemList;

    public AeroPackGUI() {

        setupAeroPack();

        setTitle("Aero Pack");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        createHeader();
        createDashboard();
        createControls();

        refreshStatus();

        setVisible(true);
    }


    // =====================================
    // INITIAL SETUP
    // =====================================

    private void setupAeroPack() {

        String owner = JOptionPane.showInputDialog(
                null,
                "Enter Owner Name:",
                "Aero Pack Setup",
                JOptionPane.PLAIN_MESSAGE
        );

        String color = JOptionPane.showInputDialog(
                null,
                "Enter Aero Pack Color:",
                "Aero Pack Setup",
                JOptionPane.PLAIN_MESSAGE
        );

        String capacityInput = JOptionPane.showInputDialog(
                null,
                "Enter Capacity in KG:",
                "Aero Pack Setup",
                JOptionPane.PLAIN_MESSAGE
        );

        float capacity = 20.0f;

        try {
            capacity = Float.parseFloat(capacityInput);
        } catch (Exception e) {
            capacity = 20.0f;
        }

        String biometric = JOptionPane.showInputDialog(
                null,
                "Create Biometric ID:",
                "Aero Pack Security",
                JOptionPane.PLAIN_MESSAGE
        );

        bag = new AeroPack(
                owner,
                color,
                capacity,
                biometric
        );
    }


    // =====================================
    // HEADER
    // =====================================

    private void createHeader() {

        JPanel header = new JPanel();

        header.setBackground(
                new Color(15, 23, 42)
        );

        header.setBorder(
                new EmptyBorder(
                        18,
                        25,
                        18,
                        25
                )
        );

        header.setLayout(
                new BorderLayout()
        );

        JLabel title = new JLabel("Aero Pack");

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(Color.WHITE);

        header.add(
                title,
                BorderLayout.WEST
        );

        add(
                header,
                BorderLayout.NORTH
        );
    }


    // =====================================
    // DASHBOARD
    // =====================================

    private void createDashboard() {

        JPanel dashboard = new JPanel(
                new GridLayout(
                        1,
                        2,
                        15,
                        15
                )
        );

        dashboard.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );


        // LEFT STATUS PANEL

        JPanel statusPanel = new JPanel();

        statusPanel.setLayout(
                new BoxLayout(
                        statusPanel,
                        BoxLayout.Y_AXIS
                )
        );

        statusPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Aero Pack Status"
                )
        );


        ownerLabel = new JLabel();
        statusLabel = new JLabel();
        weightLabel = new JLabel();
        effectiveWeightLabel = new JLabel();
        remainingLabel = new JLabel();
        antiGravityLabel = new JLabel();


        statusPanel.add(ownerLabel);
        statusPanel.add(
                Box.createVerticalStrut(10)
        );

        statusPanel.add(statusLabel);
        statusPanel.add(
                Box.createVerticalStrut(10)
        );

        statusPanel.add(weightLabel);
        statusPanel.add(
                Box.createVerticalStrut(10)
        );

        statusPanel.add(
                effectiveWeightLabel
        );

        statusPanel.add(
                Box.createVerticalStrut(10)
        );

        statusPanel.add(
                remainingLabel
        );

        statusPanel.add(
                Box.createVerticalStrut(15)
        );


        statusPanel.add(
                new JLabel(
                        "Battery Level"
                )
        );

        batteryBar =
                new JProgressBar(
                        0,
                        100
                );

        batteryBar.setStringPainted(true);

        statusPanel.add(
                batteryBar
        );


        statusPanel.add(
                Box.createVerticalStrut(15)
        );


        statusPanel.add(
                new JLabel(
                        "Storage Capacity"
                )
        );

        capacityBar =
                new JProgressBar(
                        0,
                        100
                );

        capacityBar.setStringPainted(true);

        statusPanel.add(
                capacityBar
        );


        statusPanel.add(
                Box.createVerticalStrut(15)
        );

        statusPanel.add(
                antiGravityLabel
        );


        // RIGHT ITEMS PANEL

        JPanel itemsPanel =
                new JPanel(
                        new BorderLayout()
                );

        itemsPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Items Inside Aero Pack"
                )
        );


        itemModel =
                new DefaultListModel<>();

        itemList =
                new JList<>(itemModel);

        itemList.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        itemsPanel.add(
                new JScrollPane(
                        itemList
                ),
                BorderLayout.CENTER
        );


        dashboard.add(
                statusPanel
        );

        dashboard.add(
                itemsPanel
        );


        add(
                dashboard,
                BorderLayout.CENTER
        );
    }


    // =====================================
    // CONTROL BUTTONS
    // =====================================

    private void createControls() {

        JPanel controls =
                new JPanel(
                        new GridLayout(
                                2,
                                4,
                                10,
                                10
                        )
                );


        controls.setBorder(
                new EmptyBorder(
                        10,
                        20,
                        20,
                        20
                )
        );


        JButton unlock =
                new JButton(
                        "Biometric Unlock"
                );

        JButton addItem =
                new JButton(
                        "Add Item"
                );

        JButton removeItem =
                new JButton(
                        "Remove Item"
                );

        JButton locateItem =
                new JButton(
                        "AI Item Locator"
                );

        JButton antiGravity =
                new JButton(
                        "Toggle Anti-Gravity"
                );

        JButton solarCharge =
                new JButton(
                        "Solar Charge"
                );

        JButton lock =
                new JButton(
                        "Lock Aero Pack"
                );

        JButton information =
                new JButton(
                        "Refresh Status"
                );


        unlock.addActionListener(
                e -> unlockBag()
        );

        addItem.addActionListener(
                e -> addItem()
        );

        removeItem.addActionListener(
                e -> removeItem()
        );

        locateItem.addActionListener(
                e -> locateItem()
        );

        antiGravity.addActionListener(
                e -> toggleAntiGravity()
        );

        solarCharge.addActionListener(
                e -> solarCharge()
        );

        lock.addActionListener(
                e -> lockBag()
        );

        information.addActionListener(
                e -> refreshStatus()
        );


        controls.add(unlock);
        controls.add(addItem);
        controls.add(removeItem);
        controls.add(locateItem);

        controls.add(antiGravity);
        controls.add(solarCharge);
        controls.add(lock);
        controls.add(information);


        add(
                controls,
                BorderLayout.SOUTH
        );
    }


    // =====================================
    // BIOMETRIC SECURITY
    // =====================================

    private void unlockBag() {

        String scan =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Biometric ID:"
                );

        if (scan == null) {
            return;
        }

        bag.biometricUnlock(scan);

        if (!bag.isLocked()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Biometric accepted.\nAero Pack unlocked."
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "ACCESS DENIED!\nInvalid biometric ID.",
                    "Security",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        refreshStatus();
    }


    // =====================================
    // ADD ITEM
    // =====================================

    private void addItem() {

        if (bag.isLocked()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unlock the Aero Pack first."
            );

            return;
        }


        String item =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Item Name:"
                );


        if (item == null ||
                item.trim().isEmpty()) {

            return;
        }


        String weightInput =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Item Weight (kg):"
                );


        try {

            float weight =
                    Float.parseFloat(
                            weightInput
                    );


            float previousWeight =
                    bag.getCurrentWeight();


            bag.addItem(
                    item,
                    weight
            );


            if (
                    bag.getCurrentWeight()
                    >
                    previousWeight
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        item
                        +
                        " added successfully."
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to add item."
                );
            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid weight."
            );
        }


        refreshStatus();
    }


    // =====================================
    // REMOVE ITEM
    // =====================================

    private void removeItem() {

        if (bag.isLocked()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unlock the Aero Pack first."
            );

            return;
        }


        String item =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Item Name:"
                );


        if (item == null) {
            return;
        }


        String weightInput =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Item Weight (kg):"
                );


        try {

            float weight =
                    Float.parseFloat(
                            weightInput
                    );

            bag.removeItem(
                    item,
                    weight
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid weight."
            );
        }


        refreshStatus();
    }


    // =====================================
    // AI ITEM LOCATOR
    // =====================================

    private void locateItem() {

        String item =
                JOptionPane.showInputDialog(
                        this,
                        "What item should AI search for?"
                );


        if (item == null) {
            return;
        }


        boolean found =
                bag.locateItem(item);


        if (found) {

            JOptionPane.showMessageDialog(
                    this,
                    "AI SCAN COMPLETE\n\n"
                    +
                    item
                    +
                    " detected inside Aero Pack."
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "AI SCAN COMPLETE\n\n"
                    +
                    item
                    +
                    " was not detected."
            );
        }
    }


    // =====================================
    // ANTI-GRAVITY
    // =====================================

    private void toggleAntiGravity() {

        if (
                bag.isAntiGravityActive()
        ) {

            bag.deactivateAntiGravity();

            JOptionPane.showMessageDialog(
                    this,
                    "Anti-Gravity Mode Deactivated"
            );

        } else {

            bag.activateAntiGravity();

            if (
                    bag.isAntiGravityActive()
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Anti-Gravity Mode Activated!\n"
                        +
                        "Carried weight reduced by 70%."
                );
            }
        }


        refreshStatus();
    }


    // =====================================
    // SOLAR CHARGE
    // =====================================

    private void solarCharge() {

        String inputMinutes =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Solar Charging Time (minutes):"
                );


        try {

            int minutes =
                    Integer.parseInt(
                            inputMinutes
                    );

            bag.solarCharge(
                    minutes
            );

            refreshStatus();

            JOptionPane.showMessageDialog(
                    this,
                    "Solar charging complete.\n"
                    +
                    "Battery: "
                    +
                    bag.getBatteryLevel()
                    +
                    "%"
            );


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid charging time."
            );
        }
    }


    // =====================================
    // LOCK
    // =====================================

    private void lockBag() {

        bag.lock();

        JOptionPane.showMessageDialog(
                this,
                "Aero Pack successfully locked."
        );

        refreshStatus();
    }


    // =====================================
    // REFRESH GUI
    // =====================================

    private void refreshStatus() {

        ownerLabel.setText(
                "Owner: "
                +
                bag.getOwner()
        );


        if (bag.isLocked()) {

            statusLabel.setText(
                    "Security Status: LOCKED"
            );

            statusLabel.setForeground(
                    Color.RED
            );

        } else {

            statusLabel.setText(
                    "Security Status: UNLOCKED"
            );

            statusLabel.setForeground(
                    new Color(
                            0,
                            140,
                            60
                    )
            );
        }


        weightLabel.setText(
                String.format(
                        "Actual Weight: %.2f kg",
                        bag.getCurrentWeight()
                )
        );


        effectiveWeightLabel.setText(
                String.format(
                        "Weight Felt: %.2f kg",
                        bag.getEffectiveWeight()
                )
        );


        remainingLabel.setText(
                String.format(
                        "Remaining Capacity: %.2f kg",
                        bag.remainingCapacity()
                )
        );


        batteryBar.setValue(
                bag.getBatteryLevel()
        );

        batteryBar.setString(
                bag.getBatteryLevel()
                +
                "%"
        );


        int usedPercentage =
                (int) (
                        (
                            bag.getCurrentWeight()
                            /
                            bag.getCapacity()
                        )
                        *
                        100
                );


        capacityBar.setValue(
                usedPercentage
        );


        capacityBar.setString(
                String.format(
                        "%.2f / %.2f kg",
                        bag.getCurrentWeight(),
                        bag.getCapacity()
                )
        );


        if (
                bag.isAntiGravityActive()
        ) {

            antiGravityLabel.setText(
                    "Anti-Gravity: ACTIVE"
            );

        } else {

            antiGravityLabel.setText(
                    "Anti-Gravity: OFF"
            );
        }


        itemModel.clear();


        for (
                String item :
                bag.getItems()
        ) {

            itemModel.addElement(
                    item
            );
        }
    }


    // =====================================
    // MAIN
    // =====================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () ->
                        new AeroPackGUI()
        );
    }
}