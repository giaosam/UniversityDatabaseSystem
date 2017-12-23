package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class AdminView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
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
		
		JPanel homePagePanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_01.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		homePagePanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(homePagePanel);
		homePagePanel.setLayout(null);
		
		// 跳转到新页面: 显示所有学生基本信息
		JButton adminStuInfoBtn = new JButton("", new ImageIcon("src\\res\\adminStuBtn.jpg"));
		adminStuInfoBtn.setBounds(269, 151, 128, 128);
		homePagePanel.add(adminStuInfoBtn);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u67E5\u770B");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(265, 289, 150, 31);
		homePagePanel.add(lblNewLabel);
		
		// 跳转到新页面: 显示所有课程信息
		JButton adminCourseBtn = new JButton("", new ImageIcon("src\\res\\adminCourseBtn.jpg"));
		adminCourseBtn.setBounds(580, 151, 128, 128);
		homePagePanel.add(adminCourseBtn);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u4FE1\u606F\u67E5\u770B");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		label.setBounds(575, 289, 150, 31);
		homePagePanel.add(label);
		
		// 跳转到新页面: 显示所有教授信息
		JButton adminProfBtn = new JButton("", new ImageIcon("src\\res\\adminProfBtn.jpg"));
		adminProfBtn.setBounds(269, 360, 128, 128);
		homePagePanel.add(adminProfBtn);
		
		JLabel label_1 = new JLabel("\u6559\u6388\u4FE1\u606F\u67E5\u770B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 23));
		label_1.setBounds(265, 495, 150, 31);
		homePagePanel.add(label_1);
		
		// 跳转到新页面: 显示所有学院信息
		JButton adminCollegeBtn = new JButton("", new ImageIcon("src\\res\\adminCollegeBtn.jpg"));
		adminCollegeBtn.setBounds(580, 360, 128, 128);
		homePagePanel.add(adminCollegeBtn);
		
		JLabel label_2 = new JLabel("\u5B66\u9662\u4FE1\u606F\u67E5\u770B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 23));
		label_2.setBounds(575, 495, 150, 31);
		homePagePanel.add(label_2);
	}
}
