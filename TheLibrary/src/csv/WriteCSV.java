package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import libraryBook.Book;
import libraryLoan.Loan;
import libraryUsers.User;

public class WriteCSV {

	//The comma that separates data in CSV.
	//private static final String COMMA_DELIMITER = ",";
	
	public static void WriteCSVBook(ArrayList<Book> list)
	{
		try
		{
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(Book bk : list)
			{
				fw.append(bk.toString());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}
	
	public static void WriteCSVLoan(ArrayList<Loan> list)
	{
		try
		{//TODO
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(Loan lo : list)
			{
				fw.append(lo.toString());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}
	
	public static void WriteCSVUsers(ArrayList<User> list)
	{
		try
		{
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(User us : list)
			{
				fw.append(us.getClass().toString());
				fw.append(",");
				fw.append(us.toString());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}
}
