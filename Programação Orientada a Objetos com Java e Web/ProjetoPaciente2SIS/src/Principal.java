import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Paciente p = new Paciente();
		Scanner teclado = new Scanner(System.in);
	
		//Entrada de dados
		System.out.print("Informe o nome: ");
		p.nome = teclado.nextLine();
		System.out.print("Informe a idade: ");
		p.idade = teclado.nextInt();
		
		//Saida de dados
		System.out.println("Frequ�ncia Card�ada M�xima = " + p.calculaFreqCardMax());
		double[] alvo = p.calculaFreqCardAlvo();
		System.out.println("Frequ�ncia Card�aca Alvo M�nima: " + alvo[0]);
		System.out.println("Frequ�ncia Card�aca Alvo M�nima: " + alvo[1]);
		
		teclado.close();
		
	}

}
