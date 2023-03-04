package br.fiap.main;

import br.fiap.cargo.Cargo;
import br.fiap.funcionario.Funcionario;
import br.fiap.venda.Venda;

public class Main {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario("X", 1000, Cargo.GERENTE  );
		Venda venda = new Venda(funcionario, 1000);
		
		System.out.println(venda.calcularComissao());

	}

}
