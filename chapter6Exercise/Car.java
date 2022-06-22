package chapter6Exercise;

public class Car {
	//필드
	
	private double speed;
	private String color;
	static final double MAX_SPEED=200;
	
	//생성자
	
	Car(){
		
	}
	Car(String color){
		this.color = color;
	}
	
	//메소드
	
	double getSpeed() {
		return speed;
	}
	void setSpeed(double speed) {
		this.speed = speed;
	}
	String getColor() {
		return color;
	}
	void setColor(String color) {
		this.color = color;
	}
	boolean speedUp(double speed) {
		if(speed>200 || speed<0) {
			this.speed=speed;
			return false;
		}else {
			this.speed = +speed;
			return true;
		}
		
	}
	static double getMaxSpeed() {
		return MAX_SPEED;
	}

	
	
	
	
}
