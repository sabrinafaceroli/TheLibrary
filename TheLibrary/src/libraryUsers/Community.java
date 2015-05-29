package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class Community extends User{
	private String _job;
	
	Community(int id, String name, String doc, String email, String password) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(2));
	}
	Community(int id, String name, String doc, String email, String password, String job) {
		super(id, name, doc, email, password);
		this._job = job;
		this.setLoans(new ArrayList<Loan>(2));
	}
	
	public String toString(){
		return super.toString() + "|" + this._job;
	}
}
