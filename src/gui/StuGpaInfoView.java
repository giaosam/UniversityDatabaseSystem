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

public class StuGpaInfoView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuGpaInfoView window = new StuGpaInfoView();
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
	public StuGpaInfoView() {
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
		
		JPanel stuGpaInfoPanel = new JPanel() {
			 protected void paintComponent(Graphics g) {  
	                ImageIcon icon = new ImageIcon("src\\res\\bg_08.jpg");  
	                Image img = icon.getImage();  
	                g.drawImage(img, 0, 0, icon.getIconWidth(),  
	                        icon.getIconHeight(), icon.getImageObserver());  
	                frame.setSize(icon.getIconWidth(), icon.getIconHeight());  
			 }
	  
		};
		stuGpaInfoPanel.setBounds(0, 0, 1000, 700);
		frame.getContentPane().add(stuGpaInfoPanel);
		stuGpaInfoPanel.setLayout(null);
		
		JLabel label = new JLabel("\u6700\u9AD8\u5206\uFF1A");
		label.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label.setBounds(110, 160, 123, 30);
		stuGpaInfoPanel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(210, 155, 200, 40);
		stuGpaInfoPanel.add(textField);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_1.setBounds(490, 160, 103, 30);
		stuGpaInfoPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(565, 155, 200, 40);
		stuGpaInfoPanel.add(textField_1);
	}

}
