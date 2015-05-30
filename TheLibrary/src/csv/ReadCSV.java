package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libraryBook.Book;
import libraryLoan.Loan;
import libraryUsers.User;

public class ReadCSV {

	public static List<Book> ReadCSVBook()
	{
		List<Book> list = new ArrayList<Book>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("librarybooks.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new Book(data));
		}
		catch(IOException ex){}
		
		return list;
	}
	
	public static List<Loan> ReadCSVLoan()
	{
		List<Loan> list = new ArrayList<Loan>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("libraryloans.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new Loan(data));
		}
		catch(IOException ex){}
		
		return list;
	}
	
	public static List<User> ReadCSVUsers()
	{
		List<User> list = new ArrayList<User>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("libraryusers.csv"));
	        String data;
	//        while((data = br.readLine()) != null) 
//	            list.add(new User(data));

		}
		catch(IOException ex){}
		
		return list;
	}

}
