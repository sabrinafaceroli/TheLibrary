package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class Community extends User{
	private String _job;
	
	
	
	Community(int id, String name, String doc, String email, String password) {
		super(id, name, doc, email, password);
		this.setLoans(new ArrayList<Loan>(2));
	}

}
