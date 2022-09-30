package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MySwing10 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;
	private String comRan = "123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing10 frame = new MySwing10();
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
	public MySwing10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("세자리수 : ");
		lbl.setBounds(34, 35, 80, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(122, 32, 116, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn = new JButton("맞추기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myClick();
				
			}
		});
		btn.setBounds(34, 85, 106, 23);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(34, 141, 204, 240);
		contentPane.add(ta);
		
		JButton btnReset = new JButton("다시하기");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myReset();
				
			}
		});
		btnReset.setBounds(139, 85, 99, 23);
		contentPane.add(btnReset);
		
		setCom();
	}
	
	
	public void myReset() {
		
		tf.setText("");
		ta.setText("");
		setCom();
//		comRan = "";
//		
//		Random ranNum = new Random();
		
//		ranNum.nextInt(999);
//		if() {
//			comRan = ranNum.nextInt(10) + "";
//		}
		
		
		
	}
	
	public void setCom() {
		int[] arr9 = {
				1,2,3,4,5,6,7,8,9
	     	   };

		Random rd = new Random();
		
		for(int i=0; i < arr9.length; i++) {
			int ran = rd.nextInt(9);
			int a = arr9[0];
			int b = arr9[ran];
			arr9[0] = b;
			arr9[ran] = a;
			
		}
		
		
		comRan = arr9[0] + "" + arr9[1] + "" + arr9[2] + "";
		
		System.out.println(comRan);
	}
	
	public int getStrike(String comRan, String mine) {
		
		String com1 = comRan.substring(0, 1);
		String com2 = comRan.substring(1, 2);
		String com3 = comRan.substring(2, 3);
		
		String mine1 = mine.substring(0, 1);
		String mine2 = mine.substring(1, 2);
		String mine3 = mine.substring(2, 3);
		
		int sRs = 0;
		
		
		
//		int sum = Integer.parseInt(suOne+suTw+suTh);
//		
//		if(com1.equals(mine1) || com2.equals(mine2) || com3.equals(mine3)){
//			rs = 1;
//		}
		
		
		if(com1.equals(mine1)) sRs++;
		if(com2.equals(mine2)) sRs++;
		if(com3.equals(mine3)) sRs++;
		
		return sRs;
		
	}
	
	public int getBall(String comRan, String mine) {
		
		String com1 = comRan.substring(0, 1);
		String com2 = comRan.substring(1, 2);
		String com3 = comRan.substring(2, 3);
		
		String mine1 = mine.substring(0, 1);
		String mine2 = mine.substring(1, 2);
		String mine3 = mine.substring(2, 3);
		
		int bRs = 0;
		
		if(mine1.equals(com2) || mine1.equals(com3)) bRs++;
		if(mine2.equals(com3) || mine2.equals(com1)) bRs++;
		if(mine3.equals(com2) || mine3.equals(com1)) bRs++;
		
		return bRs;
		
	}
	
	public void myClick() {
		
		String strOld = ta.getText();
		
		String mine = tf.getText();
		int s = getStrike(comRan, mine);
		int b = getBall(comRan, mine);
		
		
		String strNew = mine + " " + s + "S" + b + "B" + "\n";
		
		ta.setText(strOld + strNew);
		tf.setText("");
		
		if(s == 3) {
			JOptionPane.showMessageDialog(null, mine + "을 맞췄습니다.");
		}
		
		System.out.println(s);
		System.out.println(b);
	}
}
