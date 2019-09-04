package application;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Student extends Person implements Validator,Serializable {
	private String major;
	private double gpa;
	private double creditsCompleted;
	
	public Student(Name name, Adress adress, DOB dob, boolean smoker, char sex, String major, double gpa,
			double creditsCompleted) {
		super(name, adress, dob, smoker, sex);
		this.major = major;
		this.gpa = gpa;
		this.creditsCompleted = creditsCompleted;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCreditsCompleted() {
		return creditsCompleted;
	}

	public void setCreditsCompleted(double creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}
	
	
	@Override 
	public boolean Validate() throws Exception {
	
		super.Validate();
		
		if(this.gpa < 1 || this.gpa > 5) {
			throw new Exception("Invalid gpa (1-5)");
		}
		
		if(this.creditsCompleted < 0 || this.creditsCompleted > 100) {
			throw new Exception("Invalid credits, (0-100)");

		}
		
		return true;
	}
	
	public String longDescription() {
		DecimalFormat df = new DecimalFormat("#.00"); 
		return super.longDescription() + "\n Major: " +  major + "\n GPA: " + df.format(gpa) + "\n Credits Completed: " + creditsCompleted; 
	}
	
	

}
