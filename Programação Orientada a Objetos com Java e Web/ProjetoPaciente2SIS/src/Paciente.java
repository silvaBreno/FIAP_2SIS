
public class Paciente {

	// atributos ou propriedades ou variaveis de instancia (=objeto)
	
	int idade;
	String nome;
	
	
	//método para calcular e retornar o valor da frequencia cardiaca maxima --> esse metodo n tem static!!
	
	public int calculaFreqCardMax() {		
		return 220-idade;
	}
	
	// método para calcular e retornar os valores da frequencia cardiaca alvo
	public double[] calculaFreqCardAlvo() {
		
		double[] alvo = new double [2];
		
		alvo[0] = calculaFreqCardMax()*0.5;
		alvo[1] = calculaFreqCardMax()*0.85;
		
		return alvo;
	}
	
  
}
