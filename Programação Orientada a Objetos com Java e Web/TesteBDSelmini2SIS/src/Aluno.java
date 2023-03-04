
public class Aluno{
	
	private int rm;
	private String nome;
	// classe DAO é responsável por agrupar funcoes para uma determinada classe;
	
	public Aluno(int rm, String nome) {
		super();
		this.rm = rm;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return rm + " - " + nome;
	}

	public int getRm() {
		return rm;
	}

	public String getNome() {
		return nome;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
