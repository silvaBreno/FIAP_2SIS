
public class Conta {
	//atributos ou propriedades ou variáveis de instancia
	double saldo;
	String titular;
	int agencia;
	int numero; 
	
	//método para sacar um valor da conta
	public void sacar (double valor) {
		this.saldo = saldo - valor;  
	}
	
	//método para depositar um valor na conta
	
	public void depositar (double valor) {
		this.saldo = saldo + valor; 
	}
	
	//método para consultar o saldo da conta
	public double consultarSaldo () {
		return saldo;
	}
	
}
