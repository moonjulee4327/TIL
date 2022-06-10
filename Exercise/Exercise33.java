package chapter3;

import java.util.Scanner;

public class Exercise33 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("윤년인지를 확인할 연도를 입력하세요: ");
		
		String num1 = scanner.next();
		
		String result1 = "윤년이 아닙니다.";
		String result2 = "윤년입니다.";
		
		int result3 = Integer.parseInt(num1);
		
		
		String result = ((result3%4 == 0 && result3%100 != 0)||result3%400==0)?result2:result1; 
		
		
		
		System.out.println(num1 + "년은 "+ result);
	
	
		scanner.close();
	
	
	}

}
