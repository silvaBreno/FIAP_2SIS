package br.fiap.sac;

import java.util.Scanner;

import br.fiap.usuario.Usuario;

public class Sac {

	public static final int SAIR_SISTEMA = 0;
	public static final int ENVIAR_MENSAGEM = 1;
	public static final int LER_RESPONDER = 2;

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);

		System.out.print("Digite nome do cliente: ");
		String nome = le.nextLine();

		System.out.print("Digite id do cliente: ");
		int id = le.nextInt();

		Usuario cliente = new Usuario(id, nome);

		int opcao;
		do {
			System.out.println(" \n 0- para sair do sistema ");
			System.out.println(" 1- para enviar mensagem de feedback");
			System.out.println(" 2- ler e responder mensagem de feedback ");
			System.out.print("Digite op��o: ");
			opcao = le.nextInt();

			switch (opcao) {
			case SAIR_SISTEMA:
				System.out.println("Finalizado o atendimento");
				break;

			case ENVIAR_MENSAGEM:
				System.out.println("Digite mensagem a ser enviada: ");
				le.nextLine();
				String msg = le.nextLine();
				cliente.enviaMsg(msg);
				break;

			case LER_RESPONDER:
				if (cliente.getStatusAtendimento() == Usuario.STATUS_NAO_OK)
					cliente.leMsg();
				break;

			default:
				System.out.println("Op��o inv�lida!");
			}
		} while (opcao != 0);

	}
}
