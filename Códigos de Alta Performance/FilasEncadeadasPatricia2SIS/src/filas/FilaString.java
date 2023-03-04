package filas;


public class FilaString {

	private class NO {
		String dado; // supondo fila armazena valor inteiro
		NO prox;
	}
	
	NO ini, fim;
	
	public void init() {
		ini = fim = null;
	}
	
	public boolean isEmpty() {
		if (ini==null && fim ==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enqueue(String elem) {
		NO novo = new NO();
		novo.prox = null;
		novo.dado = elem;
		if (isEmpty()) {
			ini = novo;
		} else {
			fim.prox = novo;
		}
		fim = novo;
		//continua na proxima aula, a prof terminou a aula criando o metodo enqueue
	}
	
	public String dequeue() {
		String v = ini.dado;
		ini = ini.prox;
		if (ini== null) {
			fim = null;
		}
		return v;
	}
}
