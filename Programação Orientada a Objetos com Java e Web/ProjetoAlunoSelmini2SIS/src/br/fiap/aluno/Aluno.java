package br.fiap.aluno;

public abstract class Aluno {

	//atributos que serao compartilhados
	protected long rm;
	protected String nome;
	protected double prova1;
	protected double prova2;
	
	//construtor para inicializar os atributos --> clicar em Source + generate constructor using fields
	public Aluno(long rm, String nome, double prova1, double prova2) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.prova1 = prova1;
		this.prova2 = prova2;
	}

	public abstract double calcularMedia();
	
	@Override
	public String toString() {
		String aux = "";
		aux += "RM: " + rm + "\n";
		aux += "Nome Aluno: " + nome + "\n";
		aux += "Média: " + calcularMedia();
		return aux;
	}
}
