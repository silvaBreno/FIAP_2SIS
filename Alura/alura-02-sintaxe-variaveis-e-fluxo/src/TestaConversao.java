
public class TestaConversao {

	public static void main(String[] args) {
		
		double salario = 1270.50;
		int valor = (int) salario;
		
		float pontoFlutuante = 3.14f;
		System.out.println(valor);
		
		long numeroGrande = 32432423523L; // n�mero cabe 64 bits
		short valorPequeno = 2131; // n�mero cabe 16 bits
		byte b = 127; // n�mero cabe 8 bits
		
		//int = n�mero cabe 32 bits
		// float 
		
		System.out.println(pontoFlutuante);
		System.out.println(numeroGrande);
		System.out.println(valorPequeno);
		System.out.println(b);
	}
}
