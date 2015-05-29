package libraryBook;

public class Book {
	private int 	 _id; // ID para a indentificacao do livro
	private String	 _title; // Titulo do livro	
	private int		 _type;	// Tipo do Livro: 1- Texto; 2- Geral;
	private String	 _content; // Variavel adicional para o conteudo do livro(???)
	
	public Book(int ID, String Title, int Type, String Content, int Quantity)
	{
		_id 		= ID;
		_title 		= Title;
		_type 		= Type;
		_content	= Content;
	}
	
	
	
	public String toString(){
		return "" + this._id + "|" + this._title + "|" + this._type + "|" +this._content;
	}
	
	//Getters and Setter
	public int getID(){return this._id;}
	public void setID(int id){ this._id = id;}
	
	public int getType(){return _type;}
	public void setType(int type){this._type = type;}
}
