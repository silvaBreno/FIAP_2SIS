package filas;

import exercicio4.Paciente;

public class FilaPaciente {
	
	private class NO {
		Paciente dado; // supondo fila armazena valor Paciente
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
	
	public void enqueue(Paciente elem) {
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
	
	public Paciente dequeue() {
		Paciente v = ini.dado;
		ini = ini.prox;
		if (ini== null) {
			fim = null;
		}
		return v;
	}
}
