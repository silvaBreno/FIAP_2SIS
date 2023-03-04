package br.fiap.form;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import br.fiap.dao.BilheteUnicoDAO;
import br.fiap.modelo.BilheteUnico;

public class FormUsuario {
	public void menuUsuario(String cpf) {
		int opcao = 0;
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuUsuario()));
				switch (opcao) {
					
					case 1:
						carregar(cpf);
						break;
				}
			}
			catch(NumberFormatException e) {
				showMessageDialog(null, "A opcao deve ser entre 1 e 4");
			}
		} while(opcao != 4);
	}
	private void carregar(String cpf) {
		BilheteUnicoDAO dao = new BilheteUnicoDAO();
		BilheteUnico bilhete = dao.pesquisarCpf(cpf);
		double valor = parseDouble(showInputDialog("Valor da recarga: "));
		dao.carregar(cpf, valor+bilhete.getSaldo());
		
	}
	private String gerarMenuUsuario() {
		String menu = "Escolha uma operação:\n";
		menu += "1. Carregar Bilhete\n";
		menu += "2. Passar na Catraca\n";
		menu += "3. Consultar Saldo\n";
		menu += "4. Sair";
		return menu;
	}
}
