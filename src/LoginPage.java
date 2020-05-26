import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(158, 12, 61, 35);
		contentPane.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password = new String(pfPassword.getPassword());
				
				if(databaseManager.login(username, password)) {
					TableSelection tableSelection = new TableSelection();
					setVisible(false);
					tableSelection.setVisible(true);
				}
				else if(username.equals("") || password.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill all input !");
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or password incorrect !");
				}
			}
		});
		btnLogin.setBounds(37, 254, 142, 25);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setBounds(37, 179, 103, 35);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(37, 207, 103, 35);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Dialog", Font.PLAIN, 16));
		tfUsername.setBounds(158, 179, 197, 28);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterPage registerPage = new RegisterPage();
				setVisible(false);
				registerPage.setVisible(true);
			}
		});
		btnRegister.setBounds(223, 254, 142, 25);
		contentPane.add(btnRegister);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Dialog", Font.PLAIN, 16));
		pfPassword.setBounds(158, 211, 197, 28);
		contentPane.add(pfPassword);
		
		JLabel lblLoginPicture = new JLabel("");
		lblLoginPicture.setBounds(144, 59, 125, 108);
		contentPane.add(lblLoginPicture);
		ImageIcon restaurantLogo = new ImageIcon("./images/restaurant.png");
		lblLoginPicture.setIcon(restaurantLogo);
	}
}
