package br.fiap.main;

import java.util.ArrayList;

import br.fiap.cliente.Cliente;
import br.fiap.produto.CartaoDeCredito;
import br.fiap.produto.Financiamento;
import br.fiap.produto.Produto;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		Cliente[] cliente = new Cliente[4];
		
		cliente[0] = new Cliente("Breno Silva","123");
		cliente[1] = new Cliente("Antonio Selmini","456");
		cliente[2] = new Cliente("Miguel Silva","789");
		cliente[3] = new Cliente("Deise Regina","1011");
		
		lista.add(new CartaoDeCredito(cliente[0], 5, 1000));
		lista.add(new CartaoDeCredito(cliente[1], 10, 5000));
		lista.add(new Financiamento(cliente[2], 10000, 5));
		lista.add(new Financiamento(cliente[3], 50000, 10));
		
		dadosCartaoCredito(lista);
		
		dadosFinanciamento(lista);
	}
	
	private static void dadosCartaoCredito(ArrayList<Produto> lista) {
		
		System.out.println("Dados - Cartão de Crédito: \n");
		for (Produto p : lista) {
			if( p instanceof CartaoDeCredito) {
				System.out.println(p.getCliente().toString() + p.toString());
			}
		}
		
	}

	private static void dadosFinanciamento(ArrayList<Produto> lista) {
		
		System.out.println("Dados - Financiamento: \n");
		for (Produto p : lista) {
			if( p instanceof Financiamento) {
				System.out.println(p.getCliente().toString() + p.toString());
			}
		}
	}
}
