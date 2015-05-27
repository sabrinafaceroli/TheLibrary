package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class Professor extends User{
	private String _institute;
	private String _department;
	
	Professor(int id, String name, String doc, String email, String password) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(6));
	}
	
	Professor(int id, String name, String doc, String email, String password, String institute, String department) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(6));
		this.setInstitute(institute);
		this.setDepartment(department);
	}

	public String getDepartment() {return _department;}
	public void setDepartment(String _department) {this._department = _department;}

	public String getInstitute() {return _institute;}
	public void setInstitute(String _institute) {this._institute = _institute;}
		
}
