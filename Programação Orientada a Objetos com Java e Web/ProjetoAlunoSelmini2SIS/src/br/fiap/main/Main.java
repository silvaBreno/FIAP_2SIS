package br.fiap.main;

import br.fiap.aluno.Aluno;
import br.fiap.aluno.AlunoFundamental;
import br.fiap.aluno.AlunoPosGraduacao;
import br.fiap.aluno.AlunoGraduacao;

public class Main {

	public static void main(String[] args) {
		
		Aluno[] aluno = new Aluno[3];
		
		aluno[0] = new AlunoFundamental(1,"Joaozinho",10,9.5,2);
		aluno[1] = new AlunoGraduacao(50,"Patricia",10,10,"SI",10);
		aluno[2] = new AlunoPosGraduacao(100,"Ana",9.5,9.5);
		
		for (int i = 0; i < aluno.length; i++) {
			System.out.println(aluno[i]);
			System.out.println("------------------------|");
		}
	}

}
