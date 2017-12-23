package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseView {

	private JFrame frame;
	private JTextField courseCnoTextField;
	private JTextField courseSectnoTextField;
	private JTextField courseDeptTextField;
	private JTextField courseProfTextField;
	private JTextField courseNumTextField;
	private JButton courseStuInfoBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseView window = new CourseView();
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
	public CourseView() {
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
		
		JPanel coursePanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_06.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		coursePanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(coursePanel);
		coursePanel.setLayout(null);
		
		JLabel courseCnoLabel = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		courseCnoLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		courseCnoLabel.setBounds(90, 145, 116, 30);
		coursePanel.add(courseCnoLabel);
		
		courseCnoTextField = new JTextField();
		courseCnoTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		courseCnoTextField.setEditable(false);
		courseCnoTextField.setColumns(10);
		courseCnoTextField.setBounds(215, 140, 200, 40);
		coursePanel.add(courseCnoTextField);
		
		JLabel courseSectnoLabel = new JLabel("\u5F00\u73ED\u53F7\uFF1A");
		courseSectnoLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		courseSectnoLabel.setBounds(90, 326, 116, 30);
		coursePanel.add(courseSectnoLabel);
		
		courseSectnoTextField = new JTextField();
		courseSectnoTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		courseSectnoTextField.setEditable(false);
		courseSectnoTextField.setColumns(10);
		courseSectnoTextField.setBounds(215, 320, 200, 40);
		coursePanel.add(courseSectnoTextField);
		
		JLabel courseDeptLabel = new JLabel("\u5F00\u8BFE\u9662\u7CFB\uFF1A");
		courseDeptLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		courseDeptLabel.setBounds(90, 237, 130, 30);
		coursePanel.add(courseDeptLabel);
		
		courseDeptTextField = new JTextField();
		courseDeptTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		courseDeptTextField.setEditable(false);
		courseDeptTextField.setColumns(10);
		courseDeptTextField.setBounds(215, 230, 200, 40);
		coursePanel.add(courseDeptTextField);
		
		JLabel courseProfLabel = new JLabel("\u4EFB\u8BFE\u6559\u6388\uFF1A");
		courseProfLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		courseProfLabel.setBounds(480, 237, 130, 30);
		coursePanel.add(courseProfLabel);
		
		courseProfTextField = new JTextField();
		courseProfTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		courseProfTextField.setEditable(false);
		courseProfTextField.setColumns(10);
		courseProfTextField.setBounds(600, 230, 200, 40);
		coursePanel.add(courseProfTextField);
		
		JLabel courseNumLabel = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		courseNumLabel.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		courseNumLabel.setBounds(480, 145, 116, 30);
		coursePanel.add(courseNumLabel);
		
		courseNumTextField = new JTextField();
		courseNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		courseNumTextField.setEditable(false);
		courseNumTextField.setColumns(10);
		courseNumTextField.setBounds(600, 140, 200, 40);
		coursePanel.add(courseNumTextField);
		
		courseStuInfoBtn = new JButton("\u67E5\u770B\u9009\u4FEE\u8BE5\u8BFE\u5B66\u751F\u4FE1\u606F");
		courseStuInfoBtn.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		courseStuInfoBtn.setBounds(501, 461, 299, 55);
		coursePanel.add(courseStuInfoBtn);
		
		JButton courseLastBtn = new JButton("\u4E0A\u4E00\u9875");
		courseLastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		courseLastBtn.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		courseLastBtn.setBounds(105, 461, 152, 55);
		coursePanel.add(courseLastBtn);
		
		JButton courseNextBtn = new JButton("\u4E0B\u4E00\u9875");
		courseNextBtn.setFont(new Font("ËÎÌå", Font.BOLD, 25));
		courseNextBtn.setBounds(303, 461, 152, 55);
		coursePanel.add(courseNextBtn);
	}
}
