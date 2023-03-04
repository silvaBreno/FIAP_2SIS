package br.fiap.empregado;

public class EmpregadoHorista extends Empregado{

	private int totalDeHorasTrabalhadas;
	private double valorDaHoraTrabalhada;
	
	public double calcularSalario() {
		return (totalDeHorasTrabalhadas*valorDaHoraTrabalhada);
	}

	public EmpregadoHorista(long matricula, String nome, int totalDeHorasTrabalhadas, double valorDaHoraTrabalha) {
		super(matricula, nome);
		this.totalDeHorasTrabalhadas = totalDeHorasTrabalhadas;
		this.valorDaHoraTrabalhada = valorDaHoraTrabalha;
	}

	@Override
	public String toString() {
		String aux = super.toString();
		aux += "Salário R$: " + calcularSalario();
		return aux;
	}
	
	
}
