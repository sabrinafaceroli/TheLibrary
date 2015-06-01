import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import libraryBook.Book;
import libraryLoan.Loan;
import libraryUsers.User;
import csv.*;


public class TheLibrary extends Application {

	public static int _id = 0;
	static String sysTime;
	static ArrayList<Book> _books = new ArrayList<Book>();
	static ArrayList<User> _users = new ArrayList<User>();
	static ArrayList<Loan> _loans = new ArrayList<Loan>();
	
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("*******THE LIBRARY********");
		
		try {
			FXMLLoader loader = new FXMLLoader(TheLibrary.class.getResource("TheLibrary.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		_books = ReadCSV.ReadCSVBook();
		_users = ReadCSV.ReadCSVUsers();
		
		launch(args);
	}
	
	public TheLibrary()
	{}
}
