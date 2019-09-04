package application;

import java.io.Serializable;

public class officeNumber implements Validator,Serializable {
	private int bldg;
	private int number;
 
	
	
	public officeNumber(int bldg, int number) {
		super();
		this.bldg = bldg;
		this.number = number;
	}



	@Override
	public String toString() {
		return bldg+"-"+number;
	}



	public int getBldg() {
		return bldg;
	}



	public void setBldg(int bldg) {
		this.bldg = bldg;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	@Override
	public boolean Validate() throws Exception {
		if(this.bldg < 0) {
			throw new Exception("Invalid bldg number");
			
		}
		
		if(this.number < 0) {
			throw new Exception("Invalid room number");
			
		}
		return true;
	}
	
	

}
