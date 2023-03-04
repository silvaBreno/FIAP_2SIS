package br.fiap.data;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getDados() {
		String aux = "";
		aux += "Data: " + getDia()+"/"+ getMes()+"/"+ getAno() + "\n";

		
		return aux;
	}
	
	
}
