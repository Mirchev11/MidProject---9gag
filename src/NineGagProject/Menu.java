package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu { //purvonachalno menu, koeto moje da se lognesh ili regnesh, vika nishki

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(350, 350, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("Welcome to our 9gag");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMenu.setBounds(110, 11, 394, 50);
		frame.getContentPane().add(lblMenu);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(10, 72, 564, 2);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread login = new Thread(new LoginUser());
				login.start();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(35, 118, 165, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread createUser = new Thread(new CreateUser());
				createUser.start();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(254, 118, 165, 62);
		frame.getContentPane().add(btnNewButton_1);
	}
}
