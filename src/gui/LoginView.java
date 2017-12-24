package gui;

import db.ConnectAccess;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static LoginView window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginView();
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
	public LoginView() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("登录界面");
		
		JPanel loginPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_login.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		loginPanel.setBounds(0, 0, 584, 412);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		JButton loginBtn = new JButton("\u767B  \u5F55");
		loginBtn.setBackground(new Color(255, 165, 0));
		loginBtn.setFont(new Font("楷体", Font.BOLD, 24));
		loginBtn.setBounds(160, 265, 265, 35);
		loginPanel.add(loginBtn);
		ActionListener al1 = new loginBtnListener();
		loginBtn.addActionListener(al1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/res/avatar.jpg")));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(160, 170, 30, 30);
		loginPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/res/lock.jpg")));
		label.setBackground(Color.RED);
		label.setBounds(160, 200, 30, 30);
		loginPanel.add(label);
		
		textField = new JTextField();
		textField.setBounds(190, 169, 235, 31);
		loginPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 200, 235, 31);
		loginPanel.add(textField_1);
		
	}
	
	private class loginBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String cardNum = textField.getText();
			String password= textField_1.getText();
			String judgeUser = cardNum.substring(0, 1);
	    	String passwordFromDatabase = "";
			
			if(cardNum.equals("")){
				JOptionPane.showMessageDialog(null, "请输入一卡通号", "错误提示", JOptionPane.ERROR_MESSAGE); 
				return;
			}
			
			if(password.equals("")){
				JOptionPane.showMessageDialog(null, "请输入密码", "错误提示", JOptionPane.ERROR_MESSAGE); 
				return;
			}
			
			if(cardNum.length() != 9){
				JOptionPane.showMessageDialog(null, "请输入9位一卡通号", "错误提示", JOptionPane.ERROR_MESSAGE); 
				return;
			}
			
			if (!cardNum.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "一卡通号中含非法字符，请重新输入", "错误提示", JOptionPane.ERROR_MESSAGE); 
				return;
			}
			
			try {
				Boolean resultFlag = true;
				
				ConnectAccess ca = new ConnectAccess();
				ca.ConnectAccessFile();
				
				ca.stmt = ca.conn.prepareStatement("SELECT * FROM user WHERE cardNum = ?");
				ca.stmt.setString(1, cardNum);
		    	ca.rs = ca.stmt.executeQuery();
		    	
		    	while (ca.rs.next()) {
		    		passwordFromDatabase = ca.rs.getString(2);
		    		//System.out.println(passwordFromDatabase);
		        }
		    	
		    	if (password.equals(passwordFromDatabase)) {
		    		
		    		if (judgeUser.equals("1")) {
		    			resultFlag = false;
		    			ProfSelfView.main(cardNum);
						window.frame.setVisible(false);
		    		}
		    		else if (judgeUser.equals("2")) {
		    			resultFlag = false;
		    			StuSelfView.main(cardNum);
						window.frame.setVisible(false);
		    		}
		    		else {
		    			resultFlag = false;
		    			AdminView.main(null);
						window.frame.setVisible(false);
		    		}
		    	}
		    	
		    	ca.rs.close();
		    	ca.stmt.close();
		    	ca.conn.close();
				
				if (resultFlag) {
					JOptionPane.showMessageDialog(null, "一卡通号或密码错误", "错误提示", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
