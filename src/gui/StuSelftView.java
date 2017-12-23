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

public class StuSelftView {

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
					StuSelftView window = new StuSelftView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 这是学生用户可以看到的视图:
	 */
	public StuSelftView() {
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
		stuNameLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuNameLabel.setBounds(125, 145, 103, 30);
		stuInfoPanel.add(stuNameLabel);
		
		stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuNumLabel.setBounds(500, 145, 103, 30);
		stuInfoPanel.add(stuNumLabel);
		
		// 显示学生姓名的JTextView:
		stuNameTextField = new JTextField();
		stuNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNameTextField.setBounds(200, 140, 200, 40);
		stuInfoPanel.add(stuNameTextField);
		stuNameTextField.setColumns(10);
		stuNameTextField.setEditable(false);
		
		// 显示学号的JTextView:
		stuNumTextField = new JTextField();
		stuNumTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNumTextField.setEditable(false);
		stuNumTextField.setColumns(10);
		stuNumTextField.setBounds(575, 140, 200, 40);
		stuInfoPanel.add(stuNumTextField);
		
		stuSexLabel = new JLabel("\u6027\u522B\uFF1A");
		stuSexLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuSexLabel.setBounds(125, 225, 103, 30);
		stuInfoPanel.add(stuSexLabel);
		
		// 显示性别的JTextView:
		sexSexTextField = new JTextField();
		sexSexTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		sexSexTextField.setEditable(false);
		sexSexTextField.setColumns(10);
		sexSexTextField.setBounds(200, 220, 200, 40);
		stuInfoPanel.add(sexSexTextField);
		
		stuAgeLabel = new JLabel("\u5E74\u9F84\uFF1A");
		stuAgeLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuAgeLabel.setBounds(500, 225, 103, 30);
		stuInfoPanel.add(stuAgeLabel);
		
		// 显示年龄的JTextView:
		stuAgeTextField = new JTextField();
		stuAgeTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuAgeTextField.setEditable(false);
		stuAgeTextField.setColumns(10);
		stuAgeTextField.setBounds(575, 220, 200, 40);
		stuInfoPanel.add(stuAgeTextField);
		
		stuGpaLabel = new JLabel("\u7EE9\u70B9\uFF1A");
		stuGpaLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuGpaLabel.setBounds(125, 305, 103, 30);
		stuInfoPanel.add(stuGpaLabel);
		
		// 显示绩点的JTextView:
		stuGpaTextField = new JTextField();
		stuGpaTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuGpaTextField.setEditable(false);
		stuGpaTextField.setColumns(10);
		stuGpaTextField.setBounds(200, 300, 200, 40);
		stuInfoPanel.add(stuGpaTextField);
		
		table = new JTable();
		table.setBounds(125, 414, 650, 139);
		stuInfoPanel.add(table);
		
		JLabel label = new JLabel("\u9009\u8BFE\u4FE1\u606F\uFF1A");
		label.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label.setBounds(125, 374, 174, 30);
		stuInfoPanel.add(label);
	}
}
