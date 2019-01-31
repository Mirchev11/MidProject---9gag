package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAPost {

	private JFrame frame;
	private JTextField filePath;
	private JTextField description;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAPost window = new CreateAPost();
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
	public CreateAPost() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPastePath = new JLabel("Paste path");
		lblPastePath.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPastePath.setBounds(10, 44, 100, 23);
		frame.getContentPane().add(lblPastePath);
		
		filePath = new JTextField();
		filePath.setBounds(99, 44, 249, 25);
		frame.getContentPane().add(filePath);
		filePath.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Upload a post");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setBounds(10, 0, 249, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setBounds(10, 89, 100, 23);
		frame.getContentPane().add(lblDescription);
		
		description = new JTextField();
		description.setBounds(99, 92, 249, 57);
		frame.getContentPane().add(description);
		description.setColumns(10);
		
		JLabel tags = new JLabel("Tags");
		tags.setFont(new Font("Tahoma", Font.BOLD, 15));
		tags.setBounds(10, 236, 87, 23);
		frame.getContentPane().add(tags);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(99, 237, 249, 25);
		frame.getContentPane().add(textField_2);
		
		JCheckBox chckbxIsThisSensitive = new JCheckBox("This is sensitive");
		chckbxIsThisSensitive.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxIsThisSensitive.setBounds(47, 289, 138, 23);
		frame.getContentPane().add(chckbxIsThisSensitive);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuForLoggedUsers9gag.main();
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(SystemColor.activeCaptionBorder);
		btnNewButton.setBackground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(238, 319, 110, 31);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 78, 448, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 220, 448, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 280, 458, 2);
		frame.getContentPane().add(separator_2);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					Post post = new Post(null, null, null, false);
//				} catch (NotLoggedInException e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "Please log in!", "Unloged user", JOptionPane.ERROR_MESSAGE);
//				}
				
			}
		});
		btnUpload.setForeground(SystemColor.text);
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpload.setBackground(SystemColor.textHighlight);
		btnUpload.setBounds(358, 319, 110, 31);
		frame.getContentPane().add(btnUpload);
		
		JLabel section = new JLabel("Section");
		section.setFont(new Font("Tahoma", Font.BOLD, 15));
		section.setBounds(10, 186, 87, 23);
		frame.getContentPane().add(section);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 186, 249, 23);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}
