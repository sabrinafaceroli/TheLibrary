package libraryLoan;

import libraryBook.Book;
import libraryUsers.User;

public class Loan {
	private Book _book;
	private User _user;
	private int _lentDate, _deliveryDate;
	
	public Loan(Book book, User user, int currentTime){
		this._book = book;
		this._user = user;
		// verificar se User prof ou aluno ou comunidade e depois
		// settar as datas aqui com base no currentTime

	}
	
	public String toString(){
		return _book.getID() + "|" + _user.getID();
	}
	
	//Getters and Setters
	public User getUser(){return this._user;}
	
	public Book getBook(){return this._book;}
}
