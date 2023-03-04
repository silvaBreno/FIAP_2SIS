package br.fiap.produto;

import br.fiap.cliente.Cliente;

public class Produto {
	
	private Cliente cliente;

	public Produto(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Nome: " + cliente.getNome() + "\n";
		aux += "CPF: " + cliente.getCpf() + "\n";
		return aux;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
