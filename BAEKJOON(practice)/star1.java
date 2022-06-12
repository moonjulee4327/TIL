package baekjoon;

import java.util.Scanner;

public class star1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int seq = scanner.nextInt();
		
		for(int i=1; i<=seq; i++) {
			
			String seq1 = String.valueOf(seq);
			seq1 = "*";
			  
			System.out.println(seq1.repeat(i));
			
		}
		
		scanner.close();
		
		
		
		
	}

}
