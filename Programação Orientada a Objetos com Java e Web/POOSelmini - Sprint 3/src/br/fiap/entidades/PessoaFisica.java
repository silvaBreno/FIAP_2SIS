package br.fiap.entidades;

public class PessoaFisica {
	
	private long idPessoaFisica;
	private String cpf;
	private String nomeSocial;
	private String rg;
	private String sexo;
	private String estadoCivil;
	
	public PessoaFisica(long idPessoaFisica, String cpf, String nomeSocial, String rg, String sexo,
			String estadoCivil) {
		super();
		this.idPessoaFisica = idPessoaFisica;
		this.cpf = cpf;
		this.nomeSocial = nomeSocial;
		this.rg = rg;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}

	public long getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getRg() {
		return rg;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setIdPessoaFisica(long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	
}
