import java.util.ArrayList;
import java.util.Scanner;

import csv.ReadCSV;
import csv.WriteCSV;
import libraryBook.*;
import libraryLoan.*;
import libraryUsers.*;


public class TheLibraryTerminal {

	public static void main(String[] args) {
		System.out.println("Bem vindo à Biblioteca Orientada a Objetos!!!");
		
		
		ArrayList<Book> _books = ReadCSV.ReadCSVBook();
		ArrayList<User> _users = ReadCSV.ReadCSVUsers();
		ArrayList<Loan> _loans;// = ReadCSV.ReadCSVLoan(sysTime);
		String insertion[];
		int choice, id = 1;
		
		insertion =  new String[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a data padrão da biblioteca no formato YYYY/MM/DD :");
		String sysTime = sc.nextLine();
		_loans = ReadCSV.ReadCSVLoan(sysTime);
		
		do{
			System.out.println("Digite :");
			System.out.println(" 1 - Para adicionar um Usuário");
			System.out.println(" 2 - Para adicionar um Livro");
			System.out.println(" 3 - Para adicionar um Empréstimo");
			System.out.println(" 4 - Para exibir todos os Usuários");
			System.out.println(" 5 - Para exibir todos os Livros");
			System.out.println(" 6 - Para exibir todos os Empréstimos");
			
			System.out.println(" 0 - Para sair do programa");
			
			
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
				boolean flagUser = true, flagBook = true;
				User usr;
				Book bk;
				System.out.println("Digite o numero de identificação do empréstimo:");
				insertion[0] = sc.nextLine();
				System.out.println("\t\tDigite o id do Usuário: ");
				insertion[1] = sc.nextLine();
				System.out.println("\t\tDigite o ID do Livro:");
				insertion[2] = sc.nextLine();
				flagUser = _users.stream().anyMatch((u) -> u.getID() == Integer.parseInt(insertion[1]));
				flagBook = _loans.stream().anyMatch((l) -> l.getBook() == Integer.parseInt(insertion[2]));
				for (User u : _users) {
					if(u.getID() == Integer.parseInt(insertion[1]))
						flagUser = true;
				}
			}

			
			else if(choice == 4){
				_users.stream().forEach(System.out::println);
			}
			else if(choice == 5){
				_books.stream().forEach(System.out::println);
			}
			else if(choice == 6){
				_loans.stream().forEach(System.out::println);
			}
			
		}while(!(choice == 0));
		
		WriteCSV.WriteCSVUsers(_users);
		WriteCSV.WriteCSVBook(_books);
		WriteCSV.WriteCSVLoan(_loans);
		
	}

}
