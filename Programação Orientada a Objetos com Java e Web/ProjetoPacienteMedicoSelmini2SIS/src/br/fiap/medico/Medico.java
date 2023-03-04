package br.fiap.medico;

public class Medico {
	
	private String nome;
	private String especialidade;
	private double valorConsulta;
	
	
	
	public Medico(String nome, String especialidade, double valorConsulta) {
		super();
		this.nome = nome;
		this.especialidade = especialidade;
		this.setValorConsulta(valorConsulta);
	}



	public Medico(String nome, String especialidade) {
		super();
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public String getDados() {
		String aux = "";
		aux += "Nome: " + getNome() + "\n";
		aux += "Especialidade: " + getEspecialidade() + "\n";
		
		return aux;
	}



	public double getValorConsulta() {
		return valorConsulta;
	}



	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

}
