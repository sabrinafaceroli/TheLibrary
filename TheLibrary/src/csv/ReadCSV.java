package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;


import libraryBook.Book;
import libraryLoan.Loan;
import libraryUsers.*;

public class ReadCSV {

	public static ArrayList<Book> ReadCSVBook()
	{
		ArrayList<Book> list = new ArrayList<Book>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("librarybooks.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new Book(data));
	        
	        br.close();
		}
		catch(IOException ex){}
		
		return list;
	}
	
	public static ArrayList<Loan> ReadCSVLoan()
	{
		ArrayList<Loan> list = new ArrayList<Loan>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("libraryloans.csv"));
	        String data;
	        while((data = br.readLine()) != null) 
	            list.add(new Loan(data));
	        
	        br.close();
		}
		catch(IOException ex){}
		
		return list;
	}
	
	public static ArrayList<User> ReadCSVUsers()
	{
		ArrayList<User> list = new ArrayList<User>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("libraryusers.csv"));
	        String data;
	        while((data = br.readLine()) != null)
	        {
	        	String[] val = data.split(",");
	   
	        	if(val[0] == "Community")
	        		list.add(new Community(val));
	        	else if(val[0] == "Professor")
	        		list.add(new Professor(val));
	        	else if(val[0] == "Student")
	        		list.add(new Student(val));
	        }
	        
	        br.close();
		}
		catch(IOException ex){}
		
		return list;
	}

}
