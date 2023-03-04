package br.fiap.usuario;

public class Usuario {

	private String nome;
	private String cpf;
	private String tarifa;
	

	public Usuario(String nome, String cpf, String tarifa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.tarifa = tarifa;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	
	
}
