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
		System.out.println("Frequência Cardíada Máxima = " + p.calculaFreqCardMax());
		double[] alvo = p.calculaFreqCardAlvo();
		System.out.println("Frequência Cardíaca Alvo Mínima: " + alvo[0]);
		System.out.println("Frequência Cardíaca Alvo Mínima: " + alvo[1]);
		
		teclado.close();
		
	}

}
