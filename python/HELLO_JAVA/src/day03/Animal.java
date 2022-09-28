package day03;

public class Animal {
	
	int hungry = 5;
	
	public void timegoby() {
		if(hungry > 0) {
			hungry--;
		}		
	}
	
	public void manttang() {
		hungry = 10;
	}
	
	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		System.out.println(animal.hungry);
		animal.timegoby();
		System.out.println(animal.hungry);
		animal.manttang();
		System.out.println(animal.hungry);
		
	}
	
}
