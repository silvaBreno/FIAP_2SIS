package br.fiap.aluno;

public class AlunoGraduacao extends Aluno{
	
	//atributos especificos
	private String curso;
	private double trabalho;
	
	//construtor para iniciar os atributos de um objeto AlunoGracuacao
	public AlunoGraduacao(long rm, String nome, double prova1, double prova2, String curso, double trabalho) {
		super(rm, nome, prova1, prova2);
		this.curso = curso;
		this.trabalho = trabalho;
	}
	
	//metodo para calcular e retornar a média
	public double calcularMedia() {		
		return (((prova1+prova2)/2)*0.7)+ (trabalho*0.3);
	}
}
