import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private String storedPassword = null;

    public Main() {
        JFrame frame = new JFrame("Locker Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JTextField passwordField = new JTextField();
        JLabel statusLabel = new JLabel();
        JButton clearButton = new JButton("Clear");
        JButton enterButton = new JButton("Enter");

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> passwordField.setText(passwordField.getText() + button.getText()));
            panel.add(button);
        }

        clearButton.addActionListener(e -> passwordField.setText(""));
        enterButton.addActionListener(e -> {
            if (storedPassword == null) {
                storedPassword = passwordField.getText();
                statusLabel.setText("Password Set");
                passwordField.setText("");

            } else {
                if (passwordField.getText().equals(storedPassword)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(passwordField, BorderLayout.NORTH);
        frame.add(clearButton, BorderLayout.WEST);
        frame.add(enterButton, BorderLayout.EAST);
        frame.add(statusLabel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
