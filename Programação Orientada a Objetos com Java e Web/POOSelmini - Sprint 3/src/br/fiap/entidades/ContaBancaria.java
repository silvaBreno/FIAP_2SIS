package br.fiap.entidades;

import java.text.DecimalFormat;
import java.util.Random;

import br.fiap.constantes.TipoContaEnum;
import br.fiap.dao.ContaBancariaDAO;

public class ContaBancaria {
	
	private long idConta;
	private double saldo;
	private String numeroConta;
	private int digitoConta;
	private Banco banco;
	private Agencia agencia;
	private TipoContaEnum tipo;

	public ContaBancaria(long idConta, double saldo, String numeroConta, int digitoConta, Banco banco, Agencia agencia,
			TipoContaEnum tipo) {
		super();
		this.idConta = idConta;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.digitoConta = digitoConta;
		this.banco = banco;
		this.agencia = agencia;
		this.tipo = tipo;
	}

	public ContaBancaria(Agencia agencia, TipoContaEnum tipo) {
		super();
		this.agencia = agencia;
		this.tipo = tipo;
		this.idConta = gerarId();
		this.numeroConta = geraNumeroConta(agencia);
		this.digitoConta = geraDigitoConta();
		this.banco = agencia.getBanco();
		this.saldo = 0;
	}



	private int geraDigitoConta() {
		Random gerador = new Random();
		return gerador.nextInt(10);
	}


	private String geraNumeroConta(Agencia agencia) {
		ContaBancariaDAO contaDAO = new ContaBancariaDAO();
		Random gerador = new Random();
		
		String numeroConta = "";
		DecimalFormat df = new DecimalFormat("00000");
		do {
			numeroConta = df.format(gerador.nextInt(100000)) ;
			
		} while (contaDAO.pesquisaNumeroConta(numeroConta, agencia));
		
		return numeroConta;
	}


	public TipoContaEnum getTipo() {
		return tipo;
	}


	public void setTipo(TipoContaEnum tipo) {
		this.tipo = tipo;
	}


	private int gerarId() {
		
		ContaBancariaDAO daoConta = new ContaBancariaDAO();
		Random gerador = new Random();
		int numero;
		
		do {
			numero = gerador.nextInt(10000, Integer.MAX_VALUE);
		} while(daoConta.pesquisaId(numero));
		
		return numero;
	}

	public long getIdConta() {
		return idConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public int getDigitoConta() {
		return digitoConta;
	}

	public Banco getBanco() {
		return banco;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setIdConta(long idConta) {
		this.idConta = idConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void deposita(double valorDeposito){
		saldo += valorDeposito;
	}
	public void saque(double valorInserido) {
		saldo -= valorInserido;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setDigitoConta(int digitoConta) {
		this.digitoConta = digitoConta;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
}
