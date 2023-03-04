
public class Usuario {

	// atributos ou propriedades ou variaveis de instancia
	String nome;
	String cpf;
	String tipo;
	
	//metodo construtor para inicializar os atributos do objeto no momento da instanciacao
	// o construtor tem duas regrinhas basicas, sendo:
	//1a--> nao tem nenhum tipo
	//2a--> nome do construtor é o mesmo nome da classe
	// a palavra static ele determina que aquele metodo n estara dentro do objeto
	public Usuario(String nome, String cpf, String tipo) {
		this.nome = nome ;
		this.cpf = cpf;
		this.tipo = tipo;
		
		//o this eh responsavel por fazer referencia a variavel presente no meu objeto
	}
}
