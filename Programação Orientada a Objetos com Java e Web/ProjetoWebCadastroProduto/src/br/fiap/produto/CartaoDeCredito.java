package br.fiap.produto;

import br.fiap.cliente.Cliente;

public class CartaoDeCredito extends Produto {

	private int numero;
	private double saldo;
	
	public CartaoDeCredito(Cliente cliente, int numero, double saldo) {
		super(cliente);
		this.numero = numero;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Número: " + numero + "\n";
		aux += "Saldo: R$ " + saldo + "\n";
		return aux;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
