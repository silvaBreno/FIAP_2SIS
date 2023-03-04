package br.fiap.main;

import java.util.Scanner;

import br.fiap.arvore.ABBcliente;
import br.fiap.cliente.Cliente;
import br.fiap.pilha.TipoPilhaCliente;

public class DivulgaOfertas {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		/*
		 * Cria a uma árvore de busca binária para cada tipo de conta (pessoa física ou
		 * jurídica)
		 */
		ABBcliente pessoaFisica = new ABBcliente();
		ABBcliente pessoaJuridica = new ABBcliente();
		TipoPilhaCliente pilha = new TipoPilhaCliente();
		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		String tipoConta = null;
		double saldo, saldoInformado;

		do {
			System.out.println("\nSelecione uma opção: ");
			System.out.println("-----------------------\n");
			System.out.println("0 - Encerrar o programa");
			System.out.println("1 - Inscrição cliente");
			System.out.println("2 - Oferta de novo serviço e/ou aplicação");

			opcao = le.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite o nome: ");
				nome = le.nextLine();
				System.out.print("Digite o CPF/CNPJ: ");
				cpfCnpj = le.next();
				System.out.print("Digite o Número da Conta: ");
				numeroConta = le.nextInt();

				do {
					System.out.println("\nSelecione uma opção: ");
					System.out.println("-----------------------\n");
					System.out.println("1 - Pessoa Física");
					System.out.println("2 - Pessoa Jurídica");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);

				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();

				if (tipoConta.equalsIgnoreCase("Física")) {

					Cliente cliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);

					pessoaFisica.raiz = pessoaFisica.inserir(pessoaFisica.raiz, cliente);

				} else if (tipoConta.equalsIgnoreCase("Jurídica")) {

					Cliente cliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);

					pessoaJuridica.raiz = pessoaJuridica.inserir(pessoaJuridica.raiz, cliente);
				}

				break;
			case 2:
				System.out.print("\nQual tipo de conta a oferta se destina?  ");
				do {
					System.out.println("\nSelecione uma opção: ");
					System.out.println("-----------------------\n");
					System.out.println("1 - Pessoa Física");
					System.out.println("2 - Pessoa Jurídica");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);

				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				saldoInformado = le.nextDouble();

				/*
				 * Fazendo uso de um método da classe ABB, desenvolvido para este problema, uma
				 * lista de clientes aptos para a oferta é gerada. Nesse trecho de programa que
				 * tentar fazer o contato com todos os clientes presente na lista.
				 */
				// Comentario breno
				// lista clientes aptos a oferta
				pilha.init();
				if (tipoConta.equalsIgnoreCase("Física")) {

					pessoaFisica.getPilhaOfertadosPorSaldo(pessoaFisica.raiz, saldoInformado, pilha);
					ofereceOferta(le, pilha, pessoaFisica);
				} else if (tipoConta.equalsIgnoreCase("Jurídica")) {

					pessoaJuridica.getPilhaOfertadosPorSaldo(pessoaJuridica.raiz, saldoInformado, pilha);
					ofereceOferta(le, pilha, pessoaJuridica);
				}

				break;
			}
		} while (opcao != 0);
		System.out.println("\nClientes que não aceitaram ou não estavam adequados para a oferta:\n");
		/*
		 * Esvazia as ABBs apresentando todos os clientes que aguardam nova oportunidade
		 */
		
		if (pessoaFisica != null) {
			System.out.println("Pessoas Físicas aguardando ofertas:");
			pessoaFisica.listaOrdemDescrente(pessoaFisica.raiz);
		}
		if (pessoaJuridica != null) {
			System.out.println("\n\n--------------------------------------\n");
			System.out.println("\nPessoas Jurídicas aguardando ofertas:");
			pessoaJuridica.listaOrdemDescrente(pessoaJuridica.raiz);
		}
				
		le.close();

	}

	private static void ofereceOferta(Scanner le, TipoPilhaCliente pilha, ABBcliente arvore) {
		int op;
		boolean aceitou = false;

		while (!aceitou && !pilha.isEmpty()) {

			Cliente clienteExtraido = pilha.pop();
			System.out.println("O cliente com o maior saldo é: " + clienteExtraido);
			System.out.println("\nO cliente aceitou a oferta? ");
			System.out.println("\nSelecione uma opção: ");
			System.out.println("-----------------------\n");
			System.out.println("1 - SIM");
			System.out.println("2 - NÃO");
			op = le.nextInt();
			if (op == 1) {
				aceitou = true;
				System.out.println("O cliente " + clienteExtraido.getNome() + " aceitou a oferta");
				// remocao desse cliente da ABB
				arvore.raiz = arvore.removeValor(arvore.raiz, clienteExtraido);
			} else {
				aceitou = false;
				System.out.println("O cliente " + clienteExtraido.getNome() + " não aceitou a oferta");
			}

		}
	}

}
