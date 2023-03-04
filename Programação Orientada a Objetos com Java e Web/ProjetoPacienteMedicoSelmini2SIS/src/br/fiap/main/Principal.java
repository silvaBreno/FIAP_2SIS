package br.fiap.main;

import java.util.Iterator;

import br.fiap.consulta.Consulta;
import br.fiap.data.Data;
import br.fiap.medico.Medico;
import br.fiap.paciente.Paciente;

public class Principal {

	public static void main(String[] args) {
		
		// Exercicio 5a
		// ----------------------------------------------------------------------------------------------------------------------------------
		Consulta[] consulta = new Consulta[4];
		
		consulta[0] = new Consulta(new Data(25, 04, 2022), new Paciente("123", "Breno1"), new Medico ("Breno5", "Ortopedista"));
		consulta[1] = new Consulta(new Data(25, 04, 2022), new Paciente("456", "Breno2"), new Medico ("Breno6", "Cardiologista", 900));
		consulta[2] = new Consulta(new Data(25, 04, 2022), new Paciente("789", "Breno3"), new Medico ("Breno7", "Neurologista", 1200));
		consulta[3] = new Consulta(new Data(25, 04, 2022), new Paciente("1011", "Breno4"), new Medico ("Breno8", "Neurologista", 1200));
		
		// Exercicio 5b
		// ----------------------------------------------------------------------------------------------------------------------------------
		imprimirValor(consulta);
		
		
		
		// Exercicio 5c
		// ----------------------------------------------------------------------------------------------------------------------------------
		imprimirTotal(consulta);
		
		for(Consulta c: consulta) {
			System.out.println(c.getDados());
			System.out.println();
		}
		
	}

	private static void imprimirTotal(Consulta[] consulta) {
		// TODO Auto-generated method stub
		
	}

	private static void imprimirValor(Consulta[] consulta) {
		String espec;
		double valor;
		
		for (int i = 0; i < consulta.length; i++) {
			espec = consulta[i].getMedico().getEspecialidade();
			
			if(espec.equalsIgnoreCase("cardiologia") || espec.equalsIgnoreCase("neurologia")) {
				valor = consulta[i].getMedico().getValorConsulta();
			} else {
				valor = 0;
			}
			System.out.println("\tNome do Paciente: " + consulta[i].getPaciente().getNome());
			System.out.println("\tEspecialidade: " + consulta[i].getMedico().getEspecialidade());
			System.out.println("\tValor da Consulta: " + consulta[i].getMedico().getValorConsulta());
		}
		
		
	}
	
	
}
