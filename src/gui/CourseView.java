package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import db.ConnectAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseView {

	private JFrame frame;
	private JTextField courseCnoTextField;
	private JTextField courseSectnoTextField;
	private JTextField courseDeptTextField;
	private JTextField courseProfTextField;
	private JTextField courseCnameTextField;
	private JButton courseStuInfoBtn;
	private int cid = 1;

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		courseCnoLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		courseCnoLabel.setBounds(90, 145, 116, 30);
		coursePanel.add(courseCnoLabel);
		
		courseCnoTextField = new JTextField();
		courseCnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		courseCnoTextField.setEditable(false);
		courseCnoTextField.setColumns(10);
		courseCnoTextField.setBounds(215, 140, 200, 40);
		coursePanel.add(courseCnoTextField);
		
		JLabel courseSectnoLabel = new JLabel("\u5F00\u73ED\u53F7\uFF1A");
		courseSectnoLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		courseSectnoLabel.setBounds(90, 326, 116, 30);
		coursePanel.add(courseSectnoLabel);
		
		courseSectnoTextField = new JTextField();
		courseSectnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		courseSectnoTextField.setEditable(false);
		courseSectnoTextField.setColumns(10);
		courseSectnoTextField.setBounds(215, 320, 200, 40);
		coursePanel.add(courseSectnoTextField);
		
		JLabel courseDeptLabel = new JLabel("\u5F00\u8BFE\u9662\u7CFB\uFF1A");
		courseDeptLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		courseDeptLabel.setBounds(90, 237, 130, 30);
		coursePanel.add(courseDeptLabel);
		
		courseDeptTextField = new JTextField();
		courseDeptTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		courseDeptTextField.setEditable(false);
		courseDeptTextField.setColumns(10);
		courseDeptTextField.setBounds(215, 230, 200, 40);
		coursePanel.add(courseDeptTextField);
		
		JLabel courseProfLabel = new JLabel("\u4EFB\u8BFE\u6559\u6388\uFF1A");
		courseProfLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		courseProfLabel.setBounds(480, 237, 130, 30);
		coursePanel.add(courseProfLabel);
		
		courseProfTextField = new JTextField();
		courseProfTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		courseProfTextField.setEditable(false);
		courseProfTextField.setColumns(10);
		courseProfTextField.setBounds(600, 230, 200, 40);
		coursePanel.add(courseProfTextField);
		
		JLabel courseCnameLabel = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		courseCnameLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		courseCnameLabel.setBounds(480, 145, 116, 30);
		coursePanel.add(courseCnameLabel);
		
		courseCnameTextField = new JTextField();
		courseCnameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		courseCnameTextField.setEditable(false);
		courseCnameTextField.setColumns(10);
		courseCnameTextField.setBounds(600, 140, 200, 40);
		coursePanel.add(courseCnameTextField);
		
		// 跳转到StudentView界面。
		courseStuInfoBtn = new JButton("\u67E5\u770B\u9009\u4FEE\u8BE5\u8BFE\u5B66\u751F\u4FE1\u606F");
		courseStuInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		courseStuInfoBtn.setFont(new Font("宋体", Font.BOLD, 25));
		courseStuInfoBtn.setBounds(501, 461, 299, 55);
		coursePanel.add(courseStuInfoBtn);
		
		JButton courseLastBtn = new JButton("\u4E0A\u4E00\u9875");
		courseLastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cid == 1) {
					JOptionPane.showMessageDialog(null, "已经是第一个课程", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cid -= 1;
				getInfo(cid);
			}
		});
		courseLastBtn.setFont(new Font("宋体", Font.BOLD, 25));
		courseLastBtn.setBounds(105, 461, 152, 55);
		coursePanel.add(courseLastBtn);
		
		JButton courseNextBtn = new JButton("\u4E0B\u4E00\u9875");
		courseNextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cid == 13) {
					JOptionPane.showMessageDialog(null, "已经是最后一个课程", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cid += 1;
				getInfo(cid);
			}
		});
		courseNextBtn.setFont(new Font("宋体", Font.BOLD, 25));
		courseNextBtn.setBounds(303, 461, 152, 55);
		coursePanel.add(courseNextBtn);
		
		getInfo(cid);
	}
	
    private void getInfo(int cidToCheck) {
		
        try {	
			ConnectAccess ca = new ConnectAccess();
			ca.ConnectAccessFile();
			
			ca.stmt = ca.conn.prepareStatement("SELECT * FROM courseInfo WHERE cid = ?");
			ca.stmt.setInt(1, cidToCheck);
	    	ca.rs = ca.stmt.executeQuery();
	    		    	
	    	while (ca.rs.next()) {
	    		courseCnoTextField.setText(ca.rs.getString(4));
	    		courseSectnoTextField.setText(ca.rs.getString(3));
	    		courseDeptTextField.setText(ca.rs.getString(5));
	    		courseProfTextField.setText(ca.rs.getString(6));
	    		courseCnameTextField.setText(ca.rs.getString(2));
	    		//System.out.println(passwordFromDatabase);
	        }
	    	    	
	    	ca.rs.close();
	    	ca.stmt.close();
	    	ca.conn.close();
	    	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
