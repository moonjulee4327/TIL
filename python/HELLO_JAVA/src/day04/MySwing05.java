package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MySwing05 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_my;
	private JTextField tf_com;
	private JTextField tf_rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing05 frame = new MySwing05();
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
	public MySwing05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_my = new JLabel("나");
		lbl_my.setBounds(35, 41, 57, 15);
		contentPane.add(lbl_my);
		
		JLabel lbl_com = new JLabel("컴퓨터");
		lbl_com.setBounds(35, 76, 57, 15);
		contentPane.add(lbl_com);
		
		JLabel lbl_rs = new JLabel("결과");
		lbl_rs.setBounds(35, 110, 57, 15);
		contentPane.add(lbl_rs);
		
		tf_my = new JTextField();
		tf_my.setBounds(140, 38, 116, 21);
		contentPane.add(tf_my);
		tf_my.setColumns(10);
		
		tf_com = new JTextField();
		tf_com.setColumns(10);
		tf_com.setBounds(140, 73, 116, 21);
		contentPane.add(tf_com);
		
		tf_rs = new JTextField();
		tf_rs.setColumns(10);
		tf_rs.setBounds(140, 107, 116, 21);
		contentPane.add(tf_rs);
		
		JButton btn = new JButton("게임하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myClick();
				
			}
		});
		btn.setBounds(35, 158, 221, 23);
		contentPane.add(btn);
	}
	
	
	public void myClick() {
		
		String myStr = tf_my.getText();
		String comStr = "";
		
		Random rd = new Random();
		double ran = rd.nextDouble();
		
		if(ran > 0.5) {
			comStr = "홀";
		}else {
			comStr = "짝";
		}
		
		tf_com.setText(comStr);
		
		if(myStr.equals(comStr)) {
			tf_rs.setText("승리");
		}else {
			tf_rs.setText("패배");
		}
		
	}
	
}
