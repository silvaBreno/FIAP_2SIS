package exercicio3;

import java.util.Scanner;

import filas.FilaString;

public class ConsultorioNome {

	public static void main(String[] args) {
		
		FilaString fila = new FilaString();
		fila.init();
		
		Scanner teclado = new Scanner(System.in);
		int op;
		do {
			System.out.println("1 - Inserir Paciente na fila");
			System.out.println("2 - Atender Paciente");
			System.out.println("3 - Encerrar atendimento");
			System.out.print("\tOpção: ");
			op = teclado.nextInt();
			
			switch (op) {
			
			case 1:{
				System.out.println("Nome do Paciente: ");
				String nome = teclado.next();
				fila.enqueue(nome);
				break;
			}
			
			case 2:{
				if(!fila.isEmpty())
					System.out.println("Paciente que será atendido agora " + fila.dequeue());
				break;
			}
			
			case 3:{
				if(!fila.isEmpty()) {
					System.out.println("Ainda há paciente na fila");
					op = 0;
				}else {
					System.out.println("O atendimento de hoje foi encerrado");
				}
				break;
			}
			
			default: System.out.println("Opção Inválida");
			}
			
		}while (op !=3);
		
		
		teclado.close();
	}

}
