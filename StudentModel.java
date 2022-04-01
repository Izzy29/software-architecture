package assignment2;

public class StudentModel {
	int studID;
	String studName;
	int math;
	int science;
	int english;
	
	public StudentModel() {
		
	}
	
	public StudentModel(int studID, String studName, int math, int science, int english) {
		this.studID = studID;
		this.studName = studName;
		this.math = math;
		this.science = science;
		this.english = english;
	}

	public int getStudID() {
		return studID;
	}

	public void setStudID(int studID) {
		this.studID = studID;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

}
