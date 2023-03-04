import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Professor p = new Professor();
		
		System.out.print("Número de Aulas Semanais: ");
		p.numeroDeAulas = teclado.nextInt();
		System.out.print("Valor da Aula: ");
		p.valorDaAula = teclado.nextDouble();
		
		System.out.println("Salário = R$ " + String.format("%.2f", p.calcularSalario()));
		
		
		teclado.close();
		
	}

}
