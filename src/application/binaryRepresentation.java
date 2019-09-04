package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import javafx.collections.ObservableList;

public class binaryRepresentation implements Serializable {
	public ArrayList<Teacher> Teachers;
	public ArrayList<Janitor> Janitor;
	public ArrayList<Student> Student;
	public ArrayList<Person> People;
	
	public binaryRepresentation(ArrayList<Teacher> teachers, ArrayList<application.Janitor> janitor,
			ArrayList<application.Student> student, ArrayList<Person> people) {
		super();
		Teachers = teachers;
		Janitor = janitor;
		Student = student;
		People = people;
	}
	
	public void  start() {
		this.Teachers =  new ArrayList<Teacher>();
		this.Janitor =  new ArrayList<Janitor>();
		this.Student =  new ArrayList<Student>();
		this.People =  new ArrayList<Person>();
	}

	@Override
	public String toString() {
		return "binaryRepresentation [Teachers=" + Teachers + ", Janitor=" + Janitor + ", Student=" + Student
				+ ", People=" + People + "]";
	}
	
	public ArrayList<Person> getAll() {
		TreeSet<Person> all = new TreeSet<Person>();
		if(Teachers.size() > 0) {
			all.addAll(Teachers);
		}
		
		if(Janitor.size() > 0) {
			all.addAll(Janitor);
		}
		if(Student.size() > 0) {
			all.addAll(Student);
		}
		if(People.size() > 0) {
			all.addAll(People);
		}

		ArrayList<Person> arr = new ArrayList<Person>();
		arr.addAll(all);
		System.out.println(arr);
		return arr;
	}
	public ArrayList<String> getAllString() {
		TreeSet<String> all = new TreeSet<String>();
		
		for(Person p: Teachers) {
			all.add(p.getName().toString());
		}
		
		for(Person p: Student) {
			all.add(p.getName().toString());
		}

		for(Person p: Janitor) {
			all.add(p.getName().toString());
		} 
		
		for(Person p: People) {
			all.add(p.getName().toString());
		}
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(all);
		System.out.println(arr);
		return arr;
	}


	
	
	

	

}
