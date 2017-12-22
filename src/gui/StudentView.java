package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class StudentView {

	private JFrame frame;
	private JTextField stuNameTextField;
	private JLabel stuNumLabel;
	private JTextField stuNumTextField;
	private JLabel stuSexLabel;
	private JTextField sexSexTextField;
	private JLabel stuAgeLabel;
	private JTextField stuAgeTextField;
	private JLabel stuGpaLabel;
	private JTextField stuGpaTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView window = new StudentView();
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
	public StudentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel stuInfoPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_04.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		stuInfoPanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(stuInfoPanel);
		stuInfoPanel.setLayout(null);
		
		JLabel stuNameLabel = new JLabel("\u59D3\u540D\uFF1A");
		stuNameLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		stuNameLabel.setBounds(125, 135, 103, 30);
		stuInfoPanel.add(stuNameLabel);
		
		stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		stuNumLabel.setBounds(500, 135, 103, 30);
		stuInfoPanel.add(stuNumLabel);
		
		stuNameTextField = new JTextField();
		stuNameTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		stuNameTextField.setBounds(200, 130, 200, 40);
		stuInfoPanel.add(stuNameTextField);
		stuNameTextField.setColumns(10);
		stuNameTextField.setEditable(false);
		
		stuNumTextField = new JTextField();
		stuNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		stuNumTextField.setEditable(false);
		stuNumTextField.setColumns(10);
		stuNumTextField.setBounds(575, 130, 200, 40);
		stuInfoPanel.add(stuNumTextField);
		
		stuSexLabel = new JLabel("\u6027\u522B\uFF1A");
		stuSexLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		stuSexLabel.setBounds(125, 215, 103, 30);
		stuInfoPanel.add(stuSexLabel);
		
		sexSexTextField = new JTextField();
		sexSexTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		sexSexTextField.setEditable(false);
		sexSexTextField.setColumns(10);
		sexSexTextField.setBounds(200, 210, 200, 40);
		stuInfoPanel.add(sexSexTextField);
		
		stuAgeLabel = new JLabel("\u5E74\u9F84\uFF1A");
		stuAgeLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		stuAgeLabel.setBounds(500, 215, 103, 30);
		stuInfoPanel.add(stuAgeLabel);
		
		stuAgeTextField = new JTextField();
		stuAgeTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		stuAgeTextField.setEditable(false);
		stuAgeTextField.setColumns(10);
		stuAgeTextField.setBounds(575, 210, 200, 40);
		stuInfoPanel.add(stuAgeTextField);
		
		stuGpaLabel = new JLabel("\u7EE9\u70B9\uFF1A");
		stuGpaLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		stuGpaLabel.setBounds(125, 294, 103, 30);
		stuInfoPanel.add(stuGpaLabel);
		
		stuGpaTextField = new JTextField();
		stuGpaTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		stuGpaTextField.setEditable(false);
		stuGpaTextField.setColumns(10);
		stuGpaTextField.setBounds(200, 290, 200, 40);
		stuInfoPanel.add(stuGpaTextField);
		
		table = new JTable();
		table.setBounds(125, 414, 650, 139);
		stuInfoPanel.add(table);
		
		JLabel label = new JLabel("\u9009\u8BFE\u4FE1\u606F\uFF1A");
		label.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label.setBounds(125, 374, 174, 30);
		stuInfoPanel.add(label);
		
		
		
	}
}
