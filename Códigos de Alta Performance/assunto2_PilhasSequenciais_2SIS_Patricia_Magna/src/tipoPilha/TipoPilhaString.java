package tipoPilha;

public class TipoPilhaString {
	
	public final int N = 6;
	String[] dados = new String[N];
	int topo;
	
	public void init() {
		topo = 0;
	}
	
	public boolean isEmpty() {
		if (topo == 0) {
			return true;
		}else
			return false;
	}
	
	public boolean isFull() {
		if (topo == N) {
			return true;
		}else 
			return false;
	}
	
	public void push(String elem) {
		if( !isFull()) { // if isFull() == false
			dados[topo] = elem;
			topo++;
		}else {
			System.out.println("Stack Overflow");
		}
	}
	
	public String pop() {
		topo--;
		return (dados[topo]);
	}
	
	public String top() {	
		return (dados[topo-1]);
	}
	
	public void esvaziaPilha() {
		while (!isEmpty()) {
				System.out.print(" " + pop()+ "\n");
		}
	}
}
