package br.fiap.entidades;

public class Banco {
	private String codBanco;
	private String nome;

	public Banco(String codBanco, String nome) {
		super();
		this.codBanco = codBanco;
		this.nome = nome;
	}

	public String getCodBanco() {
		return codBanco;
	}

	public String getNome() {
		return nome;
	}

	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return codBanco + " - " + nome;
	}
}
