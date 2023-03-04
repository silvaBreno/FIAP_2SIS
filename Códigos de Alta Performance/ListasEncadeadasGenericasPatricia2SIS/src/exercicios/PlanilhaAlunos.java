package exercicios;

import java.util.Scanner;

import listas.ListaAlunos;

public class PlanilhaAlunos {

	public static void main(String[] args) {
		
		ListaAlunos turma = new ListaAlunos();
		Scanner le = new Scanner(System.in);
		int op;
		
		do {
			System.out.println("0 - Encerra programa");
			System.out.println("1 - Insere aluno");
			System.out.println("2 - Remove aluno");
			System.out.print("Opcao: ");
			op = le.nextInt();
			
			switch(op) {
			
			case 0:
				System.out.println("Encerrando o progarama....");
				break;
			case 1:
				System.out.println("informe o RM: ");
				int rm = le.nextInt();
				System.out.println("Média: ");
				double media = le.nextDouble();
				Aluno aluno = new Aluno(rm, media);
				turma.insere(aluno);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
			
			}
		
		}while (op != 0);
		le.close();
	}
}
