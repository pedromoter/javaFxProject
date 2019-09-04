package application;

import java.io.Serializable;

public class DOB implements Validator, Serializable {
	private int day;
	private int month;
	private int year;
	

	public DOB(int d, int m, int y) {
		this.day =d;
		this.month = m;
		this.year = y;
	}
	
	@Override
	public boolean Validate() throws Exception {
		if(this.day < 1 && this.day > 31) {
			 throw new Exception("Inavlid day");

		}
		if(this.month < 1 && this.month > 12) {
			 throw new Exception("Inavlid month");

		}
	
		
		return true;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
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
		DOB other = (DOB) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DOB [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}
