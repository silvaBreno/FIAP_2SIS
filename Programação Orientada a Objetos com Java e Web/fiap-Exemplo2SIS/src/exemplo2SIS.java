import java.util.Random;

public class exemplo2SIS {

	public static void main(String[] args) {
		
		int vet[] = new int[5];
		preencherRandomicamente(vet);
	
		int maior = exibirMaior(vet);
		int menor = exibirMenor(vet);
		
		System.out.println("O maior valor do vetor é " + maior);
		System.out.println("O menor valor do vetor é " + menor);
	}
	
	public static void preencherRandomicamente(int[] vet) {
		
		Random r = new Random();
		
		for(int i=0; i < vet.length; i++) {
			vet[i] = r.nextInt(101);
		}
		
		for(int i=0; i< vet.length;i++) {
			System.out.println("vetor posicao " + (i+1)+ " = " + vet[i]+ ";");
		}
	}
	
	public static int exibirMaior(int[] vet) {
		int aux = vet[0];
		
		for(int i=0; i< vet.length;i++) {
			if (vet[i] > aux) {
				aux = vet[i];
			}
		}
		
		return aux;
	}
	
	public static int exibirMenor(int[] vet) {
		int aux = vet[0];
		
		for(int i=0; i< vet.length;i++) {
			if (vet[i] < aux) {
				aux = vet[i];
			}
		}
		
		return aux;
	}
}
