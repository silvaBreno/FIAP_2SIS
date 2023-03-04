package exercicio4;

public class Paciente {
	
	String nome;
	int idade;
	
	public Paciente(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Paciente [nome=" + nome + ", idade=" + idade + "]";
	}
	
	
}
