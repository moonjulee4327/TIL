package chaper3Exercise;

public class Exercise3_6 {
	public static void main(String[] args) {
		int num = 24;
		System.out.println(num>0?(num-(num%10)+10)-num:0);
		//음의 약수는 고려 하지 못했다..
	}
}
