package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import libraryBook.Book;
import libraryLoan.Loan;
import libraryUsers.User;

public class WriteCSV {

	//The comma that separates data in CSV.
	private static final String COMMA_DELIMITER = ",";
	
	public void WriteCSVBook(List<Book> list)
	{
		try
		{
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(Book bk : list)
			{
				fw.append(String.valueOf(bk.getID()));
				fw.append(COMMA_DELIMITER);
				fw.append(bk.getTitle());
				fw.append(COMMA_DELIMITER);
				fw.append(String.valueOf(bk.getType()));
				fw.append(COMMA_DELIMITER);
				fw.append(bk.getContent());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}
	
	public void WriteCSVLoan(List<Loan> list)
	{
		try
		{//TODO
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(Loan lo : list)
			{
/*				fw.append(String.valueOf(lo.getID()));
				fw.append(COMMA_DELIMITER);
				fw.append(bk.getTitle());
				fw.append(COMMA_DELIMITER);
				fw.append(String.valueOf(bk.getType()));
				fw.append(COMMA_DELIMITER);
				fw.append(bk.getContent());
				fw.append("\n");
	*/		}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}
	
	public void WriteCSVUsers(List<User> list)
	{
		try
		{
			FileWriter fw = new FileWriter("librarybooks.csv");
			for(User us : list)
			{
				fw.append(String.valueOf(us.getID()));
				fw.append(COMMA_DELIMITER);
				fw.append(us.getName());
				fw.append(COMMA_DELIMITER);
				fw.append(us.get_document());
				fw.append(COMMA_DELIMITER);
				fw.append(us.getEmail());
				fw.append(COMMA_DELIMITER);
				fw.append(us.getPassword());
				fw.append("\n");
			}
			
			fw.flush();
			fw.close();
			
		} catch(IOException ex){}
	}

}
