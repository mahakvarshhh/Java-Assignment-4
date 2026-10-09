import java.awt.*;
import java.awt.event.*;

public class Q6_main extends Frame implements ActionListener {

    Label heading, nameLabel, rollLabel, courseLabel;
    TextField nameField, rollField, courseField;
    Button saveButton, clearButton;

    Color dark = new Color(35, 35, 35);
    Color yellow = new Color(255, 215, 0);
    Color blue = new Color(40, 120, 220);
    Color red = new Color(220, 55, 55);
    Color white = Color.WHITE;

    Q6_main() {
        setTitle("Student Registration Form");
        setSize(500, 420);
        setLayout(null);
        setBackground(dark);

        heading = new Label("STUDENT REGISTRATION FORM",
                Label.CENTER);
        heading.setBounds(30, 45, 430, 45);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(yellow);
        add(heading);

        nameLabel = new Label("Student Name:");
        nameLabel.setBounds(60, 125, 120, 30);
        nameLabel.setForeground(white);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(200, 125, 220, 30);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(nameField);

        rollLabel = new Label("Roll Number:");
        rollLabel.setBounds(60, 180, 120, 30);
        rollLabel.setForeground(white);
        rollLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(rollLabel);

        rollField = new TextField();
        rollField.setBounds(200, 180, 220, 30);
        rollField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(rollField);

        courseLabel = new Label("Course:");
        courseLabel.setBounds(60, 235, 120, 30);
        courseLabel.setForeground(white);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(courseLabel);

        courseField = new TextField();
        courseField.setBounds(200, 235, 220, 30);
        courseField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(courseField);

        saveButton = new Button("Save Details");
        saveButton.setBounds(85, 310, 145, 40);
        saveButton.setBackground(blue);
        saveButton.setForeground(white);
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.addActionListener(this);
        add(saveButton);

        clearButton = new Button("Clear All");
        clearButton.setBounds(265, 310, 145, 40);
        clearButton.setBackground(red);
        clearButton.setForeground(white);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(this);
        add(clearButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String name = nameField.getText().trim();
            String roll = rollField.getText().trim();
            String course = courseField.getText().trim();

            if (name.isEmpty() || roll.isEmpty()
                    || course.isEmpty()) {
                showMessage("Please fill in all the details.");
                return;
            }

            showMessage("REGISTRATION SUCCESSFUL!\n\n"
                    + "Student Name: " + name + "\n"
                    + "Roll Number: " + roll + "\n"
                    + "Course: " + course);
        }

        if (e.getSource() == clearButton) {
            nameField.setText("");
            rollField.setText("");
            courseField.setText("");
            nameField.requestFocus();
        }
    }

    void showMessage(String message) {
        Dialog dialog = new Dialog(this, "Registration Details", true);
        dialog.setLayout(new BorderLayout());

        TextArea details = new TextArea(message, 6, 35,
                TextArea.SCROLLBARS_NONE);
        details.setEditable(false);
        dialog.add(details, BorderLayout.CENTER);

        Button ok = new Button("OK");
        ok.addActionListener(e -> dialog.dispose());
        dialog.add(ok, BorderLayout.SOUTH);

        dialog.setSize(380, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Q6_main::new);
    }
}
