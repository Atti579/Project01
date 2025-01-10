import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Login Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel backgroundPanel1 = new BackgroundPanel("loginpagefootball.jpeg");
        backgroundPanel1.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JTextField userText = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordText = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel1.add(userLabel, gbc);

        gbc.gridx = 1;
        backgroundPanel1.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel1.add(passwordLabel, gbc);

        gbc.gridx = 1;
        backgroundPanel1.add(passwordText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        backgroundPanel1.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if ("Real Madrid".equals(username) && "admin".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");

                    dispose();

                    SwingUtilities.invokeLater(() -> {
                        HomePage homePage = new HomePage();
                        homePage.setVisible(true);
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        setContentPane(backgroundPanel1);
    }


    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
