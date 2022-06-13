package chapter4;


import java.util.Random;

public class chapter4Exam3 {

	public static void main(String[] args) {
		
		while(true) {
			
			Random Random = new Random();
			
				int num1 = Random.nextInt(6)+1;
				int num2 = Random.nextInt(6)+1;
				
				if(num1+num2 ==5) {
					
					System.out.println("("+num1+","+num2+")");
					
					break;
					
				}
			
			
			
		}
		

	}

}
