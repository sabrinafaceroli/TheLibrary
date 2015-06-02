package libraryLoan;

import java.util.GregorianCalendar;


public class Loan {
	private int _bookID;
	private int _userID;
	private GregorianCalendar _lentDate, _deliveryDate;
	private boolean _isLate;
	
	public Loan(int book, int user, String lentDate, int userType){
		String[] date = lentDate.split("/");
		int n = 0;
	
		this._bookID = book;
		this._userID = user;
		if(userType == 1)
			n = 60;
		else 
			n = 15;
	
		this._lentDate = new GregorianCalendar(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
		this._deliveryDate = new GregorianCalendar(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])+n);
		this._isLate = this.checkTardiness(lentDate);
	}
	
	public Loan(String csv, String SystemTime){
		String[] date;
        String[] values = csv.split(",");


        this._bookID = Integer.parseInt(values[0]);
        this._userID = Integer.parseInt(values[1]);
        date = values[2].split("/");
        this._lentDate = new GregorianCalendar(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        date = values[3].split("/");
        this._deliveryDate = new GregorianCalendar(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
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
		String lentdate, deliverydate;
		lentdate = _lentDate.get(GregorianCalendar.YEAR) + "/" +_lentDate.get(GregorianCalendar.MONTH) + "/"
				+ _lentDate.get(GregorianCalendar.DAY_OF_MONTH);
		
		deliverydate = _deliveryDate.get(GregorianCalendar.YEAR) + "/" +_deliveryDate.get(GregorianCalendar.MONTH) + "/"
				+ _deliveryDate.get(GregorianCalendar.DAY_OF_MONTH);
		
		
		return this._bookID + "," + this._userID + "," + lentdate + "," 
				+ deliverydate + "," +this._isLate; 
	}
	
	public String toStringArea()
	{
		String lentdate, deliverydate;
		lentdate = _lentDate.get(GregorianCalendar.YEAR) + "/" +_lentDate.get(GregorianCalendar.MONTH) + "/"
				+ _lentDate.get(GregorianCalendar.DAY_OF_MONTH);
		
		deliverydate = _deliveryDate.get(GregorianCalendar.YEAR) + "/" +_deliveryDate.get(GregorianCalendar.MONTH) + "/"
				+ _deliveryDate.get(GregorianCalendar.DAY_OF_MONTH);
		
		return "ID do Livro: " + this._bookID + "\n ID do Usuario: " + this._userID + "\n Data de Empréstimo: " + 
			lentdate + ", Data para Devolução: " + deliverydate;
	}
}
