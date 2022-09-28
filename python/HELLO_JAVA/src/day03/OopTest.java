package day03;

public class OopTest {
	public static void main(String[] args) {
		Human human = new Human();
		
		System.out.println(human.hungry);
		System.out.println(human.skillLang);
		
		human.timegoby();
		human.momstouch(5);
		
		System.out.println(human.hungry);
		System.out.println(human.skillLang);	
	}
}
