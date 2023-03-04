
public class TesteOpicionalFatorial {

	public static void main(String[] args) {

		int n;
		int fatorial = 1;

			System.out.println("---------");
			
			for(n = 1; n <= 10; n++) {
				fatorial = fatorial*n;
				
				System.out.println("o fatorial de " + n + "! é " + fatorial);
			}
			
			System.out.println("---------");
		
	}
}
