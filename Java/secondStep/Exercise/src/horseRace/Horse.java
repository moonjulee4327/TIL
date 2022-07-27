package horseRace;

public class Horse implements Comparable<Object>{
	//필드
	private String name;
	private int grade;
	
	//생성자
	public Horse(String name) {
		this.name = name;
	}
	
	//메소드
	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	
	
}
