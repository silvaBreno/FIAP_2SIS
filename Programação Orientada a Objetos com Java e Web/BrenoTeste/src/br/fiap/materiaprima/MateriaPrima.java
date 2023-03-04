package br.fiap.materiaprima;

public class MateriaPrima {

	String nome;
	String quantidade;
	
	public MateriaPrima(String nome, String quantidade) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	

	
	
}
