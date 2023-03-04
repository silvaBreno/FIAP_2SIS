package br.fiap.main;

import br.fiap.forma.Cilindro;
import br.fiap.forma.Circulo;
import br.fiap.forma.Forma;
import br.fiap.volume.Volume;

public class Main {
	public static void main(String[] args) {
		
		Forma[] forma = new Forma[4];
		
		forma[0] = new Circulo(2, 2, 2);
		forma[1] = new Cilindro(3, 3, 3.5, 4.25);
		forma[2] = new Circulo(4, 4, 4.5);
		forma[3] = new Cilindro(2, 3, 4, 5);
		
		// impress�o dos dados 
		for(Forma f : forma) {
			System.out.println(f); // f.toString();
		}
		
		// impress�o da �rea de cada forma
		System.out.println();
		for (Forma f : forma) {
			System.out.println("�rea = " + f.calcularArea());
		}
		
		// impress�o do volume 
		System.out.println();
		for(Forma f : forma) {
			if(f instanceof Volume) {
				System.out.println("Volume = " + ((Volume)f).calcularVolume());
			}
		}

	}
}
