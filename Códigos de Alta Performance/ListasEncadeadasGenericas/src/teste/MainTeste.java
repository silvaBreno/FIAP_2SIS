package teste;

import java.util.Scanner;

import listas.ListaIntCrescente;

public class MainTeste {

	public static void main(String[] args) {

		ListaIntCrescente lista = new ListaIntCrescente();
		Scanner le = new Scanner(System.in);
		System.out.print("Valor positivo insere na lista (negativo encerra): ");
		int valor = le.nextInt();
		while (valor >= 0) {
			lista.insere(valor);
			lista.show();
			System.out.print("Valor positivo insere na lista (negativo encerra): ");
			valor = le.nextInt();
		}
		
		System.out.println("A quantidade de n�s da lista �: "+lista.contaNos()); //Apresenta a quantidade de n�s da lista
		
		System.out.print("Informe o limite inferior dos n�s a serem pesquisados na lista: ");
		valor = le.nextInt();
		lista.showMaiores(valor);
		
		System.out.print("Valor positivo para remover da lista (negativo encerra): ");
		valor = le.nextInt();
		while (valor >= 0) {
			lista.remove(valor);
			lista.show();
			System.out.print("Valor positivo para remover da lista (negativo encerra): ");
			valor = le.nextInt();
		}
		
		
		le.close();

	}

}
