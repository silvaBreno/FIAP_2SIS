import java.util.Scanner;

public class Aluno {
	
	final int N = 30;
	double[] nota1 = new double[N];
	double[] nota2 = new double[N];
	double[] media = new double[N];
	int[] rm = new int[N];
	int numeroRM;
	int i = 0;
	
	//entradaDados(): para ler o RM e notas de cada aluno
	
	public void entradaDados(){
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Informe o RM do aluno: ");
		numeroRM = teclado.nextInt();
		
		while(numeroRM > 0 && i < N){
			rm[i] = numeroRM;
			System.out.print("\t1a Nota: ");
			nota1[i] = teclado.nextDouble();
			System.out.print("\t2a Nota: ");
			nota2[i] = teclado.nextDouble();
			i++;
			System.out.println();
			System.out.print("Informe RM ou digite o valor negativo para encerrar a entrada de dados: ");
			numeroRM = teclado.nextInt(); 
		}
		
		teclado.close();
		
	}
	
	
	//calculaMedia(): para calcular média de cada aluno gerando o vetor médias
	
	public void calculaMedia(){
		
		int nAlunos = i;
		for(i = 0; i <nAlunos ;i++) {
			
			media[i] = (nota1[i] + nota2[i])/2;
			
			System.out.println("\tRM: " + rm[i] + "\tMédia: " + media[i]);
		}
		
	}
	
	
	//geraListaAprovados(): para gerar um vetor contendo apenas os RMs dos alunos aprovador (média maior ou igual a 6,0)
	
	public void geraListaAprovados(){
		
		System.out.println("\nAlunos aprovados: ");
			for(i = 0; i <N ;i++) {
				
				if (media[i]>= 6) {
					System.out.println("\tRM: " + rm[i] + "\tMédia: " + media[i]);
					
				}
				
			}
	}
		
}
