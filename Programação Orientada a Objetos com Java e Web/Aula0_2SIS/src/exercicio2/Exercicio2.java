package exercicio2;

import java.util.Scanner;

public class Exercicio2 {

	public static final int N = 30; // uso o final para definir o N como uma constante ate o final do codigo
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		int[] rm = new int[N];
		int[] aprovados = new int[N];
		double[] nota1 = new double[N];
		double[] nota2 = new double[N];
		double[] media = new double[N];
		
		int nAlunos = entradaDados(rm, nota1, nota2);
		
		calculaMedia(nAlunos, nota1, nota2, media);
		int i;
		for (i = 0; i < nAlunos ;i++) {
			System.out.println("\tRM: " + rm[i] + " \t Média: " + media[i] );
		}
		
		int nAp = geraListaAprovados(nAlunos, media, rm, aprovados);
		
		System.out.println("\n\n ***** Alunos aprovados *****");
		for(i = 0; i< nAp; i++) {
			System.out.println("\t" + aprovados[i]);	
		}
		
	}
	
	
	public static int entradaDados(int[] rm, double[] nota1, double[] nota2) {
		
		Scanner teclado = new Scanner(System.in);
		int i = 0;
		
		System.out.print("Informe o RM do aluno: ");
		int r = teclado.nextInt();
		while (r >0 && i < N) {
			rm[i] = r;
			System.out.print("\t1a Nota: ");
			nota1[i] = teclado.nextDouble();
			System.out.print("\t2a Nota: ");
			nota2[i] = teclado.nextDouble();
			i++;
			System.out.print("Informe RM ou digite o valor negativo para encerrar a entrada de dados: ");
			r = teclado.nextInt(); 
		}
		teclado.close();
		return i;
	}
	
	public static void calculaMedia(int nAlunos, double[] nota1, double[] nota2, double[] media) {
		
		for (int i=0; i<nAlunos; i++) {
			media[i] = (nota1[i] + nota2[i]) / 2;
		}
	
	}
	
	public static int geraListaAprovados(int nAlunos, double[] media, int[] rm, int[] aprovados) {
		
		
		
		int nAp = 0;	
		for(int i = 0; i< nAlunos; i++) {
			if (media[i] >= 6){
				aprovados[nAp] = rm[i];
				nAp++;
			}
		}
		return nAp;
	}
}
