
public class TesteOpicionalMultiplos3 {
	
	public static void main(String[] args) {
		
		int multiplos;
		
		for (multiplos = 1; multiplos <= 100; multiplos++) {
			if (multiplos % 3 == 0) {
				System.out.println("O número " + multiplos + " é múltiplo de 3!");
			}
		}
		
	}
}
