package application;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Janitor extends Person implements Validator, Serializable {
	private double pay;

	public Janitor(Name name, Adress adress, DOB dob, boolean smoker, char sex, double pay) {
		super(name, adress, dob, smoker, sex);
		this.pay = pay;
	}
	
	public boolean Validate() throws Exception {
		if(this.pay < 10 || this.pay > 25) {
			throw new Exception("Invalid pay (10-25)");
		}
		return true;
	}

	
	public String longDescription() {
		DecimalFormat df = new DecimalFormat("#.00"); 
		return super.longDescription() + "\n Pay: $"+ df.format(this.pay);	
	}
}
