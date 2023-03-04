import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// instanciação

		  Scanner teclado = new Scanner(System.in);
		  Bola bola1 = new Bola();
		  Bola bola2 = new Bola();
		  Bola bola3 = new Bola();

		  // entrada de dados

		  System.out.print("Cor da bola 1: ");
		  bola1.cor = teclado.nextLine();
		  System.out.print("Raio da bola 1: ");
		  bola1.raio = teclado.nextDouble();
		  
		  teclado.nextLine();
		  System.out.print("Cor da bola 2: ");
		  bola2.cor = teclado.nextLine();
		  System.out.print("Raio da bola 2: ");
		  bola2.raio = teclado.nextDouble();
		  
		  teclado.nextLine();
		  System.out.print("Cor da bola 3: ");
		  bola3.cor = teclado.nextLine();
		  System.out.print("Raio da bola 3: ");
		  bola3.raio = teclado.nextDouble();

		  Bola bola = maiorBola(bola1, bola2, bola3);

		  System.out.println("A cor da maior bola é: " + bola.cor);
		  
		  teclado.close();
	}
	
	public static Bola maiorBola(Bola b1, Bola b2, Bola b3) {
		
		if(b1.raio > b2.raio && b1.raio > b3.raio) {
			return b1;
		} else if (b2.raio > b3.raio){
			return b2;
		} else{
			return b3;
		}
		
	}

}
