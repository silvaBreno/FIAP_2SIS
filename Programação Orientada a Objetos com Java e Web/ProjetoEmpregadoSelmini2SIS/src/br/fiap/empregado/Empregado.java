package br.fiap.empregado;

public abstract class Empregado {
	
	//atributos que serao compartilhados
	protected long matricula;
	protected String nome;
	
	//construtor para inicialiazr os atributos
	public Empregado(long matricula, String nome) {
		//o super é o metodo para a chamada do metodo construtor da super classe
		super();
		this.matricula = matricula;
		this.nome = nome;
	}
	
	//metodo para calcular e retornar o salário
	public abstract double calcularSalario();
	
	
	//o metodo toString retorna uma string com o endereco de memoria, eu quero sobrescrever "substituir" ele pq nao quero que ele me retorne o...
	// ... endereco de memoria e sim os dados. 
	// para sobrescrever o metodo eu digito tostring e aperto cntrl+space e ele vai sugerir o Override ou o sobrescrever
	
	@Override
	public String toString() {
		String aux = "";
		aux += "Matricula: " + matricula + "\n";
		aux += "Nome Empregado: " + nome + "\n";
		aux += "Salário: " + calcularSalario();
		return aux;
	}
	
	public long getMatricula() {
		return matricula;
	}
}
