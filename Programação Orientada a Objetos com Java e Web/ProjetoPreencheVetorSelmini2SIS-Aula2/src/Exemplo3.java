
public class Exemplo3 {

	public static void main(String[] args) {
		
		imprimir(2, 4);
		imprimir(1, 2, 3);
		imprimir(3, 5, 7, 9, 11);

	}

	public static void imprimir(int ...x) {
		for(int i: x) {
			System.out.println(i);
		}
	}
}
