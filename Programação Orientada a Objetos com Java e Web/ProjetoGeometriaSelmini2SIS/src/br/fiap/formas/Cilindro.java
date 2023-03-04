package br.fiap.formas;

import br.fiap.volume.Volume;

public class Cilindro extends FormaGeometrica implements Volume{
	
	//atributo especifico do objeto
	protected double altura;

	public Cilindro(int coordenadaX, int coordenadaY, double raio, double altura) {
		super(coordenadaX, coordenadaY, raio);
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public double calcularVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String aux = super.toString();
		aux += "\tAltura = " + altura + "\n";
		aux += "\tVolume = " + calcularVolume() + "\n";
		return aux;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
}
