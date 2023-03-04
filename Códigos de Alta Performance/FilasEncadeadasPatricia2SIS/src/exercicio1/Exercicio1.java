package exercicio1;
import java.util.Scanner;

import filas.FilaInt;

public class Exercicio1 {

	public static void main(String[] args) {
		
		FilaInt fila = new FilaInt();
		fila.init();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite um valor inteiro positivo ou negativo para sair: ");
		int valor = teclado.nextInt();
		
		while (valor >= 0) {
			
			fila.enqueue(valor);
			System.out.print("Digite um valor inteiro positivo ou negativo para sair: ");
			valor = teclado.nextInt();
		}
		while (!fila.isEmpty())
			System.out.println("Valor retirado: " + fila.dequeue());
		
		teclado.close();
	}

}
