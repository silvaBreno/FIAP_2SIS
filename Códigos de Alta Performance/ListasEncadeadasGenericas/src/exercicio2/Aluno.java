package exercicio2;

public class Aluno {
	int rm;
	double media;
	public Aluno(int rm, double media) {
		super();
		this.rm = rm;
		this.media = media;
	}
	public String toString() {
		return "Aluno [rm=" + rm + ", media=" + media + "]";
	}
	public int getRm() {
		return rm;
	}
	public double getMedia() {
		return media;
	}
	
}
