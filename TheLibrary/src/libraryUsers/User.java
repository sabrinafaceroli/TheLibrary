package libraryUsers;

import java.util.ArrayList;

import libraryLoan.Loan;

public class User {
	private int _ID;
	private String _name;
	private String _document;
	private String _email;
	private String _password;
	private ArrayList<Loan> _loans;
	
	public User(String csv)
	{
        String[] values = csv.split(",");
        this._ID = Integer.parseInt(values[0]);
        this._name = values[1];
        this._document = values[2];
        this._email = values[3];
        this._password = values[4];
	}

	
	User(int id, String name, String doc, String email, String password){
		this._ID  = id;
		this._name = name;
		this._document = doc;
		this._email = email;
		this._password = password;
//		this.setLoans(new ArrayList<Loan>());
		
	}
	
	public String toString(){
		return "" + this._ID + "," + this._name + "," + this._document + "," + this._email + "," + this._password;
	}
	
	public String toStringArea()
	{
		return "ID: " + this._ID + ", Nome: " + this._name + "\n Documento: " + this._document + ", Email: " + this._email + ", Senha: " 
				+ this._password;
	}
	
	//Getter and Setters
	public int getID() {return _ID;}
	public void setID(int _ID) {this._ID = _ID;}
	
	public String getName() {return _name;}
	public void setName(String _name) {this._name = _name;}

	public String get_document() {return _document;}
	public void set_document(String _document) {this._document = _document;}
	
	public String getEmail() {return _email;}
	public void setEmail(String _email) {this._email = _email;}
	
	public String getPassword() {return _password;}
	public void setPassword(String _password) {this._password = _password;}

	public ArrayList<Loan> getLoans() {return _loans;}
	public void setLoans(ArrayList<Loan> _loans) {this._loans = _loans;}
	
	//End of getters and Setters
}
