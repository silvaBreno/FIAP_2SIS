package aplicacao;

import java.util.Scanner;

import arvore.ABBint;

public class AplicaABB {

	public static void main(String[] args) {
		ABBint abb = new ABBint();
		Scanner le = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println(" 0 - encerrar");
			System.out.println(" 1 - inserir");
			System.out.println(" 2 - lista em ordem");
			System.out.println(" 3 - conta nós");
			System.out.println(" 4 - pesquisa valor");
			System.out.println(" 6 - remocao valor");
			opcao = le.nextInt();
			
			switch (opcao) {
			
				case 0:
					System.out.println(" Encerrado");
						break;
						
				case 1:
					System.out.println(" Informe o valor a ser inserido:");
					int info = le.nextInt();
					
					abb.raiz = abb.inserir(abb.raiz, info);
						break;
				case 2: 
					System.out.println(" Apresentação em ordem crescente");
					abb.listaEmOrdem(abb.raiz);
						break;
				case 3: 
					System.out.println(" Quantidade de nos da ABB = " + abb.contaNos(abb.raiz, 0));
						break;
				case 4:
					System.out.println(" Informe  valor a ser pesquisado:  ");
					info = le.nextInt();
					
					boolean achou = abb.consulta(abb.raiz, info);
						if(achou) {
							System.out.println("O valor está presente na ABB");
						} else {
							System.out.println("O valor não está presente na ABB");
						}
					break;
				case 6:
					System.out.println("Informe o valor a ser removido: ");
					info = le.nextInt();
					abb.raiz = abb.removeValor(abb.raiz, info);
					break;
				default:
					System.out.println("Opção Inválida");
				
				}
			}while (opcao != 0);
			
			le.close();
		
			}

}
