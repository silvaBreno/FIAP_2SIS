package br.fiap.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.fiap.formas.Cilindro;
import br.fiap.formas.Circulo;
import br.fiap.formas.FormaGeometrica;


public class Main2 {

	public static void main(String[] args) {
		
		List<FormaGeometrica> lista = new LinkedList<FormaGeometrica>();
		
		lista.add(new Circulo(2,2,2));
		lista.add(new Cilindro(4, 4 , 4, 3));
		lista.add(new Circulo(2,2,2));
		
		//impressao dos dados
		
		FormaGeometrica aux;
		for(int i = 0; i < lista.size(); i++) {
			aux = lista.get(i);
			System.out.println(aux);
			System.out.println();
			
		}
	}

}
