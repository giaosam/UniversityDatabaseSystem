package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("µÇÂ¼½çÃæ");
		
		JPanel loginPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_login.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		loginPanel.setBounds(0, 0, 584, 412);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JButton loginBtn = new JButton("\u767B  \u5F55");
		loginBtn.setBackground(new Color(255, 165, 0));
		loginBtn.setFont(new Font("¿¬Ìå", Font.BOLD, 24));
		loginBtn.setBounds(160, 265, 265, 35);
		loginPanel.add(loginBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/res/avatar.jpg")));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(160, 170, 30, 30);
		loginPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/res/lock.jpg")));
		label.setBackground(Color.RED);
		label.setBounds(160, 200, 30, 30);
		loginPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(190, 169, 235, 31);
		loginPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 200, 235, 31);
		loginPanel.add(textField_1);
		
	}
}
