import javax.swing.*;
import java.awt.*;

public class Q7_main extends JFrame {

    JTextField display;
    String firstNumber = "";
    String operator = "";
    boolean newInput = true;

    public Q7_main() {
        setTitle("Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(Color.BLUE);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(300, 60));

        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 8, 8));
        panel.setBackground(Color.BLUE);
        panel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        String[] buttons = {
                "+", "-", "*", "/",
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "0", ".", "C",
                "", "=", "", ""
        };

        for (String text : buttons) {
            if (text.isEmpty()) {
                panel.add(new JLabel());
            } else {
                JButton button = new JButton(text);
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.setBackground(Color.LIGHT_GRAY);
                button.setForeground(Color.BLACK);

                button.addActionListener(e -> handleButton(text));
                panel.add(button);
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    void handleButton(String text) {

        if (text.equals("C")) {
            display.setText("");
            firstNumber = "";
            operator = "";
            newInput = true;

        } else if (text.matches("[0-9.]")) {

            if (newInput) {
                display.setText(text);
                newInput = false;
            } else {
                display.setText(display.getText() + text);
            }

        } else if (text.matches("[+*/-]")) {

            if (!display.getText().isEmpty()) {
                firstNumber = display.getText();
                operator = text;
                display.setText(firstNumber + " " + operator + " ");
                newInput = false;
            }

        } else if (text.equals("=")) {

            try {
                String[] parts = display.getText().trim().split("\\s+");

                if (parts.length == 3) {
                    double a = Double.parseDouble(parts[0]);
                    double b = Double.parseDouble(parts[2]);
                    double result = 0;

                    switch (parts[1]) {
                        case "+":
                            result = a + b;
                            break;

                        case "-":
                            result = a - b;
                            break;

                        case "*":
                            result = a * b;
                            break;

                        case "/":
                            if (b == 0) {
                                display.setText("Cannot divide by zero");
                                newInput = true;
                                return;
                            }
                            result = a / b;
                            break;
                    }

                    display.setText(parts[0] + " " + parts[1] + " "
                            + parts[2] + " = " + result);

                    newInput = true;
                }

            } catch (Exception ex) {
                display.setText("Invalid Input");
                newInput = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Q7_main());
    }
}
