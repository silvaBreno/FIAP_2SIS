package br.fiap.forma;

import br.fiap.volume.Volume;

public class Cilindro extends Forma implements Volume {
	private double altura;

	public Cilindro(int cx, int cy, double raio, double altura) {
		super(cx, cy, raio);
		this.altura = altura;
	}

	public double calcularArea() {
		return 0;
	}
	
	public double calcularVolume() {
		return 0;
	}
	
	@Override
	public String toString() {
		String aux = super.toString();
		aux += "Altura: " + altura + "\n";
		return aux;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
