package libraryLoan;


public class Loan {
	private int _bookID;
	private int _userID;
	private int _lentDate, _deliveryDate;
	
	public Loan(int book, int user, int currentTime){
		this._bookID = book;
		this._userID = user;
		// verificar se User prof ou aluno ou comunidade e depois
		// settar as datas aqui com base no currentTime

	}
	
	public Loan(String csv){
        String[] values = csv.split(",");
        this._bookID = Integer.parseInt(values[0]);
        this._userID = Integer.parseInt(values[1]);
        //Adicionar os time stamps
	}
	
	//Getters and Setters
	public int getUser(){return this._userID;}
	
	public int getBook(){return this._bookID;}
	
	public String toString(){
		return this._bookID + "," + this._userID; //Tem que ter as datas aqui 
	}
}
