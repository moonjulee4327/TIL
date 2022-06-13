package chapter4;

import java.util.Scanner;

public class chapter4Exam7 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			
			int num = scanner.nextInt();
			int in;
			int out;
			
			
			switch(num) {
			case 1 :
				System.out.print("예금액>");
				in  = scanner.nextInt();
				balance = in;
				break;
				
			case 2 :
				System.out.print("출금액>");
				out = scanner.nextInt();
				balance -= out;
				break;
				
			case 3 :
				
				System.out.println("잔고>"+balance);
				break;
				
			case 4 :
				
				run=false;
				
			}
			
			//if(num==4) {break;}
		}
		System.out.println("\n" +"프로그램 종료");
		
		scanner.close();
	}
	
}
