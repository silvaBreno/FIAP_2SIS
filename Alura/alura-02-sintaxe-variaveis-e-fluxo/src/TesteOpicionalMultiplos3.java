
public class TesteOpicionalMultiplos3 {
	
	public static void main(String[] args) {
		
		int multiplos;
		
		for (multiplos = 1; multiplos <= 100; multiplos++) {
			if (multiplos % 3 == 0) {
				System.out.println("O n�mero " + multiplos + " � m�ltiplo de 3!");
			}
		}
		
	}
}
