package chapter6Exercise;

public class Circle {
	//필드
	
	private double radius;
	private double x;
	private double y;
	
	//기본생성자
	
	//메소드
	
	double getArea() {
		
		return Math.PI * Math.pow(radius, 2);
	}
	
	double getRadius() {
		return radius;
	}
	
	void setRadius(double radius) {
		if(radius<0) {
			this.radius = 0;
		}else {
			this.radius = radius;			
		}
	}
	
	double getX() {
		return x;
	}
	void setX(double x) {
		this.x = x;
	}
	
	double getY() {
		return y;
	}
	
	void setY(double y) {
		this.y = y;
	}
	
}
