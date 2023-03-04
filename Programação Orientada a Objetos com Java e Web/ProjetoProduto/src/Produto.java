
public class Produto {

	String nome;
	double valor;
	
	//sempre que eu quiser iniciar uma variavel do objeto com os valores fora do padrao do tipo da variavel (null e 0)
	// preciso criar um metodo construtor para modificar esse valor.
	public Produto(String nome, double valor) {
		
		this.nome = nome;
		this.valor = valor;
	}
}
