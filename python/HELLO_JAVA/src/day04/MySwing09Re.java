package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MySwing09Re extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btnCall;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing09Re frame = new MySwing09Re();
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
	public MySwing09Re() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setBounds(29, 24, 168, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		btn1 = new JButton("1");
		btn1.setBounds(29, 67, 49, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(90, 67, 49, 23);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(148, 67, 49, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(29, 100, 49, 23);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(90, 100, 49, 23);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(148, 100, 49, 23);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(29, 133, 49, 23);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(90, 133, 49, 23);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(148, 133, 49, 23);
		contentPane.add(btn9);
		
		btn0 = new JButton("0");
		btn0.setBounds(29, 166, 49, 23);
		contentPane.add(btn0);
		
		btnCall = new JButton("CALL");
		btnCall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disp();
			}
		});
		btnCall.setBounds(90, 166, 107, 23);
		contentPane.add(btnCall);
		
		
		btn1.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn2.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn3.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn4.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn5.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn6.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn7.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn8.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn9.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		btn0.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {myClick(e);}});
		
		
		
	}
	
	public void myClick(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		String strNew = b.getText();
		String strOld = tf.getText();
		tf.setText(strOld + strNew);
		
		
	}
	
	public void disp() {
		String strTel = tf.getText();
		JOptionPane.showMessageDialog(null, "전화 왔습니다! " + strTel);
	}

}
