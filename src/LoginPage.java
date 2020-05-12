import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
		setBounds(100, 100, 439, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(186, 12, 61, 35);
		contentPane.add(lblLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("users.txt");
				String password = new String(pfPassword.getPassword());
				boolean login = false;
				
				if(tfUsername.getText().equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all input !");
					return;
				}
				
				try {
					Scanner scanner = new Scanner(new BufferedReader(new FileReader("users.txt")));
					
					while(scanner.hasNextLine()) {
						String userInfo = scanner.nextLine();
						String[] array = userInfo.split(" ");
						
						if(array[0].equals(tfUsername.getText()) && array[1].equals(password)) {
							
							 login = true;
						}
						
					}
					if(login) {
						TableSelection tableSelection = new TableSelection();
						setVisible(false);
						tableSelection.setVisible(true);
						return;
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter correct username or password !");
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(164, 107, 114, 25);
		contentPane.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(81, 53, 85, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(81, 80, 85, 15);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(164, 51, 114, 19);
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
		btnRegister.setBounds(313, 107, 114, 25);
		contentPane.add(btnRegister);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(164, 78, 114, 19);
		contentPane.add(pfPassword);
	}
}
