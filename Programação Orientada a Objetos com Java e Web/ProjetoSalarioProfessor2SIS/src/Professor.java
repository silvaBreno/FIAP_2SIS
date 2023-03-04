
public class Professor {

	//declaracao das variaveis
	
	double nAulas;
	double valorHoraAula;
	int qtdProfessores;
	double adicional;
	
	//método que calcula o salário base
	
	public double[] salarioBase(int nAulas, double valorHoraAula) {
		
		double[] professor = new double[3];
		
		professor[qtdProfessores] = (4.5*nAulas*valorHoraAula);
		
		return professor;
		
	}
	
	
	//método que calcula o adicional de hora-atividade
	
	public double[] horaAtividade(double professor[], int qtdProfessores) {
		
		double[] adicional = new double[3];
		
		adicional[qtdProfessores] = (professor[qtdProfessores]*0.05);
		
		return adicional;
	}
	
	
	//método que calcula o Descanso Semana Remunerado 
	
	public double[] descansoSemanalRemunerado() {
		
	}
	
	public double[] remuneracaoMensal() {
		
		
	}
}
