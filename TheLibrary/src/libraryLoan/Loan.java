package libraryLoan;

import java.util.GregorianCalendar;


public class Loan {
	private int _bookID;
	private int _userID;
	private GregorianCalendar _lentDate, _deliveryDate;
	private boolean _isLate;
	
	public Loan(int book, int user, String lentDate, String deliveryDate, String SystemTime){
		String[] date = lentDate.split("/");
		
		this._bookID = book;
		this._userID = user;
		this._lentDate = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		date = deliveryDate.split("/");
		this._deliveryDate = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		this._isLate = this.checkTardiness(SystemTime);
	}
	
	public Loan(String csv, String SystemTime){
		String[] date;
        String[] values = csv.split(",");
        this._bookID = Integer.parseInt(values[0]);
        this._userID = Integer.parseInt(values[1]);
        date = values[2].split("/");
        this._lentDate = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        date = values[3].split("/");
        this._deliveryDate = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        this._isLate = this.checkTardiness(SystemTime);
    }
	
	private boolean checkTardiness(String SystemTime){
		String[] date = SystemTime.split("/");
		GregorianCalendar comparator = new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		
		if(comparator.after(comparator))
			return true;
		
		return false;
	}
	
	public boolean isLate(){return this._isLate;}
	
	//Getters and Setters
	public int getUser(){return this._userID;}
	
	public int getBook(){return this._bookID;}
	
	public String toString(){
		return this._bookID + "," + this._userID + "," + this._lentDate + "," 
				+ this._deliveryDate + "," +this._isLate; 
	}
}
