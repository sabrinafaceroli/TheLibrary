package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class Student extends User{
	private String _course;
	
	
	Student(int id, String name, String doc, String email, String password) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(4));
	}
	
	public String toString(){
		return super.toString() + "|" + this._course;
	}
	
	//Getters and Setters
	public String getCourse() {return _course;}
	public void setCourse(String _course) {this._course = _course;}

}
