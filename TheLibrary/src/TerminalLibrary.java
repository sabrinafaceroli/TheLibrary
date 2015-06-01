import java.util.List;
import java.util.stream.Collectors;

import csv.ReadCSV;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import libraryLoan.Loan;
import libraryUsers.*;
import libraryBook.Book;

public class TerminalLibrary{
	
	private int _typeUser; //Para controlar o tipo de registro. 1 - Estudante, 2 - Professor, 3 - Comunidade
	
	@FXML
	private VBox UsersLayout, BooksLayout, LoansLayout, RegisterArea_Vbox, ChooseUser;
	
	@FXML
	private Button Users_Btn, Books_Btn, Loans_Btn, StudentReg_Btn, ProfessorReg_Btn, CommunityReg_Btn, ShowAllUsers_Btn,
					RegisterUsers_Btn, ShowAllBooks_Btn, RegisterBooks_Btn, ShowAllLoans_Btn, RegisterLoans_Btn,
					SaveDate_Btn;
	
	@FXML
	private HBox Curso_Hbox, Departamento_Hbox, Instituto_Hbox, Emprego_Hbox;
	
	@FXML
	private TextField NomeUser_TextField, DocumentoUser_TextField, EmailUser_TextField, SenhaUser_TextField, EmpregoUser_TextField,
						InstitutoUser_TextField, DepartamentoUser_TextField, CursoUser_TextField, IDBook_TextField, NomeBook_TextField,
						TipoBook_TextField, AutorBook_TextField, EditoraBook_TextField, EdicaoBook_TextField, IDUsuarioLoan_TextField, IDLivroLoan_TextField, Data_TextField;
	
	@FXML
	private TextArea ShowUsersArea, ShowBooksArea, ShowLoansArea;
	
