package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.ConnectAccess;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;

public class DeptCourseView {

	private JFrame frame;
	private JTextField deptNameTextFiled;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String deptName;
	private int pageCnt = 0;
	private int resultSize = 0;
	private List<String[]> resultList = new ArrayList<String[]>();

	/**
	 * Launch the application.
	 */
	public static void main(final String deptName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeptCourseView window = new DeptCourseView(deptName);
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
	public DeptCourseView(String deptNames) {
		deptName = deptNames;
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
		
		JPanel deptCoursePanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_07.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
		};    
		deptCoursePanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(deptCoursePanel);
		deptCoursePanel.setLayout(null);
		
		// 显示当前学院名称，可设为常量值。
		deptNameTextFiled = new JTextField();
		deptNameTextFiled.setBackground(Color.WHITE);
		deptNameTextFiled.setFont(new Font("宋体", Font.PLAIN, 20));
		deptNameTextFiled.setEditable(false);
		deptNameTextFiled.setColumns(10);
		deptNameTextFiled.setBounds(640, 80, 200, 40);
		deptCoursePanel.add(deptNameTextFiled);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label.setBounds(100, 180, 116, 30);
		deptCoursePanel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(215, 175, 200, 40);
		deptCoursePanel.add(textField);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_1.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_1.setBounds(495, 180, 116, 30);
		deptCoursePanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(615, 175, 200, 40);
		deptCoursePanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(615, 295, 200, 40);
		deptCoursePanel.add(textField_2);
		
		JLabel label_2 = new JLabel("\u4EFB\u8BFE\u6559\u6388\uFF1A");
		label_2.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_2.setBounds(495, 300, 130, 30);
		deptCoursePanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5F00\u73ED\u53F7\uFF1A");
		label_3.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_3.setBounds(100, 300, 116, 30);
		deptCoursePanel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(215, 295, 200, 40);
		deptCoursePanel.add(textField_3);
		
		JButton deptCourseLastBtn = new JButton("\u4E0A\u4E00\u9875");
		deptCourseLastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pageCnt == 0) {
					JOptionPane.showMessageDialog(null, "已经是第一个课程", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pageCnt -= 1;
				displayInfo(pageCnt);
			}
		});
		deptCourseLastBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptCourseLastBtn.setBounds(100, 438, 152, 55);
		deptCoursePanel.add(deptCourseLastBtn);
		
		JButton deptCourseNextBtn = new JButton("\u4E0B\u4E00\u9875");
		deptCourseNextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pageCnt == resultSize-1) {
					JOptionPane.showMessageDialog(null, "已经是最后一个课程", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pageCnt += 1;
				displayInfo(pageCnt);
			}
		});
		deptCourseNextBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptCourseNextBtn.setBounds(298, 438, 152, 55);
		deptCoursePanel.add(deptCourseNextBtn);
		
		JButton deptCourseStuBtn = new JButton("\u67E5\u770B\u9009\u4FEE\u8BE5\u8BFE\u5B66\u751F\u4FE1\u606F");
		deptCourseStuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DeptCourseView.main(deptName);
			}
		});
		deptCourseStuBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptCourseStuBtn.setBounds(496, 438, 299, 55);
		deptCoursePanel.add(deptCourseStuBtn);
		
		try {	
		    ConnectAccess ca = new ConnectAccess();
		    ca.ConnectAccessFile();
		
		    ca.stmt = ca.conn.prepareStatement("SELECT * FROM courseInfo WHERE dname = ?");
		    ca.stmt.setString(1, deptName);
    	    ca.rs = ca.stmt.executeQuery();
    	    
    	    while (ca.rs.next()) {
    		   String[] tempRow = new String[4];
    		   tempRow[0] = ca.rs.getString(2);
    		   tempRow[1] = ca.rs.getString(3);
    		   tempRow[2] = ca.rs.getString(4);
    		   tempRow[3] = ca.rs.getString(6);
    		   resultList.add(tempRow);
            }
    	    
    	    deptNameTextFiled.setText(deptName);
    	    resultSize = resultList.size();
    	    displayInfo(pageCnt);
    	    	
    	    ca.rs.close();
    	    ca.stmt.close();
    	    ca.conn.close();
    	
	    } catch (Exception e1) {
		     // TODO Auto-generated catch block
		     e1.printStackTrace();
	    }
	}
	
	private void displayInfo(int pageCnt) {
		String[] courseInfo = resultList.get(pageCnt);
	    textField.setText(courseInfo[0]);
	    textField_1.setText(courseInfo[2]);
	    textField_2.setText(courseInfo[3]);
	    textField_3.setText(courseInfo[1]);
	}
}
