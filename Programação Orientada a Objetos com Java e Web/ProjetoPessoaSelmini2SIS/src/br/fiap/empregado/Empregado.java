package br.fiap.empregado;

import br.fiap.pessoa.Pessoa;

public class Empregado extends Pessoa{
	
	protected String matricula;

	public Empregado(String nome, String cpf, String matricula) {
		super(nome, cpf);
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		String aux = super.toString();
		aux += "Matr�cula: " + matricula + "\n";
		return aux;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}	
}
