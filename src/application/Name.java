package application;

import java.io.Serializable;

public class Name implements Validator,Serializable {
	private String FirstName;
	private char MI;
	private String  LastName;
	
	
	public Name() {
	
	}
	
	public Name(String f, char MI, String l) {
		this.FirstName = f;
		this.MI = MI;
		this.LastName = l;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public char getMI() {
		return MI;
	}

	public void setMI(char mI) {
		MI = mI;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + MI;
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
		Name other = (Name) obj;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (MI != other.MI)
			return false;
		return true;
	}

	@Override
	public boolean Validate() throws Exception {
		if(this.FirstName.trim().length() < 1) {
			 throw new Exception("Inavlid f name");
		}
		
		if(this.LastName.trim().length() < 1) {
			 throw new Exception("Inavlid last name");

			}
		
		return true;
	}

	@Override
	public String toString() {
		return FirstName + " " + MI + " " +LastName;
	}
	
	
	

}
