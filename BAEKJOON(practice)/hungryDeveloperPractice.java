package TIL;

public class hungryDeveloperPractice {

	public static void main(String[] args) {
		
		int[][] grade = {{50,60,70,80,90},
						{55,65,70,75,80},
						{43,53,63,73,83},
						{70,77,80,90,99}
						};
		
		int[] studentGradeSum = new int[4];
	
		for (int i = 0; i < grade.length; i++) {
			for (int j = 0; j < grade[i].length; j++) {
				studentGradeSum[i] += grade[i][j];				
			} 
		}
		
		int[] average = new int[4];
		
		for (int i = 0; i < grade.length; i++) {
			average[i] = studentGradeSum[i] / grade[i].length; 
			
		}
		for (int i = 0; i < average.length; i++) {
		
			System.out.print("학생"+(i+1)+"의 평균값은: "+ average[i]);
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------------------");
		
		System.out.println("순위별로 그래프 구현, 주말에 풀자!");

	
	}

}
