package br.fiap.modelo;

import java.util.Random;

import br.fiap.dao.BilheteUnicoDAO;

public class BilheteUnico {

	private int numero;
	private String cpf;
	private double saldo;
	private final double valorPassagem = 4.4;
	
	
	public BilheteUnico(String cpf) {
		super();
		this.numero = gerarNumero();
		this.cpf = cpf;
	}
	
	public BilheteUnico(int numero, String cpf, double saldo) {
		super();
		this.numero = numero;
		this.cpf = cpf;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "BilheteUnico [numero=" + numero + ", cpf=" + cpf + ", saldo=" + saldo + "]";
	}
	
	private int gerarNumero() {
		BilheteUnicoDAO dao = new BilheteUnicoDAO();
		Random gerador = new Random();
		int numero;
		
		do {
			numero = gerador.nextInt(10000, Integer.MAX_VALUE);
		} while(dao.pesquisarNumero(numero));
		
		return numero;
	}


	public int getNumero() {
		return numero;
	}


	public String getCpf() {
		return cpf;
	}


	public double getSaldo() {
		return saldo;
	}


	public double getValorPassagem() {
		return valorPassagem;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
