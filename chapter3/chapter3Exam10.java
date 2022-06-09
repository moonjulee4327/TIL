package chapter3;

public class chapter3Exam10 {

	public static void main(String[] args) {
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		
		char cVar2 = (char) var2;
		char cVar3 = (char) var3;
		double dvar2 = (double) cVar2;
		double dvar3 = (double) cVar3;
		
		double var4 = (double)var1 * var1 * (cVar2 + '.' + cVar3);
		System.out.println("원의 넓이:" + var4);

	}

}
