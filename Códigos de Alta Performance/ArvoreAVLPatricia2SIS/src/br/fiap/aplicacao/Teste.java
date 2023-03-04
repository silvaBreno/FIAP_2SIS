package br.fiap.aplicacao;

import java.util.Scanner;

import br.fiap.arvores.AVLint;

public class Teste {
	public static void main(String[] args) {

		AVLint avl = new AVLint();
		Scanner le = new Scanner(System.in);
		int opcao = 0;

		do {
			System.out.println(" 0 - Sair ");
			System.out.println(" 1 - Inserir ");
			System.out.println(" 2 - Apresentar FB ");
			System.out.println(" 3 - Remove no escolhendo o valor ");
			System.out.println(" 4 - Apresenta altura da AVL ");
			System.out.println(" 5 - Conta a quantidade de nós ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println(" Finalizado ");
				break;
			case 1:
				System.out.println(" Informe o valor a ser inserido: ");
				int info = le.nextInt();
				avl.raiz = avl.inserirH(avl.raiz, info);
				break;
			case 2:
				System.out.println("\n \t Apresentacao do FB");
				avl.mostraFB(avl.raiz);
				break;
			case 3:
				System.out.println(" Informe o valor a ser removido: ");
				info = le.nextInt();
				avl.raiz = avl.removeValor(avl.raiz, info);
				avl.raiz = avl.atualizaAlturaBalanceamento(avl.raiz);
				avl.atualizaAlturas(avl.raiz);
				break;
			case 4:
				System.out.println(" Altura da AVL: " + avl.altura(avl.raiz));
				break;
			case 5:
				break;
			default:
				System.out.println(" Opcao inválida");
			}
		} while (opcao != 0);
		le.close();
	}
}
