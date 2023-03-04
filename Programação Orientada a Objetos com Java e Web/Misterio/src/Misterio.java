
public class Misterio {

	int x = 3;
	
	public void metodo1() {
		int x;
		metodo2(++x);
	}
	
	public void metodo2(int y) {
		int x = ++y;
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		
		Misterio misterio = new Misterio();
		misterio.metodo1();
	}
}
