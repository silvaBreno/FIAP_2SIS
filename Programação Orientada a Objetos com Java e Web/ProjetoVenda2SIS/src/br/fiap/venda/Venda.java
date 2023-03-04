package br.fiap.venda;

import br.fiap.cargo.Cargo;
import br.fiap.funcionario.Funcionario;

public class Venda {

	private Funcionario funcionario;
	private double valor;
	
	public Venda(Funcionario funcionario, double valor) {
		super();
		this.funcionario = funcionario;
		this.valor = valor;
	}
	
	public double calcularComissao() {
		double comissao = 0;
		Cargo cargo = funcionario.getCargo();	
		
		comissao = cargo.calcularComissao(valor);
		
		return comissao;
	}
}
