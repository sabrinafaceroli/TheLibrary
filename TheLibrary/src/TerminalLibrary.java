import java.util.ArrayList;
import java.util.Scanner;

import libraryBook.*;

public class TerminalLibrary {

	public static void main(String[] args) {
		
		ArrayList<Book> _books;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Olá mundo !!! Digite Ola para continuar");
		String resp = sc.nextLine();
		
		if(resp.equalsIgnoreCase("ola"))
			System.out.println("MUITO BEEEMMMMM!!!!");
		//else if(resp.equals("ola"))
		//	System.out.println("ERRRROWWWW!!!!");
		
	}

}
