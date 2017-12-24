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

public class StuScoreInfoView {

	private JFrame frame;
	private JTextField maxScoreTextField;
	private JTextField maxStuTextField;
	private JTextField maxSnoTextField;
	private JTextField textField;
	private JTextField minSnoTextField;
	private JTextField minStuTextField;
	private JTextField avgScoreTextField;
	private JTextField excellentNumTextField;
	private JTextField goodNumTextField;
	private JTextField averageNumTextField;
	private JTextField fairNumTextField;
	private JTextField poorNumTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuScoreInfoView window = new StuScoreInfoView();
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
	public StuScoreInfoView() {
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
		stuGpaInfoPanel.setBounds(-26, 10, 1000, 700);
		frame.getContentPane().add(stuGpaInfoPanel);
		stuGpaInfoPanel.setLayout(null);
		
		JLabel label = new JLabel("\u6700\u9AD8\u5206\uFF1A");
		label.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label.setBounds(110, 165, 123, 30);
		stuGpaInfoPanel.add(label);
		
		maxScoreTextField = new JTextField();
		maxScoreTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		maxScoreTextField.setEditable(false);
		maxScoreTextField.setColumns(10);
		maxScoreTextField.setBounds(210, 160, 100, 40);
		stuGpaInfoPanel.add(maxScoreTextField);
		
		JLabel label_1 = new JLabel("\u59D3  \u540D\uFF1A");
		label_1.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_1.setBounds(570, 165, 103, 30);
		stuGpaInfoPanel.add(label_1);
		
		maxStuTextField = new JTextField();
		maxStuTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		maxStuTextField.setEditable(false);
		maxStuTextField.setColumns(10);
		maxStuTextField.setBounds(657, 160, 200, 40);
		stuGpaInfoPanel.add(maxStuTextField);
		
		JLabel label_2 = new JLabel("\u5B66  \u53F7\uFF1A");
		label_2.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_2.setBounds(340, 165, 123, 30);
		stuGpaInfoPanel.add(label_2);
		
		maxSnoTextField = new JTextField();
		maxSnoTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		maxSnoTextField.setEditable(false);
		maxSnoTextField.setColumns(10);
		maxSnoTextField.setBounds(430, 160, 100, 40);
		stuGpaInfoPanel.add(maxSnoTextField);
		
		JLabel minScoreTextField = new JLabel("\u6700\u4F4E\u5206\uFF1A");
		minScoreTextField.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		minScoreTextField.setBounds(110, 255, 123, 30);
		stuGpaInfoPanel.add(minScoreTextField);
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(210, 250, 100, 40);
		stuGpaInfoPanel.add(textField);
		
		JLabel label_4 = new JLabel("\u5B66  \u53F7\uFF1A");
		label_4.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_4.setBounds(340, 255, 123, 30);
		stuGpaInfoPanel.add(label_4);
		
		minSnoTextField = new JTextField();
		minSnoTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		minSnoTextField.setEditable(false);
		minSnoTextField.setColumns(10);
		minSnoTextField.setBounds(430, 250, 100, 40);
		stuGpaInfoPanel.add(minSnoTextField);
		
		JLabel label_5 = new JLabel("\u59D3  \u540D\uFF1A");
		label_5.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_5.setBounds(570, 255, 103, 30);
		stuGpaInfoPanel.add(label_5);
		
		minStuTextField = new JTextField();
		minStuTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		minStuTextField.setEditable(false);
		minStuTextField.setColumns(10);
		minStuTextField.setBounds(657, 250, 200, 40);
		stuGpaInfoPanel.add(minStuTextField);
		
		JLabel label_3 = new JLabel("\u5E73\u5747\u5206\uFF1A");
		label_3.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_3.setBounds(110, 345, 123, 30);
		stuGpaInfoPanel.add(label_3);
		
		avgScoreTextField = new JTextField();
		avgScoreTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		avgScoreTextField.setEditable(false);
		avgScoreTextField.setColumns(10);
		avgScoreTextField.setBounds(210, 340, 100, 40);
		stuGpaInfoPanel.add(avgScoreTextField);
		
		JLabel label_6 = new JLabel("\u4F18(\u22653.5)\uFF1A");
		label_6.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_6.setBounds(110, 435, 156, 30);
		stuGpaInfoPanel.add(label_6);
		
		excellentNumTextField = new JTextField();
		excellentNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		excellentNumTextField.setEditable(false);
		excellentNumTextField.setColumns(10);
		excellentNumTextField.setBounds(340, 430, 100, 40);
		stuGpaInfoPanel.add(excellentNumTextField);
		
		JLabel label_7 = new JLabel("\u826F(\u22653.0 && <3.5)\uFF1A");
		label_7.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_7.setBounds(505, 435, 231, 30);
		stuGpaInfoPanel.add(label_7);
		
		goodNumTextField = new JTextField();
		goodNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		goodNumTextField.setEditable(false);
		goodNumTextField.setColumns(10);
		goodNumTextField.setBounds(760, 430, 100, 40);
		stuGpaInfoPanel.add(goodNumTextField);
		
		averageNumTextField = new JTextField();
		averageNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		averageNumTextField.setEditable(false);
		averageNumTextField.setColumns(10);
		averageNumTextField.setBounds(340, 490, 100, 40);
		stuGpaInfoPanel.add(averageNumTextField);
		
		JLabel label_8 = new JLabel("\u4E2D(\u22652.5 && <3.0)\uFF1A");
		label_8.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_8.setBounds(110, 495, 271, 30);
		stuGpaInfoPanel.add(label_8);
		
		JLabel label_9 = new JLabel("\u53CA\u683C(\u22652.0 && <2.5)\uFF1A");
		label_9.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_9.setBounds(505, 495, 258, 30);
		stuGpaInfoPanel.add(label_9);
		
		fairNumTextField = new JTextField();
		fairNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		fairNumTextField.setEditable(false);
		fairNumTextField.setColumns(10);
		fairNumTextField.setBounds(760, 490, 100, 40);
		stuGpaInfoPanel.add(fairNumTextField);
		
		JLabel label_10 = new JLabel("\u4E0D\u53CA\u683C(<2.0)\uFF1A");
		label_10.setFont(new Font("Adobe ·ÂËÎ Std R", Font.PLAIN, 26));
		label_10.setBounds(110, 555, 271, 30);
		stuGpaInfoPanel.add(label_10);
		
		poorNumTextField = new JTextField();
		poorNumTextField.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		poorNumTextField.setEditable(false);
		poorNumTextField.setColumns(10);
		poorNumTextField.setBounds(340, 550, 100, 40);
		stuGpaInfoPanel.add(poorNumTextField);
	}

}
