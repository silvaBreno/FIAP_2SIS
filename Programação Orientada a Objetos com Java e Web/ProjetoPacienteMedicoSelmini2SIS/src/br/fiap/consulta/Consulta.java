package br.fiap.consulta;

import br.fiap.data.Data;
import br.fiap.medico.Medico;
import br.fiap.paciente.Paciente;

public class Consulta {
	
	private Data data;
	private Paciente paciente;
	private Medico medico;
	private double valorConsulta;
	
	
	public Consulta(Data data, Paciente paciente, Medico medico) {
		super();
		this.data = data;
		this.paciente = paciente;
		this.medico = medico;
	}
	
	public Data getData() {
		return data;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public String getDados() {
		String aux = "";
		aux += "Data: dia: " + data.getDia() + "mes: " + data.getMes() + "ano: "+ data.getAno() + "\n";
		aux += "Medico: " + medico.getNome() + "\n";
		aux += "Especialidade do Médico: " + medico.getEspecialidade() + "\n";
		
		return aux;
	}
	
	
}