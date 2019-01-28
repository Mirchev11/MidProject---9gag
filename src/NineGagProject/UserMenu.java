package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class UserMenu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu window = new UserMenu();
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
	public UserMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(200, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserMenu = new JLabel("User Menu");
		lblUserMenu.setForeground(SystemColor.desktop);
		lblUserMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUserMenu.setBounds(187, 11, 176, 43);
		frame.getContentPane().add(lblUserMenu);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(10, 65, 564, 7);
		frame.getContentPane().add(separator);
		
		JButton uploadButton = new JButton("Upload");
		uploadButton.setBackground(SystemColor.textHighlight);
		uploadButton.setForeground(SystemColor.text);
		uploadButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		uploadButton.setBounds(20, 83, 144, 54);
		frame.getContentPane().add(uploadButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBackground(SystemColor.textHighlight);
		settingsButton.setForeground(SystemColor.text);
		settingsButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		settingsButton.setBounds(210, 83, 144, 54);
		frame.getContentPane().add(settingsButton);
		
		JButton profileButton = new JButton("Profile");
		profileButton.setBackground(SystemColor.textHighlight);
		profileButton.setForeground(SystemColor.text);
		profileButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		profileButton.setBounds(402, 83, 144, 54);
		frame.getContentPane().add(profileButton);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(457, 299, 89, 23);
		frame.getContentPane().add(logoutButton);
		
		textField = new JTextField();
		textField.setBounds(116, 163, 292, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(20, 163, 86, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Hot");
		btnNewButton_4.setForeground(SystemColor.textHighlight);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBackground(SystemColor.text);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(152, 246, 132, 36);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton button = new JButton("Sections");
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBackground(SystemColor.text);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 246, 132, 36);
		frame.getContentPane().add(button);
		
		JButton btnTrending = new JButton("Trending");
		btnTrending.setForeground(SystemColor.textHighlight);
		btnTrending.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTrending.setBackground(SystemColor.text);
		btnTrending.setBounds(294, 246, 132, 36);
		frame.getContentPane().add(btnTrending);
		
		JButton btnFresh = new JButton("Fresh");
		btnFresh.setForeground(SystemColor.textHighlight);
		btnFresh.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFresh.setBackground(SystemColor.text);
		btnFresh.setBounds(436, 246, 132, 36);
		frame.getContentPane().add(btnFresh);
	}
}
