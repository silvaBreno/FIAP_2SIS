
public class Conta {
	//atributos ou propriedades ou vari�veis de instancia
	double saldo;
	String titular;
	int agencia;
	int numero; 
	
	//m�todo para sacar um valor da conta
	public void sacar (double valor) {
		this.saldo = saldo - valor;  
	}
	
	//m�todo para depositar um valor na conta
	
	public void depositar (double valor) {
		this.saldo = saldo + valor; 
	}
	
	//m�todo para consultar o saldo da conta
	public double consultarSaldo () {
		return saldo;
	}
	
}
