package NineGagProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import javafx.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuForLoggedUsers9gag {


		private JFrame frame;
		private JTextField textField;

	    
		/**
		 * Launch the application.
		 */
		public static void main() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuForLoggedUsers9gag window = new MenuForLoggedUsers9gag();
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
		public MenuForLoggedUsers9gag() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() { //startova stranica na 9gag
			
			Border emptyBorder = BorderFactory.createEmptyBorder();
			
			frame = new JFrame();
			frame.getContentPane().setForeground(Color.GRAY);
			frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
			frame.setBounds(200, 200, 500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlText);
			panel.setBounds(0, 0, 484, 38);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(139, 14, 124, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblSearch = new JLabel("Search");
			lblSearch.setForeground(Color.GRAY);
			lblSearch.setBounds(93, 17, 46, 14);
			panel.add(lblSearch);
			
			JButton btnUpload = new JButton("+ Upload");
			btnUpload.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					CreateAPost.main();
					frame.setVisible(false);
				}
			});
			btnUpload.setBackground(SystemColor.textHighlight);
			btnUpload.setForeground(SystemColor.text);
			btnUpload.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnUpload.setBounds(385, 13, 99, 23);
			panel.add(btnUpload);
			btnUpload.setBorder(emptyBorder);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(SystemColor.controlText);
			menuBar.setBounds(273, 14, 97, 21);
			panel.add(menuBar);
			menuBar.setBorder(emptyBorder);
			
			JMenu mnNewMenu = new JMenu("    Profile     ");
			mnNewMenu.setBackground(SystemColor.desktop);
			mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
			menuBar.add(mnNewMenu);
			
			JButton btnMyProfile = new JButton("My profile");
			mnNewMenu.add(btnMyProfile);
//			btnMyProfile.setBorder(emptyBorder);
			JButton btnSettings = new JButton("Settings   ");
			btnSettings.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				}
			});
			mnNewMenu.add(btnSettings);
//			btnSettings.setBorder(emptyBorder);
			JButton btnLogout = new JButton("Logout     ");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MenuFor9gag.main();
					frame.setVisible(false);
					
					
				}
			});
			mnNewMenu.add(btnLogout);
//			btnLogout.setBorder(emptyBorder);
			

			
			JLabel lblNewLabel = new JLabel("9gag");
			lblNewLabel.setBounds(0, 0, 93, 31);
			panel.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBackground(Color.WHITE);

			
			
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 38, 87, 423);
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
			btnHot.setBorder(emptyBorder);
			
			
			JButton btnFresh = new JButton("Fresh");
			btnFresh.setBackground(SystemColor.menu);
			btnFresh.setBounds(0, 41, 89, 23);
			panel_1.add(btnFresh);
			btnFresh.setBorder(emptyBorder);
			
			JButton btnTrending = new JButton("Trending");
			btnTrending.setBounds(0, 21, 89, 23);
			panel_1.add(btnTrending);
			btnTrending.setBackground(SystemColor.menu);
			btnTrending.setBorder(emptyBorder);
			
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setForeground(SystemColor.textHighlight);
			scrollBar.setBounds(457, 42, 17, 408);
			frame.getContentPane().add(scrollBar);
			
		
		}
}
