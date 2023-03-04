
public class Main {

	public static void main(String[] args) {
		
		Produto[] p = new Produto[3];
		
		System.out.println(p);
		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(p[2]);
		
		p[0] = new Produto("arroz", 25.50);
		p[1] = new Produto("feijão", 5.50);
		p[2] = new Produto("açúcar", 3.85);
		
		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(p[2]);
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].nome + " " + p[i].valor);
		}
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].valor);
		}
		
	}

}
