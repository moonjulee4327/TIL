package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MySwing03 extends JFrame {

	private JPanel contentPane;
	private JTextField tf01;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing03 frame = new MySwing03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MySwing03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf01 = new JTextField();
		tf01.setBounds(12, 22, 58, 21);
		contentPane.add(tf01);
		tf01.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(124, 22, 58, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(236, 22, 58, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setBounds(96, 25, 13, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.setBounds(187, 21, 42, 23);
		contentPane.add(btnNewButton);
	}
}
