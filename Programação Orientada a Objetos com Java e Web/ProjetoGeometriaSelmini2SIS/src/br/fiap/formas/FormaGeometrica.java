package br.fiap.formas;

public abstract class FormaGeometrica {

	//atributos que serao compartilhados
	protected int coordenadaX;
	protected int coordenadaY;
	protected double raio;
	
	//metodo construtor de formas geometricas
	public FormaGeometrica(int coordenadaX, int coordenadaY, double raio) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.raio = raio;
	}
	
	public abstract double calcularArea();

	@Override
	public String toString() {
		
		String aux = "";
		aux += "FormaGeometrica:\n";
		aux += "\tCoordenadaX = " + coordenadaX + "\n";
		aux += "\tCoordenadaY = " + coordenadaY + "\n";
		aux += "\tRaio = " + raio + "\n";
		aux += "\t¡rea = " + calcularArea()+ "\n";
		return aux;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public double getRaio() {
		return raio;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	
	
	
}
