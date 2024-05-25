// Author: 
// Nama    : Muh. Reza
// Nim     : 13020220070
// Kelas   : A2

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {
    private JTextField heightField, weightField, resultField;
    private JButton calculateButton;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Tinggi (cm):"));
        heightField = new JTextField();
        panel.add(heightField);

        panel.add(new JLabel("Berat (kg):"));
        weightField = new JTextField();
        panel.add(weightField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel.add(calculateButton);

        panel.add(new JLabel(""));
        resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double height = Double.parseDouble(heightField.getText()) / 100; // Mengubah cm menjadi m
                double weight = Double.parseDouble(weightField.getText());

                double bmi = weight / (height * height);

                String category;
                if (bmi < 18.5)
                    category = "Kekurangan Berat Badan";
                else if (bmi < 25)
                    category = "Normal";
                else if (bmi < 30)
                    category = "Kelebihan Berat badan";
                else if (bmi < 35)
                    category = "Obesitas kelas 1";
                else if (bmi < 40)
                    category = "Obesitas Kelas 2";
                else
                    category = "Obesitas kelas 3";

                // Set the result to the resultField
                resultField.setText("BMI: " + String.format("%.2f", bmi) + " - " + category);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for height and weight.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculator());
    }
}
