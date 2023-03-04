package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {
	public void menuPrincipal() {
		int opcao = 0;
		
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuPrincipal()));
				switch(opcao) {
				
				case 1:
					new MenuMateriaPrima().menuMateriaPrima();
					break;
					
				case 2:
					break;
					
				case 3:
					break;	
				
				default:
					System.out.println("informe uma opcao válida");
				}
			}
			catch (NumberFormatException e) {
			showMessageDialog(null, "A opção deve ser um número entre 1 e 3\n");
			};
		} while(opcao != 3);
	}
	
	
	public String gerarMenuPrincipal() {
		String aux = "";
		aux +="Selecione um opcao: \n";
		aux +="1. Materia Prima: \n";
		aux +="2. Fórmulas: \n";
		aux +="3. Sair ";
		
		return aux;
	}
}
