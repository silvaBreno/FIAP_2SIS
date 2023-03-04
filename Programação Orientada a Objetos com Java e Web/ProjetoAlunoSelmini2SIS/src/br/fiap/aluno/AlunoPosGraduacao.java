package br.fiap.aluno;

public class AlunoPosGraduacao extends Aluno {
	
	//construtor para inicializar os atributos --> clicar em Source + generate constructor from Superclass
	// uso esse metodo com o generate constructor from Superclass porque nesse caso nao tem variaveis declarada para inicializar
    //tem apenas na super classe
	public AlunoPosGraduacao(long rm, String nome, double prova1, double prova2) {
		super(rm, nome, prova1, prova2);
		
	}

		//metodo para calcular e retornar a média
		public double calcularMedia() {		
			return ((prova1*0.4)+(prova2*0.6));
		}
}
