import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JPasswordField pfConfirmPassword;
	private DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblRegisterPage = new JLabel("Register Page");
		lblRegisterPage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegisterPage.setBounds(153, 12, 142, 22);
		contentPane.add(lblRegisterPage);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(153, 46, 142, 19);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 48, 84, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 87, 84, 15);
		contentPane.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password = new String(pfPassword.getPassword());
				String confirmPassword = new String(pfConfirmPassword.getPassword());
				
				if(password.equals(confirmPassword)) {
					
					databaseManager.addAccount(username, password);
					JOptionPane.showMessageDialog(null, "Register successful !");
				}
				else if(username.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill username input !");
				}
				else if(password.equals("") || confirmPassword.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill all password fields !");
				}
				else {
					JOptionPane.showMessageDialog(null, "Passwords are not match !");
				}
			}
		});
		btnRegister.setBounds(324, 82, 113, 25);
		contentPane.add(btnRegister);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(12, 132, 133, 15);
		contentPane.add(lblConfirmPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(153, 85, 142, 19);
		contentPane.add(pfPassword);
		
		pfConfirmPassword = new JPasswordField();
		pfConfirmPassword.setBounds(153, 130, 142, 19);
		contentPane.add(pfConfirmPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage loginPage = new LoginPage();
				setVisible(false);
				loginPage.setVisible(true);
			}
		});
		btnBack.setBounds(324, 127, 117, 25);
		contentPane.add(btnBack);
	}
}
