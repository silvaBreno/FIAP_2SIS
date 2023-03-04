
public class Exemplo2 {

	public static void main(String[] args) {
		
		int[] x = {1, 2, 3};
		double[] y = {0.5, 1.75 ,2.99};
		String[] w = {"Patrícia", "Selmini", "Junior"};
		
		imprimirVetorInt(x);
		imprimirVetorDouble(y);
		imprimirVetorString(w);
	}
	
	public static void imprimirVetorInt(int[] x) {
		
		//eu uso esse tipo de for para percorrer o vetor e nao para preencher
		for(int i: x) {
			System.out.println(i);
		}
	}

	public static void imprimirVetorDouble(double[] y) {
			
			for(double d: y) {
				System.out.println(d);
			}
	}
	
	public static void imprimirVetorString (String[] w) {
		
		for(String i: w) {
			System.out.println(i);
		}
	}
	
	
}
