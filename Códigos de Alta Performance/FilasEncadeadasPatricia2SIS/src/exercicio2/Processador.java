package exercicio2;

import java.util.Scanner;

import filas.FilaInt;

public class Processador {

	public static void main(String[] args) {
		FilaInt filaProcessos = new FilaInt();
		filaProcessos.init();
		
		Scanner le = new Scanner(System.in);
		int op;
		
		do {
			System.out.println("1- Submete processo");
			System.out.println("2- Executar processo");
			System.out.println("3- Shutdown");
			op = le.nextInt();
			
			switch(op) {
			
				case 1:
					System.out.println("Informe PID: ");
					int pid = le.nextInt();
					filaProcessos.enqueue(pid);
					break;
				case 2:
					if(!filaProcessos.isEmpty()) {
						pid = filaProcessos.dequeue();
						System.out.println("Processo " + pid + " está sendo executado");
						System.out.println("Processo foi concluido? (1-sim/2-nao)");
						int resp = le.nextInt();
						if (resp == 2) {
							filaProcessos.enqueue(pid);
						}else {
							System.out.println("Processo " + pid + " concluido");
						}
					}
					break;
				case 3:
					if(filaProcessos.isEmpty()) {
						System.out.println("Shutdown...");
					}else {
						System.out.println("Deseja encerrar todos os processos em execucao? (1-sim/2-nao)");
						int resp = le.nextInt();
						if(resp == 1) {
							while(!filaProcessos.isEmpty()) {
								System.out.println("Encerrando processo " + filaProcessos.dequeue());
							}
						}else {
							op = 0;
						}
					}
					break;
				
				default: 
					System.out.println("opcao invalida");
			}
		} while(op!= 3);
		le.close();
	}

	

}
