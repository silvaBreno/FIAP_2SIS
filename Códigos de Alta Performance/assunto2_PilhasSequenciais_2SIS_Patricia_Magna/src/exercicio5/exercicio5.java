package exercicio5;

import java.util.Scanner;

import tipoPilha.TipoPilhaInt;

public class exercicio5 {

	public static void main(String[] args) {
		
		
		Scanner le = new Scanner(System.in);
		int[] numero = new int[5];
		int[] inverso = new int[5];
		TipoPilhaInt pilha = new TipoPilhaInt();
		pilha.init();
		System.out.print("Dígito: ");
		int digito = le.nextInt();
		int n = 0;
		while (digito > 0) {
			numero[n] = digito;
			n++;
			pilha.push(digito);
			System.out.print("Dígito: ");
			digito = le.nextInt();
		}
		int i = 0;
		while(!pilha.isEmpty()) {
			inverso[i] = pilha.pop();	
			i++;
		}
		boolean palindromo = true;
		for(i = 0; palindromo && i < n; i++) {
			if (numero[i] != inverso[i]) {
				palindromo = false;
			}
		}
		
		if (palindromo)
			System.out.println("É palíndromo");
		else
			System.out.println("Nao é palíndromo");
		
		le.close();
	}

}
