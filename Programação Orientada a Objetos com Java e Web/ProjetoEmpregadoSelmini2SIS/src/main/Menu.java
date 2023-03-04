package main;
import java.util.Scanner;
import br.fiap.controle.Controle;

public class Menu {

	public static void main(String[] args) {
		
		int qtdFuncionarios = 2;
		Controle p = new Controle(qtdFuncionarios);
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite a opcao desejada: ");
		System.out.println("\n\t1- Cadastro \n\t2- Pesquisa \n\t3- Listagem \n\t4- Finalizar programa");
		int op = teclado.nextInt();
		
		
		do {
			
			switch (op) {
			
			case 1:
				{
					p.cadastrar();
					break;
				}
				
			case 2:
				{
					
					break;
				}
			case 3:
				{
					
					break;
				}
			case 4:
				{
					
					break;
				}
				
			default: 
				{
					System.out.println("Opcao inválida!!!!!!!!!!!!!!!!!");
					break;
				}
				
			}
		} while (p.indice < 2);
		
		teclado.close();
	}

}
