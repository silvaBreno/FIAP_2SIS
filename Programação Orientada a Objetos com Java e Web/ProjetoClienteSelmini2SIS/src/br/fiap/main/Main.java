package br.fiap.main;

import br.fiap.cliente.Cliente;
import br.fiap.conta.Conta;

public class Main {

	public static void main(String[] args) {
		
		Conta[] conta = new Conta[3];
		
		conta[0] = new Conta(new Cliente("123", "Ana"), 10000);
		conta[1] = new Conta(new Cliente("456", "Maria"), 25000);
		conta[2] = new Conta(new Cliente("789", "Bete"), 5000);
		
		for(Conta c: conta) {
			System.out.println(c.getDados());
			System.out.println();
		}
	}

}