	@FXML
	private void initialize()
	{
		UsersLayout.setVisible(false);
		BooksLayout.setVisible(false);
		LoansLayout.setVisible(false);
		
		//Eventos de todos os botões
		
		SaveDate_Btn.setOnAction((event) -> {
			
			if(Data_TextField.getText() != "")
			{
				String date = Data_TextField.getText();
				TheLibrary.sysTime = date;
				TheLibrary._loans = ReadCSV.ReadCSVLoan(date);
				Data_TextField.setDisable(true);
				SaveDate_Btn.setVisible(false);
				
				Users_Btn.setDisable(false);
				Books_Btn.setDisable(false);
				Loans_Btn.setDisable(false);
			}
		});
		
		Users_Btn.setOnAction((event) -> {
			UsersLayout.setVisible(true);
			BooksLayout.setVisible(false);
			LoansLayout.setVisible(false);
		});
		
		Books_Btn.setOnAction((event) -> {
			UsersLayout.setVisible(false);
			BooksLayout.setVisible(true);
			LoansLayout.setVisible(false);
		});
		
		Loans_Btn.setOnAction((event) -> {
			UsersLayout.setVisible(false);
			BooksLayout.setVisible(false);
			LoansLayout.setVisible(true);
		});
		
		StudentReg_Btn.setOnAction((event) -> {
			RegisterArea_Vbox.setVisible(true);
			Curso_Hbox.setVisible(true);
			Departamento_Hbox.setVisible(false);
			Instituto_Hbox.setVisible(false);
			Emprego_Hbox.setVisible(false);
			_typeUser = 1;
			
		});
		
		ProfessorReg_Btn.setOnAction((event) -> {
			RegisterArea_Vbox.setVisible(true);
			Curso_Hbox.setVisible(false);
			Departamento_Hbox.setVisible(true);
			Instituto_Hbox.setVisible(true);
			Emprego_Hbox.setVisible(false);
			_typeUser = 2;
		});
		
		CommunityReg_Btn.setOnAction((event) -> {
			RegisterArea_Vbox.setVisible(true);
			Curso_Hbox.setVisible(false);
			Departamento_Hbox.setVisible(false);
			Instituto_Hbox.setVisible(false);
			Emprego_Hbox.setVisible(true);
			_typeUser = 3;
		});
		
		ShowAllUsers_Btn.setOnAction((event) -> {
			TheLibrary._users
			.stream()
			.forEach(us -> {
				ShowUsersArea.appendText(us.toString());
			});
		});
		
		RegisterUsers_Btn.setOnAction((event) -> {
			User us;
			
			if(_typeUser == 1)
			{
				us = new Student(TheLibrary._id, NomeUser_TextField.getText(), DocumentoUser_TextField.getText(), 
							EmailUser_TextField.getText(), SenhaUser_TextField.getText(), CursoUser_TextField.getText());
			}
			else if(_typeUser == 2)
			{
				us = new Professor(TheLibrary._id, NomeUser_TextField.getText(), DocumentoUser_TextField.getText(), 
								EmailUser_TextField.getText(), SenhaUser_TextField.getText(), InstitutoUser_TextField.getText(), 
								DepartamentoUser_TextField.getText());
			}
			else
			{
				us = new Community(TheLibrary._id, NomeUser_TextField.getText(), DocumentoUser_TextField.getText(), 
						EmailUser_TextField.getText(), SenhaUser_TextField.getText(), EmpregoUser_TextField.getText()); 
			}
			
			TheLibrary._users.add(us);
			
			NomeUser_TextField.clear();
			DocumentoUser_TextField.clear();
			EmailUser_TextField.clear();
			SenhaUser_TextField.clear();
			EmpregoUser_TextField.clear();
			InstitutoUser_TextField.clear();
			DepartamentoUser_TextField.clear();
			CursoUser_TextField.clear();
		});
		
		ShowAllBooks_Btn.setOnAction((event) -> {
			TheLibrary._books
			.stream()
			.forEach(bk -> {
				ShowBooksArea.appendText(bk.toString());
			});
		});
		
		RegisterBooks_Btn.setOnAction((event) -> {
			
			Book bk = new Book(Integer.parseInt(IDBook_TextField.getText()), NomeBook_TextField.getText(), Integer.parseInt(TipoBook_TextField.getText()),
								AutorBook_TextField.getText(), EditoraBook_TextField.getText(), Integer.parseInt(EdicaoBook_TextField.getText()));	
			
			TheLibrary._books.add(bk);
			
			IDBook_TextField.clear();
			NomeBook_TextField.clear();
			TipoBook_TextField.clear();
			AutorBook_TextField.clear();
			EditoraBook_TextField.clear();
			EdicaoBook_TextField.clear();
		});
		
		ShowAllLoans_Btn.setOnAction((event) -> {
			TheLibrary._loans
			.stream()
			.forEach(lo -> {
				ShowLoansArea.appendText(lo.toString());
			});
		});
		
		RegisterLoans_Btn.setOnAction((event) -> {
			
			List<User> ls = 
			TheLibrary._users
			.stream()
			.filter(us -> us.getID() == Integer.parseInt(IDUsuarioLoan_TextField.getText()))
			.limit(1)
			.collect(Collectors.toList());
			
			User us = ls.get(0);
			Loan ln;
			
			if(us instanceof Professor)
				ln = new Loan(Integer.parseInt(IDLivroLoan_TextField.getText()), Integer.parseInt(IDUsuarioLoan_TextField.getText()), TheLibrary.sysTime, 1);
			else if(us instanceof Student)
				ln = new Loan(Integer.parseInt(IDLivroLoan_TextField.getText()), Integer.parseInt(IDUsuarioLoan_TextField.getText()), TheLibrary.sysTime, 2);
			else
				ln = new Loan(Integer.parseInt(IDLivroLoan_TextField.getText()), Integer.parseInt(IDUsuarioLoan_TextField.getText()), TheLibrary.sysTime, 3);
			
			TheLibrary._loans.add(ln);
			
			IDUsuarioLoan_TextField.clear();
			IDLivroLoan_TextField.clear();
		});
	}
}