package br.fiap.main;

import java.util.Scanner;

import br.fiap.arvore.ABBcliente;
import br.fiap.cliente.Cliente;
import br.fiap.pilha.TipoPilhaCliente;

public class DivulgaOfertas {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		/*
		 * Cria a uma �rvore de busca bin�ria para cada tipo de conta (pessoa f�sica ou
		 * jur�dica)
		 */
		ABBcliente pessoaFisica = new ABBcliente();
		ABBcliente pessoaJuridica = new ABBcliente();
		TipoPilhaCliente pilha = new TipoPilhaCliente();
		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		String tipoConta = null;
		double saldo, saldoInformado;

		do {
			System.out.println("\nSelecione uma op��o: ");
			System.out.println("-----------------------\n");
			System.out.println("0 - Encerrar o programa");
			System.out.println("1 - Inscri��o cliente");
			System.out.println("2 - Oferta de novo servi�o e/ou aplica��o");

			opcao = le.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite o nome: ");
				nome = le.nextLine();
				System.out.print("Digite o CPF/CNPJ: ");
				cpfCnpj = le.next();
				System.out.print("Digite o N�mero da Conta: ");
				numeroConta = le.nextInt();

				do {
					System.out.println("\nSelecione uma op��o: ");
					System.out.println("-----------------------\n");
					System.out.println("1 - Pessoa F�sica");
					System.out.println("2 - Pessoa Jur�dica");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "F�sica";
						break;
					case 2:
						tipoConta = "Jur�dica";
						break;
					default:
						System.out.println("Op��o inv�lida ");
						op = -1;
					}
				} while (op == -1);

				System.out.print("Informe saldo em aplica��es R$: ");
				saldo = le.nextDouble();

				if (tipoConta.equalsIgnoreCase("F�sica")) {

					Cliente cliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);

					pessoaFisica.raiz = pessoaFisica.inserir(pessoaFisica.raiz, cliente);

				} else if (tipoConta.equalsIgnoreCase("Jur�dica")) {

					Cliente cliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);

					pessoaJuridica.raiz = pessoaJuridica.inserir(pessoaJuridica.raiz, cliente);
				}

				break;
			case 2:
				System.out.print("\nQual tipo de conta a oferta se destina?  ");
				do {
					System.out.println("\nSelecione uma op��o: ");
					System.out.println("-----------------------\n");
					System.out.println("1 - Pessoa F�sica");
					System.out.println("2 - Pessoa Jur�dica");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "F�sica";
						break;
					case 2:
						tipoConta = "Jur�dica";
						break;
					default:
						System.out.println("Op��o inv�lida ");
						op = -1;
					}
				} while (op == -1);

				System.out.print("Qual o valor de saldo m�nimo exigido: R$ ");
				saldoInformado = le.nextDouble();

				/*
				 * Fazendo uso de um m�todo da classe ABB, desenvolvido para este problema, uma
				 * lista de clientes aptos para a oferta � gerada. Nesse trecho de programa que
				 * tentar fazer o contato com todos os clientes presente na lista.
				 */
				// Comentario breno
				// lista clientes aptos a oferta
				pilha.init();
				if (tipoConta.equalsIgnoreCase("F�sica")) {

					pessoaFisica.getPilhaOfertadosPorSaldo(pessoaFisica.raiz, saldoInformado, pilha);
					ofereceOferta(le, pilha, pessoaFisica);
				} else if (tipoConta.equalsIgnoreCase("Jur�dica")) {

					pessoaJuridica.getPilhaOfertadosPorSaldo(pessoaJuridica.raiz, saldoInformado, pilha);
					ofereceOferta(le, pilha, pessoaJuridica);
				}

				break;
			}
		} while (opcao != 0);
		System.out.println("\nClientes que n�o aceitaram ou n�o estavam adequados para a oferta:\n");
		/*
		 * Esvazia as ABBs apresentando todos os clientes que aguardam nova oportunidade
		 */
		
		if (pessoaFisica != null) {
			System.out.println("Pessoas F�sicas aguardando ofertas:");
			pessoaFisica.listaOrdemDescrente(pessoaFisica.raiz);
		}
		if (pessoaJuridica != null) {
			System.out.println("\n\n--------------------------------------\n");
			System.out.println("\nPessoas Jur�dicas aguardando ofertas:");
			pessoaJuridica.listaOrdemDescrente(pessoaJuridica.raiz);
		}
				
		le.close();

	}

	private static void ofereceOferta(Scanner le, TipoPilhaCliente pilha, ABBcliente arvore) {
		int op;
		boolean aceitou = false;

		while (!aceitou && !pilha.isEmpty()) {

			Cliente clienteExtraido = pilha.pop();
			System.out.println("O cliente com o maior saldo �: " + clienteExtraido);
			System.out.println("\nO cliente aceitou a oferta? ");
			System.out.println("\nSelecione uma op��o: ");
			System.out.println("-----------------------\n");
			System.out.println("1 - SIM");
			System.out.println("2 - N�O");
			op = le.nextInt();
			if (op == 1) {
				aceitou = true;
				System.out.println("O cliente " + clienteExtraido.getNome() + " aceitou a oferta");
				// remocao desse cliente da ABB
				arvore.raiz = arvore.removeValor(arvore.raiz, clienteExtraido);
			} else {
				aceitou = false;
				System.out.println("O cliente " + clienteExtraido.getNome() + " n�o aceitou a oferta");
			}

		}
	}

}
