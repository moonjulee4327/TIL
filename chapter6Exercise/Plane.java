package chapter6Exercise;

public class Plane {
	//필드
	
	private String manufacture;
	private String model;
	private int maxNumberOfPassengers;
	private static int numberOfPlanes;
	
	//생성자
	
	Plane(){numberOfPlanes++;}
	Plane(String manufacture, String model, int maxNumberOfPassengers){
		this.manufacture =manufacture;
		this.model =model;
		this.maxNumberOfPassengers =maxNumberOfPassengers;
		numberOfPlanes++;
	}
	
	//메소드
	
	String getManufacture() {
		return manufacture;
	}
	
	void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	
	String getModel() {
		return model;
	}
	
	void setModel(String model) {
		this.model = model;
	}
	
	int getMaxNumberOfPassengers() {
		return maxNumberOfPassengers;
	}
	
	void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if(maxNumberOfPassengers>0) {
			this.maxNumberOfPassengers = maxNumberOfPassengers;			
		}
	}
	static int getNumberOfPlanes() {
		
		return numberOfPlanes;
	}

	
	
	
}
