package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MySwing07 extends JFrame {

	private JPanel contentPane;
	private JTextField tfMine;
	private JTextField tfCom;
	private JTextField tfRs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing07 frame = new MySwing07();
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
	public MySwing07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("나");
		lblNewLabel.setBounds(12, 33, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("컴퓨터");
		lblNewLabel_1.setBounds(12, 73, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("결과");
		lblNewLabel_2.setBounds(12, 117, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfMine = new JTextField();
		tfMine.setBounds(116, 30, 116, 21);
		contentPane.add(tfMine);
		tfMine.setColumns(10);
		
		tfCom = new JTextField();
		tfCom.setColumns(10);
		tfCom.setBounds(116, 70, 116, 21);
		contentPane.add(tfCom);
		
		tfRs = new JTextField();
		tfRs.setColumns(10);
		tfRs.setBounds(116, 114, 116, 21);
		contentPane.add(tfRs);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myClick();
				
			}
		});
		btn.setBounds(12, 178, 220, 23);
		contentPane.add(btn);
	}
	
	public void myClick() {
		
		String myStr = tfMine.getText();
		String comStr = "";
		String rsStr = "";
		
		Random rd = new Random();
		
		double rdD = rd.nextDouble();
		
		if(0.33>rdD) {
			comStr = "가위";
		}else if(0.66>rdD) {
			comStr = "바위";
		}else {
			comStr = "보";
		}
		
		tfCom.setText(comStr);
		
		if(myStr.equals(comStr)) {
			tfRs.setText("비김");
		}else if((myStr.equals("가위") && comStr.equals("보")) || 
				(myStr.equals("바위") && comStr.equals("가위")) || 
				(myStr.equals("보") && comStr.equals("바위"))) {
			tfRs.setText("내가 이김");
		}else {
			tfRs.setText("컴퓨터가 이김");
		}
		
	}

}
