package br.fiap.conta;

import br.fiap.cliente.Cliente;

public class Conta {
	
	private Cliente cliente;
	private double saldo;

	public Conta(Cliente cliente, double saldo) {
		super();
		this.cliente = cliente;
		this.saldo = saldo;
	}
	

	
	public String getDados() {
		String aux = ""; // essas aspas significa string vazia
		aux += "CPF: " + cliente.getCpf() + "\n";
		aux += "Nome: " + cliente.getNome() + "\n";
		aux += "Saldo R$: " + saldo;
		
		return aux;
	}
}
