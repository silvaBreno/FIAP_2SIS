package exercicio1;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		// codigos de alta performance
		
		Scanner teclado = new Scanner(System.in);
		final int N = 30; // uso o final para definir o N como uma constante ate o final do codigo
		
		
		int[] rm = new int[N];
		double[] nota1 = new double[N];
		double[] nota2 = new double[N];
		double[] media = new double[N];
		
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
	
		int nAlunos = i;
		for (i=0; i<nAlunos; i++) {
			media[i] = (nota1[i] + nota2[i]) / 2;
			
			System.out.println("\tRM: " + rm[i] + " \t Média: " + media[i] );
		}
		
			System.out.println("Alunos aprovados: ");
		
			
		int nAp = 0;	
		for(i = 0; i< nAp; i++) {
			if (media[i] >= 6){
				System.out.println("\t" + rm[i]);
			}
		}
	

		teclado.close();
	}

}
