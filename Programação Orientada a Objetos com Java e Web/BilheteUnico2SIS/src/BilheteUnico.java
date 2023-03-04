import java.util.Random;
public class BilheteUnico {

	//atributos ou propriedades ou variaveis de instancia
	int numero;
	double saldo;
	double valorDaPassagem;
	Usuario usuario;
	
	//metodo construtor para inicialiar os atributos do objeto
	
	public BilheteUnico(String nome, String cpf, String tipo) {
		
		Random gerador = new Random();
		this.numero = gerador.nextInt(10000);
		this.saldo = 0;
		this.valorDaPassagem = 4.40;
		this.usuario = new Usuario(nome, cpf, tipo);
	}
	
	// metodo para retornar o valor do saldo do bilhete
	public double consultarSaldo(){
		return saldo;
	}
	// metodo para carregar o bilhete unico
	public void carregar(double valor){
		saldo += valor; 
	}
	
	//metodo para passar na catraca, ou seja, debitar um valor do saldo
	public boolean passarNaCatraca(){
		boolean aux = false;
		if(usuario.tipo.equalsIgnoreCase("normal")) {
			if(saldo >= valorDaPassagem) {
				saldo -= valorDaPassagem;
				aux = true;
			}
		} else {
			if (saldo >= (valorDaPassagem/2) ) {
				saldo -= (valorDaPassagem/2);
				aux = true;
			}
		}
		return aux;
	}
}
