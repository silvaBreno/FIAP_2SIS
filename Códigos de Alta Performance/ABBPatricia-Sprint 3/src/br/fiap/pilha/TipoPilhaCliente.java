package br.fiap.pilha;

import br.fiap.cliente.Cliente;

public class TipoPilhaCliente {

	private class No{
		Cliente dado;
		No prox;
	}
	
	No topo;

	public void init() {
		topo = null;
	}

	public void push(Cliente elem) {	
		No novo = new No();
		novo.dado = elem;
		novo.prox = topo;
		topo = novo;
	}

	public Cliente pop() {
		Cliente aux;
		aux = topo.dado;
		topo = topo.prox;
		return (aux);
	}

	public boolean isEmpty() {
		return topo == null;
	} 
}
