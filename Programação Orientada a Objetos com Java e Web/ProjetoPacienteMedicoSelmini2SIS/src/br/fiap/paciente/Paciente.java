package br.fiap.paciente;

public class Paciente {
	
	private String cpf;
	private String nome;

	public Paciente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDados() {
		String aux = "";
		aux += "CPF: " + getCpf() + "\n";
		aux += "Nome: " + getNome() + "\n";
		
		return aux;
	}
	
}
