package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;

import db.ConnectAccess;

public class StuSelfView {

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
	private String cardNum;

	/**
	 * Launch the application.
	 */
	public static void main(final String cardNum) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuSelfView window = new StuSelfView(cardNum);
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
	public StuSelfView(String cardNums) {
		cardNum = cardNums;
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
		stuNameLabel.setBounds(125, 165, 103, 30);
		stuInfoPanel.add(stuNameLabel);
		
		stuNumLabel = new JLabel("\u5B66\u53F7\uFF1A");
		stuNumLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuNumLabel.setBounds(500, 165, 103, 30);
		stuInfoPanel.add(stuNumLabel);
		
		// 显示学生姓名的JTextView:
		stuNameTextField = new JTextField();
		stuNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNameTextField.setBounds(200, 160, 200, 40);
		stuInfoPanel.add(stuNameTextField);
		stuNameTextField.setColumns(10);
		stuNameTextField.setEditable(false);
		
		// 显示学号的JTextView:
		stuNumTextField = new JTextField();
		stuNumTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuNumTextField.setEditable(false);
		stuNumTextField.setColumns(10);
		stuNumTextField.setBounds(575, 160, 200, 40);
		stuInfoPanel.add(stuNumTextField);
		
		stuSexLabel = new JLabel("\u6027\u522B\uFF1A");
		stuSexLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuSexLabel.setBounds(125, 240, 103, 30);
		stuInfoPanel.add(stuSexLabel);
		
		// 显示性别的JTextView:
		sexSexTextField = new JTextField();
		sexSexTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		sexSexTextField.setEditable(false);
		sexSexTextField.setColumns(10);
		sexSexTextField.setBounds(200, 235, 200, 40);
		stuInfoPanel.add(sexSexTextField);
		
		stuAgeLabel = new JLabel("\u5E74\u9F84\uFF1A");
		stuAgeLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuAgeLabel.setBounds(500, 240, 103, 30);
		stuInfoPanel.add(stuAgeLabel);
		
		// 显示年龄的JTextView:
		stuAgeTextField = new JTextField();
		stuAgeTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuAgeTextField.setEditable(false);
		stuAgeTextField.setColumns(10);
		stuAgeTextField.setBounds(575, 235, 200, 40);
		stuInfoPanel.add(stuAgeTextField);
		
		stuGpaLabel = new JLabel("\u7EE9\u70B9\uFF1A");
		stuGpaLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		stuGpaLabel.setBounds(125, 315, 103, 30);
		stuInfoPanel.add(stuGpaLabel);
		
		// 显示绩点的JTextView:
		stuGpaTextField = new JTextField();
		stuGpaTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		stuGpaTextField.setEditable(false);
		stuGpaTextField.setColumns(10);
		stuGpaTextField.setBounds(200, 310, 200, 40);
		stuInfoPanel.add(stuGpaTextField);
		
		JLabel label = new JLabel("\u9009\u8BFE\u4FE1\u606F\uFF1A");
		label.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label.setBounds(125, 390, 174, 30);
		stuInfoPanel.add(label);
		
		try {
			String sid = "";
			
			ConnectAccess ca = new ConnectAccess();
			ca.ConnectAccessFile();
			
			ca.stmt = ca.conn.prepareStatement("SELECT * FROM student WHERE cardNum = ?");
			ca.stmt.setString(1, cardNum);
	    	ca.rs = ca.stmt.executeQuery();
	    	
	    	while (ca.rs.next()) {
	    		stuNumTextField.setText(cardNum);
	    		sid = ca.rs.getString(1);
	    		stuNameTextField.setText(ca.rs.getString(2));
	    		sexSexTextField.setText(ca.rs.getString(3));
	    		stuAgeTextField.setText(ca.rs.getString(4));
	    		stuGpaTextField.setText(ca.rs.getString(6));
	        }
	    	    	
	    	ca.rs.close();
	    	ca.stmt.close();
	    	
	    	ca.stmt = ca.conn.prepareStatement("SELECT * FROM enroll WHERE sid = ?");
			ca.stmt.setString(1, sid);
	    	ca.rs = ca.stmt.executeQuery();
	    	
	    	int cnt = 0;
	    	String[][] data = new String[3][4];
	    	while (ca.rs.next()) {
	    		data[cnt][0] = ca.rs.getString(4);
	    		data[cnt][1] = ca.rs.getString(5);
	    		data[cnt][2] = ca.rs.getString(2);
	    		data[cnt][3] = ca.rs.getString(3);
	    		cnt += 1;
	        }
	    	
	    	String[][] displayData = new String[cnt][4];
	    	for (int i = 0; i < cnt; i++) {
	    		for (int j = 0; j < 4; j++) {
	    			displayData[i][j] = data[i][j];
	    		}
	    	}
	    	
	    	ca.rs.close();
	    	ca.stmt.close();
	    	ca.conn.close();
	    	
	    	String[] columnNames = { "First", "Last", "Sport", "Years"};
	    	table = new JTable(data, columnNames);
			table.setFillsViewportHeight(true);
			table.setPreferredScrollableViewportSize(new Dimension(500, 400));
			table.setBounds(125, 435, 650, 139);
			
			JScrollPane scrollPane = new JScrollPane(table);
			stuInfoPanel.add(scrollPane);stuInfoPanel.add(table);
	    	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		Object[][] data = {
//				                  { "Kathy", "Smith", "Snowboarding", new Integer(5),
//				                          new Boolean(false) },
//				                  { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
//				                  { "Sue", "Black", "Knitting", new Integer(2),
//				                          new Boolean(false) },
//				                  { "Jane", "White", "Speed reading", new Integer(20),
//				                          new Boolean(true) },
//				                  { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } 
//				          };	
	}
}
