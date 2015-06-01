import java.util.ArrayList;
import java.util.Scanner;

import csv.WriteCSV;
import libraryBook.*;
import libraryLoan.*;
import libraryUsers.*;


public class TerminalLibrary {

	public static void main(String[] args) {
		
		String sysTime = args[0];
		ArrayList<Book> _books = new ArrayList<Book>();
		ArrayList<User> _users = new ArrayList<User>();
		ArrayList<Loan> _loans = new ArrayList<Loan>();
		String insertion[];
		int choice, id = 1;
		
		insertion =  new String[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo à Biblioteca Orientada a Objetos!!!");
		
		do{
			System.out.println("Digite :");
			System.out.println(" 1 - Para adicionar um Usuário");
			System.out.println(" 2 - Para adicionar um Livro");
			System.out.println(" 3 - Para adicionar um Empréstimo");
			
			choice = Integer.parseInt(sc.nextLine());
			if(choice == 1){
				System.out.println("\t 11 - Para o Usuário ser um Professor");
				System.out.println("\t 12 - Para o Usuário ser um Aluno");
				System.out.println("\t 13 - Para o Usuário ser um Pessoa da Comunidade");
				choice = Integer.parseInt(sc.nextLine());
				if(choice == 11){
					insertion[0] = 1000000 + "";
					System.out.println("\t\tDigite o nome do professor:");
					insertion[1] = sc.nextLine();
					System.out.println("\t\tDigite o documento do professor:");
					insertion[2] = sc.nextLine();
					System.out.println("\t\tDigite o email do professor:");
					insertion[3] = sc.nextLine();
					System.out.println("\t\tDigite a senha do professor:");
					insertion[4] = sc.nextLine();
					System.out.println("\t\tDigite o departamento do professor:");
					insertion[5] = sc.nextLine();
					System.out.println("\t\tDigite o instituto do professor:");
					insertion[6] = sc.nextLine();
					
					Professor toAdd = new Professor(insertion);
					_users.add(toAdd);
					
				}
				else if (choice == 12){
					insertion[0] = 3000000 + "";
					System.out.println("\t\tDigite o nome do aluno:");
					insertion[1] = sc.nextLine();
					System.out.println("\t\tDigite o documento do aluno:");
					insertion[2] = sc.nextLine();
					System.out.println("\t\tDigite o email do aluno:");
					insertion[3] = sc.nextLine();
					System.out.println("\t\tDigite a senha do aluno:");
					insertion[4] = sc.nextLine();
					System.out.println("\t\tDigite o curso do aluno:");
					insertion[5] = sc.nextLine();
					
					Student toAdd = new Student(insertion);
					_users.add(toAdd);

				}
				else if (choice == 13){
					insertion[0] = 2000000 + "";
					System.out.println("\t\tDigite o nome da pessoa da comunidade:");
					insertion[1] = sc.nextLine();
					System.out.println("\t\tDigite o documento do pessoa da comunidade:");
					insertion[2] = sc.nextLine();
					System.out.println("\t\tDigite o email do pessoa da comunidade:");
					insertion[3] = sc.nextLine();
					System.out.println("\t\tDigite a senha do pessoa da comunidade:");
					insertion[4] = sc.nextLine();
					System.out.println("\t\tDigite o trabalho do pessoa da comunidade:");
					insertion[5] = sc.nextLine();
					
					Community toAdd = new Community(insertion);
					_users.add(toAdd);
					
				}		
			}
			else if(choice == 2){
				System.out.println("Digite o numero de identificação do livro:");
				insertion[0] = sc.nextLine();
				System.out.println("\t\tDigite o nome do livro:");
				insertion[1] = sc.nextLine();
				System.out.println("\t\tDigite o tipo do livro(1 - Academico; 2 - Texto Geral):");
				insertion[2] = sc.nextLine();
				System.out.println("\t\tDigite o autor do livro:");
				insertion[3] = sc.nextLine();
				System.out.println("\t\tDigite a editora do livro:");
				insertion[4] = sc.nextLine();
				System.out.println("\t\tDigite a edição do livro:");
				insertion[5] = sc.nextLine();
				System.out.println("\t\tDigite o número de páginas do livro:");
				insertion[6] = sc.nextLine();
				insertion[7] = insertion[0] +","+insertion[1] +","+insertion[2] +","+
						insertion[3] +","+insertion[4] +","+insertion[5] +","+insertion[6];
				Book toAdd = new Book(insertion[7]);
				_books.add(toAdd);
			}
			else if(choice == 3){
				System.out.println("Digite o numero de identificação do empréstimo:");
				insertion[0] = sc.nextLine();
				System.out.println("\t\tDigite o nome do livro: ");
				insertion[1] = sc.nextLine();
				System.out.println("\t\tDigite o tipo do livro(1 - Academico; 2 - Texto Geral):");
				insertion[2] = sc.nextLine();
				System.out.println("\t\tDigite o autor do livro: ");
				insertion[3] = sc.nextLine();
				System.out.println("\t\tDigite a editora do livro:");
				insertion[4] = sc.nextLine();
				System.out.println("\t\tDigite a edição do livro:");
				insertion[5] = sc.nextLine();
				System.out.println("\t\tDigite o número de páginas do livro:");
				insertion[6] = sc.nextLine();
			}
			
		}while(choice == 0);
		
		WriteCSV.WriteCSVUsers(_users);
		
		
	}

}
