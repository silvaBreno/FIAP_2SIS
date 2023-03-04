package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import br.fiap.dao.MateriaPrimaDAO;
import br.fiap.materiaprima.MateriaPrima;

public class MenuMateriaPrima {
	
	public void menuMateriaPrima() {
		int opcao = 0;


		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuAdmin()));
				switch (opcao) {
				case 1:
					inserirMateriaPrima();
					break;
				case 2:
					
					break;
				case 3:
				
					break;
				case 4:
					
					break;
				case 5:
					break;
				default:
					showMessageDialog(null, "Opção inválida");
				}
			} catch (NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número entre 1 e 4\n");
			}
		} while (opcao != 5);
	}
	
	private void inserirMateriaPrima() {
		String nome;
		String quantidade;
		
		nome = showInputDialog("Nome da Matéria Prima: ");
		quantidade = showInputDialog("Informe a quantidade de matéria prima: ");
		
		MateriaPrima mp = new MateriaPrima(nome, quantidade);
		
		MateriaPrimaDAO dao = new MateriaPrimaDAO();
		dao.inserirMateriaPrima(mp);	
		
	}

	public String gerarMenuAdmin() {
		String menu = "Escolha uma operacao:\n";
		menu += "1. Inserir Materia Prima\n";
		menu += "2. Consultar Materia Prima\n";
		menu += "3. Listar Materias Primas\n";
		menu += "4. Alterar Materias Primas\n";
		menu += "5. Sair";
		return menu;
	}
}
