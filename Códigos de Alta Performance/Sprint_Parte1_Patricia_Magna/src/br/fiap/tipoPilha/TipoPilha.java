package br.fiap.tipoPilha;

public class TipoPilha {

	public final int N = 3;
	String[] dados = new String[N];
	int topo;

	public void init() {
		topo = 0;
	}

	public boolean isEmpty() {
		if (topo == 0) {
			return true;
		} else
			return false;
	}

	public boolean isFull() {
		if (topo == N) {
			return true;
		} else
			return false;
	}

	public void push(String elem) {
		if (!isFull()) {
			dados[topo] = elem;
			topo++;
		} else {
			System.out.println("Stack Overflow");
		}
	}

	public String pop() {
		topo--;
		return (dados[topo]);
	}

	public String top() {
		return (dados[topo - 1]);
	}

}
