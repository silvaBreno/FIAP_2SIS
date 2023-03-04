package exercicio4;

import java.util.Scanner;

import filas.FilaPaciente;

public class ConsultorioPaciente {

	public static void main(String[] args) {
		
		FilaPaciente fila = new FilaPaciente();
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
				System.out.print("Nome do Paciente: ");
				String nome = teclado.next();
				System.out.print("Idade do Paciente: ");
				int idade = teclado.nextInt();
				Paciente pac = new Paciente (nome , idade);
				fila.enqueue(pac);
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
