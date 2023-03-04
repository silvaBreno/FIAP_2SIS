package exemplo2;

public class ExemploLista {

	public static void main(String[] args) {
		
		NoLista lista = new NoLista();
		lista.dado = 1;
		lista.prox = null;
	
		
		NoLista novo = new NoLista();
		novo.dado = 2;
		novo.prox = null;
		
		lista.prox = novo;
		
		
		NoLista novo2 = new NoLista();
		novo2.dado = 3;
		novo2.prox = lista;
		
		NoLista aux = novo2;
		
		while (aux != null) {
			System.out.println("dado: "+ aux.dado);
			System.out.println("\t prox: "+ aux.prox);
			aux = aux.prox;			
		}
	}

}
