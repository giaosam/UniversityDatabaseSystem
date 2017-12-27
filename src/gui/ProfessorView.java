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

public class ProfessorView {

	private JFrame frame;
	private JTextField profNameTextField;
	private JTextField profDeptTextField;
	private JTextField profSectnoTextField;
	private JTextField profCnoTextField;
	private JTextField profCnameTextField;
	private int pid = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorView window = new ProfessorView();
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
	public ProfessorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 这是管理员可以看到的教授信息视图: 可以查看所有教授信息
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel profPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_03.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		profPanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(profPanel);
		profPanel.setLayout(null);
		
		JLabel label = new JLabel("\u59D3   \u540D\uFF1A");
		label.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label.setBounds(90, 140, 103, 30);
		profPanel.add(label);
		
		profNameTextField = new JTextField();
		profNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profNameTextField.setEditable(false);
		profNameTextField.setColumns(10);
		profNameTextField.setBounds(185, 135, 200, 40);
		profPanel.add(profNameTextField);
		
		JLabel label_1 = new JLabel("\u9662   \u7CFB\uFF1A");
		label_1.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_1.setBounds(470, 140, 103, 30);
		profPanel.add(label_1);
		
		profDeptTextField = new JTextField();
		profDeptTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profDeptTextField.setEditable(false);
		profDeptTextField.setColumns(10);
		profDeptTextField.setBounds(565, 135, 200, 40);
		profPanel.add(profDeptTextField);
		
		profSectnoTextField = new JTextField();
		profSectnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profSectnoTextField.setEditable(false);
		profSectnoTextField.setColumns(10);
		profSectnoTextField.setBounds(562, 290, 200, 40);
		profPanel.add(profSectnoTextField);
		
		JLabel label_2 = new JLabel("\u5F00\u73ED\u53F7\uFF1A");
		label_2.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_2.setBounds(467, 295, 116, 30);
		profPanel.add(label_2);
		
		profCnoTextField = new JTextField();
		profCnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profCnoTextField.setEditable(false);
		profCnoTextField.setColumns(10);
		profCnoTextField.setBounds(185, 290, 200, 40);
		profPanel.add(profCnoTextField);
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label_3.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_3.setBounds(90, 295, 116, 30);
		profPanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_4.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		label_4.setBounds(90, 380, 116, 30);
		profPanel.add(label_4);
		
		profCnameTextField = new JTextField();
		profCnameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profCnameTextField.setEditable(false);
		profCnameTextField.setColumns(10);
		profCnameTextField.setBounds(185, 375, 580, 40);
		profPanel.add(profCnameTextField);
		
		JButton button = new JButton("\u4E0A\u4E00\u9875");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pid == 1) {
					JOptionPane.showMessageDialog(null, "已经是第一名教授", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pid -= 1;
				getInfo(pid);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 25));
		button.setBounds(415, 475, 152, 45);
		profPanel.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u9875");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pid == 13) {
					JOptionPane.showMessageDialog(null, "已经是最后一名教授", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pid += 1;
				getInfo(pid);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 25));
		button_1.setBounds(613, 475, 152, 45);
		profPanel.add(button_1);
		
		getInfo(pid);
	}
	
    private void getInfo(int pidToCheck) {
		
        try {
        	String pname = "";
        	
			ConnectAccess ca = new ConnectAccess();
			ca.ConnectAccessFile();
			
			ca.stmt = ca.conn.prepareStatement("SELECT * FROM prof WHERE pid = ?");
			ca.stmt.setInt(1, pidToCheck);
	    	ca.rs = ca.stmt.executeQuery();
	    		    	
	    	while (ca.rs.next()) {
	    		pname = ca.rs.getString(1);
	    		profNameTextField.setText(pname);
	    		profDeptTextField.setText(ca.rs.getString(2));
	    		//System.out.println(passwordFromDatabase);
	        }
	    	    	
	    	ca.rs.close();
	    	ca.stmt.close();
	    	
	    	ca.stmt = ca.conn.prepareStatement("SELECT * FROM courseInfo WHERE pname = ?");
			ca.stmt.setString(1, pname);
	    	ca.rs = ca.stmt.executeQuery();
	    		    	
	    	while (ca.rs.next()) {
	    		profCnoTextField.setText(ca.rs.getString(2));
	    		profSectnoTextField.setText(ca.rs.getString(3));
	    		profCnameTextField.setText(ca.rs.getString(5));
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
