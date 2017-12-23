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

public class ProfView {

	private JFrame frame;
	private JTextField profNameTextField;
	private JLabel profCollegeLabel;
	private JTextField profCollegeTextField;
	private JLabel profCnoLabel;
	private JTextField profCnoTextField;
	private JLabel profSectnoLabel;
	private JTextField profSectnoTextField;
	private JLabel profCnameLabel;
	private JTextField profCnameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfView window = new ProfView();
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
	public ProfView() {
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
		
		JLabel profNameLabel = new JLabel("\u59D3   \u540D\uFF1A");
		profNameLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		profNameLabel.setBounds(90, 140, 103, 30);
		profPanel.add(profNameLabel);
		
		// 显示教授姓名的JTextView:
		profNameTextField = new JTextField();
		profNameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profNameTextField.setEditable(false);
		profNameTextField.setColumns(10);
		profNameTextField.setBounds(185, 135, 200, 40);
		profPanel.add(profNameTextField);
		
		profCollegeLabel = new JLabel("\u9662   \u7CFB\uFF1A");
		profCollegeLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		profCollegeLabel.setBounds(480, 140, 103, 30);
		profPanel.add(profCollegeLabel);
		
		// 显示所在院系的JTextView:
		profCollegeTextField = new JTextField();
		profCollegeTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profCollegeTextField.setEditable(false);
		profCollegeTextField.setColumns(10);
		profCollegeTextField.setBounds(575, 135, 200, 40);
		profPanel.add(profCollegeTextField);
		
		profCnoLabel = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		profCnoLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		profCnoLabel.setBounds(90, 300, 116, 30);
		profPanel.add(profCnoLabel);
		
		// 显示课程号的JTextView:
		profCnoTextField = new JTextField();
		profCnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profCnoTextField.setEditable(false);
		profCnoTextField.setColumns(10);
		profCnoTextField.setBounds(185, 295, 200, 40);
		profPanel.add(profCnoTextField);
		
		profSectnoLabel = new JLabel("\u5F00\u73ED\u53F7\uFF1A");
		profSectnoLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		profSectnoLabel.setBounds(480, 300, 116, 30);
		profPanel.add(profSectnoLabel);
		
		// 显示开班号的JTextView:
		profSectnoTextField = new JTextField();
		profSectnoTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profSectnoTextField.setEditable(false);
		profSectnoTextField.setColumns(10);
		profSectnoTextField.setBounds(575, 295, 200, 40);
		profPanel.add(profSectnoTextField);
		
		profCnameLabel = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		profCnameLabel.setFont(new Font("Adobe 仿宋 Std R", Font.PLAIN, 26));
		profCnameLabel.setBounds(90, 385, 116, 30);
		profPanel.add(profCnameLabel);
		
		// 显示课程名的JTextView:
		profCnameTextField = new JTextField();
		profCnameTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		profCnameTextField.setEditable(false);
		profCnameTextField.setColumns(10);
		profCnameTextField.setBounds(185, 380, 590, 40);
		profPanel.add(profCnameTextField);
		
		// 跳转到新页面: 显示本班学生基本信息
		JButton profClassStuInfoBtn = new JButton("\u9009\u8BFE\u5B66\u751F\u4FE1\u606F");
		profClassStuInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profClassStuInfoBtn.setFont(new Font("宋体", Font.BOLD, 25));
		profClassStuInfoBtn.setBounds(110, 515, 245, 55);
		profPanel.add(profClassStuInfoBtn);
		
		// 跳转到新页面: 显示本班学生成绩统计信息
		JButton profStuGpaBtn = new JButton("\u5B66\u751F\u6210\u7EE9\u7EDF\u8BA1");
		profStuGpaBtn.setFont(new Font("宋体", Font.BOLD, 25));
		profStuGpaBtn.setBounds(525, 515, 245, 55);
		profPanel.add(profStuGpaBtn);
	}
}
