package application;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Teacher extends Person implements Validator,Serializable { 
	
	private String subject;
	private int numberOfClasses;
	private officeNumber  roomNumber;
	


	
	public Teacher(Name name, Adress adress, DOB dob, boolean smoker, char gender, String subject, int numberOfClasses,
			officeNumber roomNumber) {
		super(name, adress, dob, smoker, gender);
		this.subject = subject;
		this.numberOfClasses = numberOfClasses;
		this.roomNumber = roomNumber;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) throws Exception {
		String old = this.subject;
		this.subject = subject;
		if(!this.Validate()) {
			this.subject = old;
			throw new Exception("Invalid data inputed");
		}
	}



	public int getNumberOfClasses() {
		return numberOfClasses;
	}



	public void setNumberOfClasses(int numberOfClasses) throws Exception {
		int old = this.numberOfClasses;
		this.numberOfClasses = numberOfClasses;
		if(!this.Validate()) {
			this.numberOfClasses = old;
			throw new Exception("Invalid data inputed");
		}
	}



	public officeNumber getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(officeNumber roomNumber) throws Exception {
		officeNumber old = this.roomNumber;
		this.roomNumber = roomNumber;
		if(!this.Validate()) {
			this.roomNumber = old;
			throw new Exception("Invalid data inputed");
		}
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfClasses;
		result = prime * result + roomNumber.hashCode();
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (numberOfClasses != other.numberOfClasses)
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
	public boolean Validate() throws Exception {
		 super.Validate();
		 
		 this.roomNumber.Validate();
		 
		if( this.subject.isEmpty()) {
			throw new Exception("Invalid subject");
		}
		
	
		
		 
		 return true; 
		
	}
	
	
	
	
	public String longDescription() {
		return super.longDescription() + "\n Subject: "+ subject  + "\n Number of classes: " + numberOfClasses + "\n Office: " + roomNumber; 	
	}

}
