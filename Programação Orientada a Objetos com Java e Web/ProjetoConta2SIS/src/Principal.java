import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Conta primeiraConta = new Conta();
		
		//entrada dos dados
		
		System.out.print("Nome do Titular: ");
		primeiraConta.titular = teclado.nextLine();
		System.out.print("Número da Conta: ");
		primeiraConta.numero = teclado.nextInt();
		
	
		//operacao de deposito
		System.out.print("Informe o valor do depósito: ");
		double valor = teclado.nextDouble();
		primeiraConta.depositar(valor);
		System.out.println("O saldo atual da conta após o deposito é: R$" + primeiraConta.consultarSaldo());
		
		//operacao de saque
		System.out.print("Informe o valor do saque: ");
		valor = teclado.nextDouble();
		primeiraConta.sacar(valor);
		System.out.println("O saldo atual da conta após o saque é: R$" + primeiraConta.consultarSaldo());
		
		//consulta do saldo
		System.out.println("O saldo atual da conta é: R$" + primeiraConta.consultarSaldo());
	}

}
