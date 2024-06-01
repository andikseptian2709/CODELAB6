import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    private static JFrame mainFrame;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JLabel messageLabel;

    public static void main(String[] args) {
        mainFrame = new JFrame("Login");
        mainFrame.setSize(300, 150);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4, 1));

        // Username field
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        usernamePanel.add(usernameField);
        mainFrame.add(usernamePanel);

        // Password field
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);
        mainFrame.add(passwordPanel);

        // Login button
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        buttonPanel.add(loginButton);
        mainFrame.add(buttonPanel);

        // Message label
        messageLabel = new JLabel("", JLabel.CENTER);
        mainFrame.add(messageLabel);

        mainFrame.setVisible(true);
    }

    private static class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                // Login successful
                mainFrame.dispose();
                showSuccessPage();
            } else {
                // Login failed
                messageLabel.setText("Username / Password salah");
                messageLabel.setForeground(Color.RED);
            }
        }

        private void showSuccessPage() {
            JFrame successFrame = new JFrame("Success");
            successFrame.setSize(300, 150);
            successFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            successFrame.add(new JLabel("Login Berhasil!", JLabel.CENTER));
            successFrame.setVisible(true);
        }
    }
}
