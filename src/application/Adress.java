package application;

import java.io.Serializable;

public class Adress implements Validator, Serializable{
	private int number;
	private String street;
	private String streetType;
	private String city;
	private String state;
	private int zipcode;
	
	public Adress(int number, String stree, String streetType, String city, String state, int zipcode) {
		this.number = number;
		this.street = stree;
		this.streetType = streetType;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Override
	public boolean Validate() throws Exception {
		
		if(this.street.isEmpty()) {
			 throw new Exception("Inavlid street");

		}
		
		if(this.streetType.isEmpty()) {
			 throw new Exception("Inavlid st type");
		}
		
		if(this.city.isEmpty()) {
			 throw new Exception("Inavlid city");
		}
		
		if(this.state == null && this.state.isEmpty()) {
			 throw new Exception("Inavlid state");

		}
		
		return true;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + number;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((streetType == null) ? 0 : streetType.hashCode());
		result = prime * result + zipcode;
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
		Adress other = (Adress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (number != other.number)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (streetType == null) {
			if (other.streetType != null)
				return false;
		} else if (!streetType.equals(other.streetType))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return number + ", " + street + " " + streetType + ", " + city
				+ ", " + state + "," + zipcode;
	}

	
	

}
