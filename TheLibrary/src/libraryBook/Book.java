package libraryBook;

public class Book {
	private int 	 _id; // ID para a indentificacao do livro
	private String	 _title; // Titulo do livro	
	private int		 _type;	// Tipo do Livro: 1- Texto; 2- Geral;
	private String	 _content; // Variavel adicional para o conteudo do livro(???)
	
	public Book(int ID, String Title, int Type, String Content) //int Quantity)
	{
		this._id 		= ID;
		this._title 	= Title;
		this._type 		= Type;
		this._content	= Content;
	}
	
	public Book(String csv)
	{
        String[] values = csv.split(",");
        this._id = Integer.parseInt(values[0]);
        this._title = values[1];
        this._type = Integer.parseInt(values[2]);
        this._content= values[3];
	}

	//Getting things up!
	
	public int getID(){
		return _id;   }
	
	public String getTitle(){
		return _title;      }
	
	public int getType(){
		return _type;	}
	
	public String getContent(){
		return _content;      }
	//	OLAR
	
}
