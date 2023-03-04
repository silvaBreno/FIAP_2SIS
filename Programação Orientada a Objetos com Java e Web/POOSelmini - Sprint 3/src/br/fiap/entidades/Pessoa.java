package br.fiap.entidades;

public class Pessoa {
	
	private long idPessoa;
	private String nome;
	private double rendaMensal;
	private double patrimonio;
	private int tipoPessoa;
	private PessoaFisica pessoaFisica;
	
	public Pessoa(long idPessoa, String nome, double rendaMensal, double patrimonio, int tipoPessoa,
			PessoaFisica pessoaFisica) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.rendaMensal = rendaMensal;
		this.patrimonio = patrimonio;
		this.tipoPessoa = tipoPessoa;
		this.pessoaFisica = pessoaFisica;
	}

	public long getIdPessoa() {
		return idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public double getPatrimonio() {
		return patrimonio;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public void setPatrimonio(double patrimonio) {
		this.patrimonio = patrimonio;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
}
