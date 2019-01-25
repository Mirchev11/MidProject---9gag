package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_System {

	private JFrame frame;
	private JTextField EmailField;
	private JPasswordField passwordField;
	private JFrame frmLoginSystem;
	private static NineGag site;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System(site);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System(NineGag site) {
		initialize();
		Login_System.site = site;
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(148, 11, 117, 26);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 70, 70, 20);
		frame.getContentPane().add(lblEmail);
		
		EmailField = new JTextField();
		EmailField.setBounds(115, 70, 213, 20);
		frame.getContentPane().add(EmailField);
		EmailField.setColumns(10);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 160, 70, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 157, 213, 20);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 464, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 205, 464, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordField.getText();
				String email = EmailField.getText();
				if(site.checkIfUserExists(email)) {
					if(site.checkIfPasswordIsCorrect(email, password)) {
						JOptionPane.showMessageDialog(null, "You logged in successfully", "Logged in!", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				} else {
				JOptionPane.showMessageDialog(null, "Invalid loggin details!", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(35, 205, 89, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setBounds(176, 205, 89, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(332, 205, 89, 45);
		frame.getContentPane().add(btnNewButton_2);
		
	}

}
