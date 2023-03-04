package br.fiap.aluno;

public class AlunoFundamental extends Aluno{
	
	//atributo especifico 
	private int serie;
	
	//construtor para inicializar os atributos
	public AlunoFundamental(long rm, String nome, double prova1, double prova2, int serie) {
		super(rm, nome, prova1, prova2);
		this.serie = serie;
	}
	
	//metodo para calcular e retornar media
	public double calcularMedia() {
		return (prova1+prova2)/2;
	}
}
