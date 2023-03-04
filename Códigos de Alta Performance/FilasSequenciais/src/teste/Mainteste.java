package teste;

import filasSequenciais.FilaSequencialInt;

public class Mainteste {

	public static void main(String[] args) {
		
		FilaSequencialInt fila = new FilaSequencialInt();
		fila.init();
		
		fila.enqueue(23);
		fila.enqueue(66);
		fila.enqueue(17);
		if (!fila.isEmpty())
		System.out.println("Valor que está no início da fila é: " + fila.first());
		while(!fila.isEmpty())
			System.out.println("Valor retirado da fila: " + fila.dequeue());
		
		fila.enqueue(32);
		System.out.println("Valor que está no início da fila é: " + fila.first());
	}

}
