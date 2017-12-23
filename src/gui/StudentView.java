package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StudentView {

	private JFrame frame;
	private JTextField stuGpaTextField;
	private JTextField stuNameTextField;
	private JTextField stuSexTextField;
	private JTextField stuAgeTextField;
	private JTextField stuNumTextField;

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
	 * 这是管理员可以看到的学生信息视图: 可以查看所有学生基本信息
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel stuInfoPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_05.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		stuInfoPanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(stuInfoPanel);
		stuInfoPanel.setLayout(null);
		
		stuGpaTextField = new JTextField();
		stuGpaTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuGpaTextField.setEditable(false);
		stuGpaTextField.setColumns(10);
		stuGpaTextField.setBounds(184, 335, 200, 40);
		stuInfoPanel.add(stuGpaTextField);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label.setBounds(109, 190, 103, 30);
		stuInfoPanel.add(label);
		
		stuNameTextField = new JTextField();
		stuNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNameTextField.setEditable(false);
		stuNameTextField.setColumns(10);
		stuNameTextField.setBounds(184, 185, 200, 40);
		stuInfoPanel.add(stuNameTextField);
		
		stuSexTextField = new JTextField();
		stuSexTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuSexTextField.setEditable(false);
		stuSexTextField.setColumns(10);
		stuSexTextField.setBounds(184, 260, 200, 40);
		stuInfoPanel.add(stuSexTextField);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_1.setBounds(109, 265, 103, 30);
		stuInfoPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u7EE9\u70B9\uFF1A");
		label_2.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_2.setBounds(109, 340, 103, 30);
		stuInfoPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		label_3.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_3.setBounds(484, 265, 103, 30);
		stuInfoPanel.add(label_3);
		
		stuAgeTextField = new JTextField();
		stuAgeTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuAgeTextField.setEditable(false);
		stuAgeTextField.setColumns(10);
		stuAgeTextField.setBounds(559, 260, 200, 40);
		stuInfoPanel.add(stuAgeTextField);
		
		stuNumTextField = new JTextField();
		stuNumTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNumTextField.setEditable(false);
		stuNumTextField.setColumns(10);
		stuNumTextField.setBounds(559, 185, 200, 40);
		stuInfoPanel.add(stuNumTextField);
		
		JLabel label_4 = new JLabel("\u5B66\u53F7\uFF1A");
		label_4.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_4.setBounds(484, 190, 103, 30);
		stuInfoPanel.add(label_4);
		
		JButton stuLastBtn = new JButton("\u4E0A\u4E00\u9875");
		stuLastBtn.setFont(new Font("宋体", Font.BOLD, 25));
		stuLastBtn.setBounds(409, 462, 152, 45);
		stuInfoPanel.add(stuLastBtn);
		
		JButton stuNextBtn = new JButton("\u4E0B\u4E00\u9875");
		stuNextBtn.setFont(new Font("宋体", Font.BOLD, 25));
		stuNextBtn.setBounds(607, 462, 152, 45);
		stuInfoPanel.add(stuNextBtn);
	}
}
