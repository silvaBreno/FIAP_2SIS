import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Professor p = new Professor();
		
		System.out.print("N�mero de Aulas Semanais: ");
		p.numeroDeAulas = teclado.nextInt();
		System.out.print("Valor da Aula: ");
		p.valorDaAula = teclado.nextDouble();
		
		System.out.println("Sal�rio = R$ " + String.format("%.2f", p.calcularSalario()));
		
		
		teclado.close();
		
	}

}
