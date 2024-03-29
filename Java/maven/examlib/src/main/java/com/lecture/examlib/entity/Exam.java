package com.lecture.examlib.entity;

public class Exam {
	private int kor;
	private int eng;
	private int math;
	
	public int total() {
		return kor + eng + math;
	}
	
	public float avg() {
		return total()/3.0f;
	}
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}
	
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "entity [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
}
