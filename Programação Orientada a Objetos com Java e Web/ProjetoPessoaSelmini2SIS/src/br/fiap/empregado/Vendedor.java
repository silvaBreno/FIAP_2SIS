package br.fiap.empregado;

import br.fiap.salario.Salario;

public class Vendedor extends Empregado implements Salario {

	private double totalDasVendas;
	private double comissao;

	public Vendedor(String nome, String cpf, String matricula, double totalDasVendas, double comissao) {
		super(nome, cpf, matricula);
		this.totalDasVendas = totalDasVendas;
		this.comissao = comissao;
	}

	@Override
	public double calcularSalario() {
		return totalDasVendas * comissao / 100;
	}	
	
	@Override
	public String toString() {
		String aux = super.toString();
		aux += "Total das vendas R$ " + totalDasVendas + "\n";		
		aux += "Comissao " + comissao + "%\n";	
		return aux;
	}

	public double getTotalDasVendas() {
		return totalDasVendas;
	}


	public double getComissao() {
		return comissao;
	}


	public void setTotalDasVendas(double totalDasVendas) {
		this.totalDasVendas = totalDasVendas;
	}


	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}
