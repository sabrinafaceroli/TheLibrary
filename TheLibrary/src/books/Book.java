package books;

public class Book {
	private int 	 _id; // ID para a indentificacao do livro
	private String	 _title; // Titulo do livro	
	private int		 _type;	// Tipo do Livro: 1- Texto; 2- Geral;
	private String	 _content; // Variavel adicional para o conteudo do livro(???)
	
	public Book(int ID, String Title, int Type, String Content, int Quantity)
	{
		_id 		= ID;
		_title 		= Title;
		_type 		= type;
		_content	= Content;
	}
	
	public int getType()
	{
		return _type;
	}
	//	OLAR
}
