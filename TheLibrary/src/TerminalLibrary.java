import java.util.ArrayList;
import java.util.Scanner;


import libraryBook.*;
import libraryLoan.*;
import libraryUsers.*;


public class TerminalLibrary {

	public static void main(String[] args) {
		
		 ArrayList<Book> _books;
		 ArrayList<User> _users;
		 ArrayList<Loan> _loans;

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo à biblioteca ");
		String resp = sc.nextLine();
		
		if(resp.equalsIgnoreCase("ola"))
			System.out.println("MUITO BEEEMMMMM!!!!");
		//else if(resp.equals("ola"))
		//	System.out.println("ERRRROWWWW!!!!");
		
	}

}
