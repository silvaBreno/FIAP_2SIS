import java.util.Random;
import java.util.Scanner;

public class PreencheVetor {

	public static void main(String[] args) {
		
		int N = 10;
		int[] x = new int[N];
		
		
		preencher(x);
		imprimir(x);
		int maior = maiorValor(x);
		
		System.out.println("maior = " + maior);
		
	}
	
	public static void imprimir(int[] x) {
		
		//esse for significa variavel i associada ao vetor x
		//le se para cada valor i que esta dentro do vetor
		for(int i: x ) { 
			System.out.println(i);
		}
	}
	
	public static int maiorValor(int[] x) {
		int aux = x[0];
		
		for(int i = 0;i < x.length ; i++) {
			if(x[i] > aux);
			aux = x[i];
		}
		
		return aux;
	}

    public static void preencher(int[] x) {
		Random gerador = new Random();
		
		for(int i = 0; i < x.length; i++) {
			x[i] = gerador.nextInt(51);
		}
	} 
}
