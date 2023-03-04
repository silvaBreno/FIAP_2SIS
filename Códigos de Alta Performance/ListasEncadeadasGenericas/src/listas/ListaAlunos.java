package listas;

import exercicio2.Aluno;

public class ListaAlunos {

	private class NO {
		Aluno dado;
		NO prox;
	}

	NO lista = null;

	public void insere(Aluno elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getRm() < lista.dado.getRm()) { // novo nó torna-se o 1o da lista
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while ((aux.prox != null) && (!achou)) {
					if (aux.prox.dado.getRm() < novo.dado.getRm())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}

	}

	public void remove(int rm) {
		if (lista != null) {
			if (lista.dado.getRm() == rm)
				lista = lista.prox;
			else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getRm() == rm)
						achou = true;
					else
						aux = aux.prox;
				}
				if (achou)
					aux.prox = aux.prox.prox;
				else
					System.out.println("Valor não encontrado na lista");
			}
		} else
			System.out.println("Lista vazia");
	}

	public void show() {
		NO aux = lista;
		while (aux != null) {
			System.out.println(aux.dado);
			aux = aux.prox;
		}
		System.out.println();
	}
	
	public int contaNos() {
		int cont=0;
		NO aux = lista;
		while (aux!=null) {
			cont++;
			aux = aux.prox;
		}
		return cont;
	}
	public double consultaMedia(int rm) {
		NO aux = lista;
		double media = -1;
		while(aux!=null && media==-1) {
			if (aux.dado.getRm()==rm)
				media= (aux.dado.getMedia());
			aux = aux.prox;
		}
		return media;
		
	}
	
	public void showMaiores(int limite) {
		NO aux = lista;
		System.out.println("\n**** Valores acima do limite "+ limite);
		while (aux!=null) {
			if (aux.dado.getRm() >= limite)
				System.out.println(aux.dado);
			aux= aux.prox;
		}
	}
}