package application;

import java.io.Serializable;

public class Person implements Validator, Serializable, Comparable<Person>{
	private Name name;
	private Adress adress;
	private DOB dob;
	private boolean smoker;
	private char gender;
	

	public Person(Name name, Adress adress, DOB dob, boolean smoker, char gender) {
		super();
		this.name = name;
		this.adress = adress;
		this.dob = dob;
		this.smoker = smoker;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return this.name.toString();
	}

	public String longDescription() {
		return "Name: "+name.toString() + "\n" +  "DOB: "+dob.toString() + "\n" +  "Adress: " + adress +  "\n" + "Smokes: " + (smoker ? "Yes" : "No") + "\n Gender: " + gender;		
	}
	
	@Override
	public boolean Validate() throws Exception {
		if(name.Validate() && adress.Validate() && dob.Validate()) {
			return false;
		}
	
		
		if(this.gender == 'M' || this.gender == 'F' || this.gender == 'U' || this.gender == 'O') {
		 throw new Exception("Inavlid gender");
		
		}
		
		return true;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) throws Exception {
		Name old = this.name;
		this.name = name;
		if(!this.Validate()) {
			this.name = old;
			throw new Exception("Invalid data inputed");
		}
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) throws Exception {
		Adress old = this.adress;
		this.adress = adress;
		if(!this.Validate()) {
			this.adress = old;
			throw new Exception("Invalid data inputed");
		}
	}

	public DOB getDob() {
		return dob;
	}

	public void setDob(DOB dob) throws Exception {
		DOB old = this.dob;
		this.dob = dob;
		if(!this.Validate()) {
			this.dob = old;
			throw new Exception("Invalid data inputed");
		}
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) throws Exception {
		boolean old = this.smoker;
		this.smoker = smoker;
		if(!this.Validate()) {
			this.smoker = old;
			throw new Exception("Invalid data inputed");
		}
		this.smoker = smoker;
	}

	@Override
	public int compareTo(Person o) {
	return this.name.toString().compareTo(o.getName().toString());
	}
	
	
	
	
	

}
