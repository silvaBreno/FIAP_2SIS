package exercicio2;

import java.util.Scanner;

import listas.ListaAlunos;

public class PlanilhaAlunos {

	public static void main(String[] args) {
		
		ListaAlunos turma = new ListaAlunos();
		Scanner le = new Scanner(System.in);
		int op;
		do {
			System.out.println("0- Encerra programa");
			System.out.println("1- Insere aluno");
			System.out.println("2- Remove aluno");
			System.out.println("3- Consulta m�dia do aluno");
			System.out.print("Op��o: ");
			op = le.nextInt();
			switch(op) {
			case 0:
				System.out.println("Encerrando o programa....");
				break;
			case 1:
				System.out.print("Informe o RM: ");
				int rm = le.nextInt();
				System.out.print("M�dia :");
				double media = le.nextDouble();
				Aluno aluno = new Aluno(rm, media);
				turma.insere(aluno);
				turma.show();
				break;
			case 2:
				System.out.print("Informe o RM do aluno a ser removido: ");
				rm = le.nextInt();
				turma.remove(rm);
				turma.show();
				break;
			case 3:
				System.out.print("Informe o RM do aluno a ser pesquisado: ");
				rm = le.nextInt();
				double m = turma.consultaMedia(rm);
				if (m==-1)
					System.out.println("Aluno n�o encontrado");
				else
					System.out.println("M�dia do aluno �: "+ m);
				break;
			default:
				System.out.println("Op��o inv�lida");
			}
			
		}while (op!=0);
		le.close();

	}

}
