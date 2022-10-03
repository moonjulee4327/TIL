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

public class MySwing09 extends JFrame {

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
	private String phoneNum = "";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing09 frame = new MySwing09();
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
	public MySwing09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(29, 24, 168, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JButton b = (JButton) e.getSource();
//				System.out.println(b.getText());
				myClick("1");
//				myClick(e);
			}
		});
		btn1.setBounds(29, 67, 49, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("2");
			}
		});
		btn2.setBounds(90, 67, 49, 23);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("3");
			}
		});
		btn3.setBounds(148, 67, 49, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("4");
			}
		});
		btn4.setBounds(29, 100, 49, 23);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("5");
			}
		});
		btn5.setBounds(90, 100, 49, 23);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("6");
			}
		});
		btn6.setBounds(148, 100, 49, 23);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("7");
			}
		});
		btn7.setBounds(29, 133, 49, 23);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("8");
			}
		});
		btn8.setBounds(90, 133, 49, 23);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("9");
			}
		});
		btn9.setBounds(148, 133, 49, 23);
		contentPane.add(btn9);
		
		btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick("0");
			}
		});
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
	}
	
	public void myClick(String num) {
		
		if(num.equals(btn1.getText())) {
			phoneNum += btn1.getText();							
		}
		
		if(num.equals(btn2.getText())) {
			phoneNum += btn2.getText();							
		}
		
		if(num.equals(btn3.getText())) {
			phoneNum += btn3.getText();							
		}
		
		if(num.equals(btn4.getText())) {
			phoneNum += btn4.getText();							
		}
		
		if(num.equals(btn5.getText())) {
			phoneNum += btn5.getText();							
		}
		
		if(num.equals(btn6.getText())) {
			phoneNum += btn6.getText();							
		}
		
		if(num.equals(btn7.getText())) {
			phoneNum += btn7.getText();							
		}
		
		if(num.equals(btn8.getText())) {
			phoneNum += btn8.getText();							
		}
		
		if(num.equals(btn9.getText())) {
			phoneNum += btn9.getText();							
		}
		
		if(num.equals(btn0.getText())) {
			phoneNum += btn0.getText();							
		}
		
			
		
		tf.setText(phoneNum);
		
	}
	
	public void disp() {
		JOptionPane.showMessageDialog(null, "전화 왔습니다! " + tf.getText());
	}

}
