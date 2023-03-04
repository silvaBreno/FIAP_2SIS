package teste;

import java.util.Scanner;

import listas.ListaIntCrescente;

public class MainTeste {

	public static void main(String[] args) {
		
		ListaIntCrescente lista = new ListaIntCrescente();
		Scanner in = new Scanner(System.in);;
		System.out.print("Valor positivo insere na lista (negativo encerra):");
		int valor = in.nextInt();
		
		while (valor >= 0) {
			lista.insere(valor);
			lista.show();
			
			System.out.print("Valor positivo insere na lista (negativo encerra):");
			valor = in.nextInt();
		}
		
		System.out.println();
		System.out.println("A quantidade de nós da lista é: " + lista.contaNos());
		System.out.println();
		
		
		System.out.print("Informe o limite inferior dos nós a ser pesquisados na lista: ");
		valor = in.nextInt();
		lista.showMaiores(valor);
		
		System.out.print("Valor positivo para remover da lista (negativo encerra):");
		valor = in.nextInt();
		while (valor > 0) {
			lista.remove(valor);
			lista.show();
			System.out.print("Valor positivo para remover da lista (negativo encerra):");
			valor = in.nextInt();
		}
		
		in.close();

	}

}
