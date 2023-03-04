package tipoPilha;

public class TipoPilhaInt {
	
	public final int N = 6;
	int[] dados = new int[N];
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
	
	public void push(int elem) {
		if( !isFull()) { 
			dados[topo] = elem;
			topo++;
		}else {
			System.out.println("Stack Overflow");
		}
	}
	
	public int pop() {
		topo--;
		return (dados[topo]);
	}
	
	public int top() {	
		return (dados[topo-1]);
	}
	
	public void esvaziaPilha() {
		while (!isEmpty()) {
				System.out.print(" " + pop());
		}
	}
}
