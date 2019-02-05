package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import NineGagProject.Settings.Genders;
import javax.swing.JScrollBar;
import NineGagProject.Settings.Statuses;
import NineGagProject.Settings.Countries;

public class SettingsWindow {

	private JFrame frame;
	private JTextField emailField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField txtYyyy;
	private JTextField txtMm;
	private JTextField txtDd;
	private JTextField txtSomeFunnyThings;
	private static User us;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsWindow window = new SettingsWindow(us);
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
	
	public SettingsWindow() {
		initialize();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	
	
	

	public SettingsWindow(User us){
		this();
		this.us = us;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 450, 1100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(53, -3, 287, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(63, 58, 89, 19);
		frame.getContentPane().add(lblUsername);
		
		emailField = new JTextField();
		emailField.setBounds(66, 153, 274, 26);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(63, 123, 89, 19);
		frame.getContentPane().add(lblEmail);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(66, 86, 274, 26);
		frame.getContentPane().add(usernameField);
		
		JButton deleteAccountBtn = new JButton("Delete account");
		deleteAccountBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteAccountBtn.setBounds(63, 190, 122, 19);
		frame.getContentPane().add(deleteAccountBtn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 228, 414, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(63, 228, 270, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewPassword.setBounds(63, 279, 89, 19);
		frame.getContentPane().add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 304, 267, 26);
		frame.getContentPane().add(passwordField);
		
		JLabel lblRetypePassword = new JLabel("Re-type New Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRetypePassword.setBounds(63, 334, 156, 19);
		frame.getContentPane().add(lblRetypePassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(73, 360, 267, 26);
		frame.getContentPane().add(passwordField_1);
		
		JButton saveChangesAcc = new JButton("Save changes");
		saveChangesAcc.setForeground(SystemColor.text);
		saveChangesAcc.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveChangesAcc.setBackground(SystemColor.textHighlight);
		saveChangesAcc.setBounds(224, 190, 116, 26);
		frame.getContentPane().add(saveChangesAcc);
		
		JButton saveChangesPass = new JButton("Save changes");
		saveChangesPass.setForeground(Color.WHITE);
		saveChangesPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveChangesPass.setBackground(SystemColor.textHighlight);
		saveChangesPass.setBounds(56, 402, 116, 26);
		frame.getContentPane().add(saveChangesPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 439, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYourName.setBounds(47, 591, 89, 19);
		frame.getContentPane().add(lblYourName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(49, 621, 274, 26);
		frame.getContentPane().add(textField);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProfile.setBounds(53, 439, 270, 50);
		frame.getContentPane().add(lblProfile);
		
		JList list = new JList();
		list.setBounds(106, 602, 1, 1);
		frame.getContentPane().add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(3);
		comboBox.setBackground(SystemColor.text);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(Genders.values()));
		comboBox.setBounds(47, 688, 75, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblStatus = new JLabel("Gender");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(47, 658, 89, 19);
		frame.getContentPane().add(lblStatus);
		
		JLabel lblStatus_1 = new JLabel("Status");
		lblStatus_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus_1.setBounds(47, 710, 89, 19);
		frame.getContentPane().add(lblStatus_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Statuses.values()));
		comboBox_1.setMaximumRowCount(25);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBackground(SystemColor.text);
		comboBox_1.setBounds(47, 740, 105, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBirthday.setBounds(47, 771, 89, 19);
		frame.getContentPane().add(lblBirthday);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		txtYyyy.setBounds(47, 801, 105, 26);
		frame.getContentPane().add(txtYyyy);
		txtYyyy.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setText("MM");
		txtMm.setColumns(10);
		txtMm.setBounds(162, 801, 75, 26);
		frame.getContentPane().add(txtMm);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setColumns(10);
		txtDd.setBounds(247, 801, 75, 26);
		frame.getContentPane().add(txtDd);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCountry.setBounds(53, 838, 89, 19);
		frame.getContentPane().add(lblCountry);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(Countries.values()));
		comboBox_2.setMaximumRowCount(25);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(53, 868, 105, 20);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblTellPeopleWho = new JLabel("Tell people who you are");
		lblTellPeopleWho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTellPeopleWho.setBounds(63, 899, 191, 19);
		frame.getContentPane().add(lblTellPeopleWho);
		
		txtSomeFunnyThings = new JTextField();
		txtSomeFunnyThings.setText("Some funny things about you");
		txtSomeFunnyThings.setBounds(53, 929, 274, 82);
		frame.getContentPane().add(txtSomeFunnyThings);
		txtSomeFunnyThings.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(417, -1, 17, 1062);
		frame.getContentPane().add(scrollBar);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
