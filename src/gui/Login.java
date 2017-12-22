package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField cardNumTextField;
	private JTextField passwdTextField;
	private JLabel lblNewLabel_1;
	private JPanel loginBgPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 515, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("µÇÂ¼½çÃæ");
		
		cardNumTextField = new JTextField();
		cardNumTextField.setBounds(117, 120, 298, 36);
		frame.getContentPane().add(cardNumTextField);
		cardNumTextField.setColumns(10);
		
		passwdTextField = new JTextField();
		passwdTextField.setColumns(10);
		passwdTextField.setBounds(117, 188, 298, 36);
		frame.getContentPane().add(passwdTextField);
		
		JButton loginBtn = new JButton("\u767B\u5F55");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginBtn.setBackground(Color.GREEN);
		loginBtn.setBounds(100, 252, 315, 36);
		frame.getContentPane().add(loginBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(173, 255, 47));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/res/avatar.png")));
		lblNewLabel.setBounds(90, 120, 31, 36);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/res/lock.png")));
		lblNewLabel_1.setBounds(90, 192, 24, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		loginBgPanel = new JPanel();
		loginBgPanel.setBounds(0, 0, 500, 326);
		
		frame.getContentPane().add(loginBgPanel);
		
	}
}
