import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JTextArea rentalsArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarRentalSystem::new);
    }

    public CarRentalSystem() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Car Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        // Title panel
        JLabel titleLabel = new JLabel("Car Rental Management", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(50, 50, 50));
        frame.add(titleLabel, BorderLayout.NORTH);
        
        // Tabbed Pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabbedPane.addTab("Add Rental", createAddRentalPanel());
        tabbedPane.addTab("View Rentals", createViewRentalsPanel());
        
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel createAddRentalPanel() {
        JPanel addPanel = new JPanel(new GridBagLayout());
        addPanel.setBackground(new Color(240, 240, 240));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input fields
        JTextField customerNameField = new JTextField(15);
        JTextField carModelField = new JTextField(15);
        JTextField rentalDateField = new JTextField(15);
        JTextField returnDateField = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        addPanel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        addPanel.add(customerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(new JLabel("Car Model:"), gbc);
        gbc.gridx = 1;
        addPanel.add(carModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(new JLabel("Rental Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        addPanel.add(rentalDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(new JLabel("Return Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        addPanel.add(returnDateField, gbc);

        // Save button
        JButton saveButton = new JButton("Save Rental");
        saveButton.setBackground(new Color(0, 123, 255));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.addActionListener(e -> {
            String customerName = customerNameField.getText();
            String carModel = carModelField.getText();
            String rentalDate = rentalDateField.getText();
            String returnDate = returnDateField.getText();
            saveRentalRecord(customerName, carModel, rentalDate, returnDate);
            clearFields(customerNameField, carModelField, rentalDateField, returnDateField);
        });

        gbc.gridx = 1;
        gbc.gridy = 4;
        addPanel.add(saveButton, gbc);

        return addPanel;
    }

    private JPanel createViewRentalsPanel() {
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBackground(new Color(240, 240, 240));

        // Text Area for Displaying Rentals
        rentalsArea = new JTextArea();
        rentalsArea.setEditable(false);
        rentalsArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        rentalsArea.setBackground(Color.WHITE);
        rentalsArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(rentalsArea);
        viewPanel.add(scrollPane, BorderLayout.CENTER);

        // Load existing rentals
        loadRentalRecords();

        return viewPanel;
    }

    private void saveRentalRecord(String customerName, String carModel, String rentalDate, String returnDate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rentals.txt", true))) {
            writer.write(customerName + "," + carModel + "," + rentalDate + "," + returnDate);
            writer.newLine();
            JOptionPane.showMessageDialog(frame, "Rental added successfully.");

            // Refresh the View Rentals tab
            loadRentalRecords();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving rental.");
        }
    }

    private void loadRentalRecords() {
        List<String> rentals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("rentals.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rentals.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder rentalsText = new StringBuilder("Customer Name\tCar Model\tRental Date\tReturn Date\n");
        for (String rental : rentals) {
            rentalsText.append(rental.replace(",", "\t")).append("\n");
        }
        rentalsArea.setText(rentalsText.toString());
    }

    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}
