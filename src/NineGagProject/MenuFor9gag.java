package NineGagProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFormattedTextField;

public class MenuFor9gag {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFor9gag window = new MenuFor9gag();
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
	public MenuFor9gag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //startova stranica na 9gag
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.GRAY);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.setBounds(200, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("9gag");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 93, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlText);
		panel.setBounds(0, 0, 484, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm.main();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(385, 11, 89, 23);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login_System.main();
				frame.setVisible(false);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setForeground(SystemColor.activeCaptionBorder);
		btnLogin.setBackground(SystemColor.desktop);
		btnLogin.setBounds(296, 11, 89, 23);
		panel.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(162, 14, 124, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.GRAY);
		lblSearch.setBounds(121, 17, 46, 14);
		panel.add(lblSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 42, 93, 419);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSections = new JLabel("Sections");
		lblSections.setForeground(Color.LIGHT_GRAY);
		lblSections.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSections.setBounds(10, 75, 93, 27);
		panel_1.add(lblSections);
		
		JButton btnHot = new JButton("Hot");
		btnHot.setBackground(SystemColor.menu);
		btnHot.setBounds(0, 0, 89, 23);
		panel_1.add(btnHot);
		
		JButton btnTrending = new JButton("Trending");
		btnTrending.setBackground(SystemColor.menu);
		btnTrending.setBounds(0, 21, 89, 23);
		panel_1.add(btnTrending);
		
		JButton btnFresh = new JButton("Fresh");
		btnFresh.setBackground(SystemColor.menu);
		btnFresh.setBounds(0, 41, 89, 23);
		panel_1.add(btnFresh);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(SystemColor.textHighlight);
		scrollBar.setBounds(457, 42, 17, 408);
		frame.getContentPane().add(scrollBar);
	}
}
