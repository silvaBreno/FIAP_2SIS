package br.fiap.produto;

import br.fiap.cliente.Cliente;

public class Financiamento extends Produto {

	private double valorFinanciado;
	private int totalDeParcelas;
	
	public Financiamento(Cliente cliente, double valorFinanciado, int totalDeParcelas) {
		super(cliente);
		this.valorFinanciado = valorFinanciado;
		this.totalDeParcelas = totalDeParcelas;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "Valor Financiado: " + valorFinanciado + "\n";
		aux += "Total de Parcelas: " + totalDeParcelas + "\n";
		return aux;
	}

	public double getValorFinanciado() {
		return valorFinanciado;
	}

	public int getTotalDeParcelas() {
		return totalDeParcelas;
	}

	public void setValorFinanciado(double valorFinanciado) {
		this.valorFinanciado = valorFinanciado;
	}

	public void setTotalDeParcelas(int totalDeParcelas) {
		this.totalDeParcelas = totalDeParcelas;
	}
	
	
}
