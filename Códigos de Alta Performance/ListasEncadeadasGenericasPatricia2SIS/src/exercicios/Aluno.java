package exercicios;

public class Aluno {

	int rm;
	double media;
	
	public Aluno(int rm, double media) {
		super();
		this.rm = rm;
		this.media = media;
	}

	@Override
	public String toString() {
		return "Aluno [rm=" + rm + ", media=" + media + "]";
	}

	public int getRm() {
		return rm;
	}

	public double getMedia() {
		return media;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	
	
}
