package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class Professor extends User{
	private String _institute;
	private String _department;
	private static final int totalLendDays = 60;
	
	Professor(int id, String name, String doc, String email, String password) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(6));
	}
	
	public Professor(int id, String name, String doc, String email, String password, String institute, String department) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(6));
		this.setInstitute(institute);
		this.setDepartment(department);
	}
	
	public Professor(String[] values) {
		super(Integer.parseInt(values[1]), values[2], values[3], values[4], values[5]);
		this.setLoans(new ArrayList<Loan>(6));
		this.setInstitute(values[6]);
		this.setDepartment(values[7]);
	}
	
	public String toString(){
		return super.toString() + "," + this._institute + "," + this._department;
	}
	
	public String toStringArea()
	{
		return super.toStringArea() + ", Instituto: " + this._institute + ", Departamento: " + this._department;
	}
	
	//Getters and Setters
	public String getDepartment() {return _department;}
	public void setDepartment(String _department) {this._department = _department;}

	public String getInstitute() {return _institute;}
	public void setInstitute(String _institute) {this._institute = _institute;}

	public static int getLenddays() {return totalLendDays;}
		
}
