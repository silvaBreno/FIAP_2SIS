
public class Professor {

	//declaracao das variaveis
	
	double nAulas;
	double valorHoraAula;
	int qtdProfessores;
	double adicional;
	
	//m�todo que calcula o sal�rio base
	
	public double[] salarioBase(int nAulas, double valorHoraAula) {
		
		double[] professor = new double[3];
		
		professor[qtdProfessores] = (4.5*nAulas*valorHoraAula);
		
		return professor;
		
	}
	
	
	//m�todo que calcula o adicional de hora-atividade
	
	public double[] horaAtividade(double professor[], int qtdProfessores) {
		
		double[] adicional = new double[3];
		
		adicional[qtdProfessores] = (professor[qtdProfessores]*0.05);
		
		return adicional;
	}
	
	
	//m�todo que calcula o Descanso Semana Remunerado 
	
	public double[] descansoSemanalRemunerado() {
		
	}
	
	public double[] remuneracaoMensal() {
		
		
	}
}
