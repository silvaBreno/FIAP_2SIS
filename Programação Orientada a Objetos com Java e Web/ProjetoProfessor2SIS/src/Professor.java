
public class Professor {

	//o jeito que o professor resolveu o exercicio
	// atributos 
	
	int numeroDeAulas;
	double valorDaAula;
	
	// método para calcular o salário
	public double calcularSalario() {
		double salario, sb, ha, dsr;
		
		sb = (4.5*numeroDeAulas*valorDaAula);
		ha = sb * 0.05;
		dsr = ((sb + ha)/6);
		salario = sb + ha + dsr;
		
		return salario;
	}
	
	
	 
}
