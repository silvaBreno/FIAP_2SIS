package exercicio4;

import java.util.Scanner;

import tipoPilha.TipoPilhaInt;

public class DecBin {

	public static void main(String[] args) {
		
		TipoPilhaInt pilha = new TipoPilhaInt();
		pilha.init();
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Valor em decimal: ");
		int decimal = teclado.nextInt();
		int resto;
		
		while(decimal != 0) {	
			resto = decimal % 2;
			pilha.push(resto);
			decimal = decimal / 2;
		}
		
		System.out.println("Valor em Binário: ");
		pilha.esvaziaPilha();
		
		teclado.close();
	}
}
