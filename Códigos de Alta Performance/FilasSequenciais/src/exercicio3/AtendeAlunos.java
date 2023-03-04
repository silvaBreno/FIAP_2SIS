package exercicio3;

import java.util.Scanner;

import filasSequenciais.FilaSequencialInt;

public class AtendeAlunos {

	public static void main(String[] args) {
		
		FilaSequencialInt filaAtendimento = new FilaSequencialInt();
		filaAtendimento.init();
		
		Scanner le = new Scanner(System.in);
		int op;
		op = le.nextInt();
		
		System.out.println("Digite \n\t1- Inserir aluno \n\t2- Atender Aluno"
				+ "\n\t3- Encerar programa");
		switch(op) {
			case 1: 
				System.out.println("Informe o RM: ");
				int rm = le.nextInt();
				filaAtendimento.enqueue(rm);
				break;
			case 2:
				if(!filaAtendimento.isEmpty()) {
					System.out.println("Äluno chamado para atendimento: " + filaAtendimento.dequeue());
				}else {
					System.out.println("Nao ha aluno para atender agora");
				}
				break;
			
			case 3:
				if(filaAtendimento.isEmpty()) {
				System.out.println("Encerramdo o atendimento de hoje");
				}else {
					op = 0;
					System.out.println("Ainda há aluno para ser atendido");
				} 
				break;
			default:
				System.out.println("Opcao inválida!");
			
		le.close();
		 }
	}
}
