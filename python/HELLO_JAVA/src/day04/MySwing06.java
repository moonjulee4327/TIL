package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing06 extends JFrame {

	private JPanel contentPane;
	private JTextField tfDan;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing06 frame = new MySwing06();
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
	public MySwing06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("출력단수 :");
		lbl.setBounds(28, 33, 57, 15);
		contentPane.add(lbl);
		
		tfDan = new JTextField();
		tfDan.setBounds(106, 30, 116, 21);
		contentPane.add(tfDan);
		tfDan.setColumns(10);
		
		ta = new JTextArea();
		ta.setBounds(28, 119, 194, 259);
		contentPane.add(ta);
		
		JButton btn = new JButton("출력하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myClick();
				
			}
		});
		btn.setBounds(28, 72, 194, 23);
		contentPane.add(btn);
	}
	
	
	public void myClick() {
		
		String dan = tfDan.getText();
		int danInt = Integer.parseInt(dan);
		String gugudan = "";
		
		for(int i=1; i<10; i++) {
			
			gugudan += dan + " * " + i + " = " + danInt*i + "\n";
			
		}
		
		ta.setText(gugudan);
		
	}
	
}
