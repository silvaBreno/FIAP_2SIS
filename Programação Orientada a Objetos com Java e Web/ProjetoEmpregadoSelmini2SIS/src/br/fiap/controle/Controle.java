package br.fiap.controle;

import br.fiap.empregado.Empregado;
import br.fiap.empregado.EmpregadoComissionado;
import br.fiap.empregado.EmpregadoHorista;

import java.util.Scanner;

public class Controle {

	public static final int HORISTA = 1;
	public static final int COMISSIONADO = 2;
	private Empregado[] lista;
	public int indice;
	Scanner teclado = new Scanner(System.in);

	public Controle(int tamanho) {
		this.lista = new Empregado[tamanho];
		indice = 0;
	}
	

	public void inserir(Empregado empregado) {
		if (indice < lista.length) {
			lista[indice] = empregado;
			indice++;
		}
	}

	public Empregado pesquisar(long matricula) {
		for (int i = 0; i < indice; i++) {
			if (lista[i].getMatricula() == matricula) {
				return lista[i];
			}
		}
		return null;
	}

	public String listar() {
		String horista = "Empregado Horista\n";
		String comissionado = "Empregado Comissionado\n";

		for (int i = 0; i < indice; i++) {
			if (lista[i] instanceof EmpregadoComissionado) {
				comissionado += lista[i] + "\n";
			} else {
				horista += lista[i] + "\n";
			}
		}

		return horista + comissionado;
	}

	public void cadastrar() {

		System.out.println("Informe o tipo de empregado que deseja cadastrar: ");
		System.out.println("\t1- Empregado Horista \n\t2- Empregado Comissionado \n\t3- Finalizar");
		int opcao = teclado.nextInt();

		switch (opcao) {

		case HORISTA: {

			long matricula;
			String nome;
			int horasTrabalhadas;
			double valorHoraTrabalhada;

			System.out.println("\nCadastro de Empregado Horista");
			System.out.println("\n\tInforme o Número da Matrícula: ");
			matricula = teclado.nextLong();

			System.out.println("\n\tInforme o Nome do Empregado: ");
			nome = teclado.nextLine();
			teclado.nextLine();

			System.out.println("\n\tInforme o total de Horas Trabalhadas: ");
			horasTrabalhadas = teclado.nextInt();

			System.out.println("\n\tInforme o valor da hora trabalhada: ");
			valorHoraTrabalhada = teclado.nextInt();

			inserir(new EmpregadoHorista(matricula, nome, horasTrabalhadas, valorHoraTrabalhada));

			System.out.print("\nCadastro de Empregado Horista finalizado");
			System.out.println();
			break;
		}
		
		

		case COMISSIONADO: {
			System.out.println("\nCadastro de Empregado Comissionado");

			System.out.print("\nCadastro de Empregado Comissionado finalizado");
			break;
		}

		default:
			System.out.println("Opcao inválida!");
		
			break;
		
		}
	}
}
