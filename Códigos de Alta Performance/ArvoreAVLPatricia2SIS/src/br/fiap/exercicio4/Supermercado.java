package br.fiap.exercicio4;

import java.util.Scanner;

import br.fiap.arvores.AVLProdutos;

public class Supermercado {

	public static void main(String[] args) {
		AVLProdutos tree = new AVLProdutos();
		Scanner le = new Scanner(System.in);
		int opcao = 0;

		do {
			System.out.println(" 0 - Sair ");
			System.out.println(" 1 - Inserir produto");
			System.out.println(" 2 - Apresentar produtos com preco menor que um valor ");
			System.out.println(" 3 - Remove escolhendo o codigo ");
			System.out.println(" 4 - Consulta produto pelo codigo ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println(" Finalizado o programa ");
				break;
			case 1:
				System.out.println(" Informe o codigo do produto: ");
				int cod = le.nextInt();
				System.out.println(" Descricao: ");
				String desc = le.next();
				System.out.println(" Preco: ");
				double preco = le.nextDouble();
				Produto pro = new Produto(cod, desc, preco);
				tree.raiz = tree.inserirAVL(tree.raiz, prod);
				tree.atualizaAlturas(tree.raiz);
				break;
			default:
				System.out.println(" ");
			}
		} while (opcao != 0);
		le.close();
	}
}
