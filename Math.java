package week1;

import javax.swing.JOptionPane;

public class Math {
    public static void main(String[] args) {
        double num1, num2;
        num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter your first number: "));
        num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter your second number: "));
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        JOptionPane.showMessageDialog(null,
                "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuotient: " + quotient);
        System.exit(0);
    }
}
