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
import javax.swing.JButton;

public class StudentView {

	private JFrame frame;
	private JTextField stuGpaTextField;
	private JTextField stuNameTextField;
	private JTextField stuSexTextField;
	private JTextField stuAgeTextField;
	private JTextField stuNumTextField;
	private int pageCnt = 0;
	private int resultSize = 0;
	private List<String[]> resultList = new ArrayList<String[]>();

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		stuLastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pageCnt == 0) {
					JOptionPane.showMessageDialog(null, "已经是第一名学生", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pageCnt -= 1;
				displayInfo(pageCnt);
			}
		});
		stuLastBtn.setFont(new Font("宋体", Font.BOLD, 25));
		stuLastBtn.setBounds(409, 462, 152, 45);
		stuInfoPanel.add(stuLastBtn);
		
		JButton stuNextBtn = new JButton("\u4E0B\u4E00\u9875");
		stuNextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pageCnt == resultSize-1) {
					JOptionPane.showMessageDialog(null, "已经是最后一名学生", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pageCnt += 1;
				displayInfo(pageCnt);
			}
		});
		stuNextBtn.setFont(new Font("宋体", Font.BOLD, 25));
		stuNextBtn.setBounds(607, 462, 152, 45);
		stuInfoPanel.add(stuNextBtn);
		
		try {	
			ConnectAccess ca = new ConnectAccess();
			ca.ConnectAccessFile();
			
			ca.stmt = ca.conn.prepareStatement("SELECT * FROM student");
	    	ca.rs = ca.stmt.executeQuery();
	    		    	
	    	while (ca.rs.next()) {
	    		String[] tempRow = new String[5];
	    		tempRow[0] = ca.rs.getString(7);
	    		tempRow[1] = ca.rs.getString(2);
	    		tempRow[2] = ca.rs.getString(3);
	    		tempRow[3] = ca.rs.getString(4);
	    		tempRow[4] = ca.rs.getString(6);
	    		resultList.add(tempRow);
	        }
	    	
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
		stuNumTextField.setText(courseInfo[0]);
		stuNameTextField.setText(courseInfo[1]);
		stuSexTextField.setText(courseInfo[2]);
		stuAgeTextField.setText(courseInfo[3]);
		stuGpaTextField.setText(courseInfo[4]);
	}
}
