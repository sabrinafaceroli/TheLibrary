package libraryBook;

public class Book {
	private int 	 _id; // ID para a indentificacao do livro
	private int		 _type;	// Tipo do Livro: 1- Texto; 2- Geral;
	private String	 _title; // Titulo do livro	
	private String	 _author;
	private String	 _publisher;
	private int		 _edition;
	
	public Book(int ID, String Title, int Type, String Publisher, String Author, int Edition) //int Quantity)
	{
		this._id 		= ID;
		this._title 	= Title;
		this._type 		= Type;
		this._author 	= Author;
		this._publisher	= Publisher;
		this._edition 	= Edition;
		
	}
	
	public Book(String csv)
	{
        String[] values = csv.split(",");
        this._id = Integer.parseInt(values[0]);
        this._title = values[1];
        this._type = Integer.parseInt(values[2]);
        this._author = values[3];
        this._publisher = values[4];
        this._edition = Integer.parseInt(values[5]);
	}

	public String toString(){
		return "" + this._id + "," + this._title + "," + this._type + "," +this._author +
				"," + this._publisher + "," + this._edition;
	} 
	
	//Getters and Setter
	public int getID(){return this._id;}
	public void setID(int id){ this._id = id;}
	
	public int getType(){return _type;}
	public void setType(int type){this._type = type;}
	
	public String getTitle(){return this._title;}
	public void setTitle(String title){this._title = title;}
	
	public String getAuthor(){return this._author;}
	public void setAuthor(String author){this._author = author;}
}
