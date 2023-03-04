package br.fiap.cliente;

public abstract class Cliente {
	private String nome;

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
	}
	
}
