package br.fiap.cliente;

public class Cliente {
	
	private String nome;	
	private String cpfCnpj;
	private int numeroConta;
	private String tipoConta;
	private double saldo;
	
	public Cliente(String nome, String cpfCnpj, int numeroConta, String tipoConta, double saldo) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "\n\nDados do Cliente:  \n\tNome = " + nome + "\n\tCPF/CNPJ = " + cpfCnpj + "\n\tNumero da Conta = " + numeroConta + "\n\tTipo da Conta = "
				+ tipoConta + "\n\tSaldo = " + saldo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
}
