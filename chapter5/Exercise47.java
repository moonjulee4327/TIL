package chapter5;

import java.util.Random;

public class Exercise47 {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] lotto = new int[6] ;
		
		for(int i=0; i<6; i++) {
			int randomNum = random.nextInt(45)+1;
			lotto[i] = randomNum;
			
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;					
				}
			}
		}
		for(int i=0; i<6; i++) {
		System.out.println("오늘의 행운 번호는 " + lotto[i]);
		}
	}

}
