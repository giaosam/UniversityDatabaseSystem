package gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import db.ConnectAccess;

import javax.swing.JButton;

public class DeptView {

	private JFrame frame;
	private JTextField deptNameTextField;
	private JTextField textField;
	private int deptid = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeptView window = new DeptView();
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
	public DeptView() {
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
		
		JPanel profPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_02.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
		};    
		profPanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(profPanel);
		profPanel.setLayout(null);
		
		JLabel deptNameLabel = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		deptNameLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		deptNameLabel.setBounds(110, 185, 130, 30);
		profPanel.add(deptNameLabel);
		
		deptNameTextField = new JTextField();
		deptNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		deptNameTextField.setEditable(false);
		deptNameTextField.setColumns(10);
		deptNameTextField.setBounds(250, 180, 388, 40);
		profPanel.add(deptNameTextField);
		
		JLabel deptDcNumLabel = new JLabel("\u535A\u58EB\u751F\u6570\uFF1A");
		deptDcNumLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		deptDcNumLabel.setBounds(110, 305, 130, 30);
		profPanel.add(deptDcNumLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(250, 300, 388, 40);
		profPanel.add(textField);
		
		JButton deptLastBtn = new JButton("\u4E0A\u4E00\u9875");
		deptLastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deptid == 1) {
					JOptionPane.showMessageDialog(null, "已经是第一个学院", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				deptid -= 1;
				getInfo(deptid);
			}
		});
		deptLastBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptLastBtn.setBounds(110, 480, 152, 55);
		profPanel.add(deptLastBtn);
		
		JButton deptNextBtn = new JButton("\u4E0B\u4E00\u9875");
		deptNextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deptid == 6) {
					JOptionPane.showMessageDialog(null, "已经是最后一个学院", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				deptid += 1;
				getInfo(deptid);
			}
		});
		deptNextBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptNextBtn.setBounds(308, 480, 152, 55);
		profPanel.add(deptNextBtn);
		
		JButton deptCourseBtn = new JButton("\u67E5\u770B\u5B66\u9662\u5F00\u8BFE\u60C5\u51B5");
		deptCourseBtn.setFont(new Font("宋体", Font.BOLD, 25));
		deptCourseBtn.setBounds(506, 480, 299, 55);
		profPanel.add(deptCourseBtn);
		
		getInfo(deptid);
	}
	
    private void getInfo(int deptIdToCheck) {
		
        try {	
			ConnectAccess ca = new ConnectAccess();
			ca.ConnectAccessFile();
			
			ca.stmt = ca.conn.prepareStatement("SELECT * FROM dept WHERE deptid = ?");
			ca.stmt.setInt(1, deptIdToCheck);
	    	ca.rs = ca.stmt.executeQuery();
	    		    	
	    	while (ca.rs.next()) {
	    		deptNameTextField.setText(ca.rs.getString(1));
	    		textField.setText(ca.rs.getString(2));
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
