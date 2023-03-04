import java.util.Scanner;

public class exemplo2SISProfessor {

	public static void main(String[] args) {
		
		int[] v = new int[5]; // variavel local --> só existe dentro deste metodo
		preencher(v); // argumento v --> variavel que sera enviada para o metodo
		int maior = maiorValor(v);
		int menor = menorValor(v);
		
	
		System.out.println("maior = " + maior);
		System.out.println("menor = " + menor);
	}
    
	//static = significa nao tem orientacao a objeto
	
	public static void preencher(int[] v) { //parametro --> valor que sera recebido
		
		Scanner teclado = new Scanner(System.in);
		
		for(int i = 0; i < v.length; i++) {
			System.out.print("Valor " + (1+i) +": ");
			v[i] = teclado.nextInt();			
		}
		
		teclado.close();
	}
	
	public static int maiorValor(int[] v) {
		int aux = v[0];
		
		for(int i= 0; i < v.length; i++) {
			if(v[i] > aux) {
				aux = v[i];
			}
		}
		
		return aux;
	}
	
	public static int menorValor(int[] v) {
		int aux = v[0];
		
		for(int i= 0; i < v.length; i++) {
			if(v[i] < aux) {
				aux = v[i];
			}
		}
		return aux;
	}
	
}
