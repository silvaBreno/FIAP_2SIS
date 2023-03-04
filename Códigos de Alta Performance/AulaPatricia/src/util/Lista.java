package util;

public class Lista {

	private class NO{
		int dado;
		NO prox;
	}
	
	NO lista = null;
	
	public void insere(int valor) {
		System.out.println("lista = " + lista);
		NO novo = new NO();
		System.out.println("novo = " + novo  );
		novo.dado = valor;
		novo.prox = lista;
		lista = novo;
		
	}


}
