package br.fiap.form;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.ArrayList;
import java.util.List;
import br.fiap.dao.BilheteUnicoDAO;
import br.fiap.dao.UsuarioDAO;
import br.fiap.modelo.BilheteUnico;
import br.fiap.usuario.Usuario;

public class FormAdmin {

	public void menuAdmin() {
		int opcao = 0;
		
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuAdmin()));
				switch (opcao) {
				
					case 1: 
						emitirBilhete();
						break;
					case 2:
						imprimir();
						break;
					case 3:
						consultar();
						break;
				}
			}
			catch(NumberFormatException	e) {
				showMessageDialog(null, "A opção deve ser um número entre 1 e 4\n");
			}	
		} while(opcao != 4);
	}

	private void imprimir() {
		BilheteUnicoDAO dao = new BilheteUnicoDAO();
		List<BilheteUnico> lista = dao.listarBilheteUnico();
		String aux = "";
		for(BilheteUnico bilhete : lista) {
			aux += bilhete + "\n";
		}
		showMessageDialog(null, aux);		
	}
	private void consultar() {
		// para ter acesso ao metodo de pesquisarCPF do bilheteUnico eu preciso instancionar um objeto do tipo BilheteUnicoDAO
		BilheteUnicoDAO dao = new BilheteUnicoDAO();
		String cpf = showInputDialog("CPF do usuário");
		BilheteUnico bilhete = dao.pesquisarCpf(cpf);
		if (bilhete == null ) {
			showMessageDialog(null, "CPF nao cadastrado");
		} else {
			showMessageDialog(null, bilhete);
		}	
	}

	private void emitirBilhete() {
		UsuarioDAO dao = new UsuarioDAO();
		BilheteUnicoDAO daoBilhete = new BilheteUnicoDAO();
		String cpf, nome, tipo;
		String[] opcao = {"Estudante", "Professor", "Normal"};
		cpf = showInputDialog("CPF do usuário");
		if (dao.pesquisarCpf(cpf)){
			showMessageDialog(null, "CPF cadastrado");
		} else {
			nome = showInputDialog("Nome do usuário");
			// alinhamento, 
			tipo = (String) showInputDialog(null, "Tipo de Tarifa", "Tipo de Tarifa", 0, null, opcao, opcao[0]);
			dao.inserir(new Usuario(nome, cpf, tipo));
			daoBilhete.inserir(new BilheteUnico(cpf));
		}	
	}
	private String gerarMenuAdmin() {
		String menu = "Escolha uma operacao:\n";
		menu += "1. Emitir Bilhete\n";
		menu += "2. Imprimir Bilhete\n";
		menu += "3. Consultar Bilhete\n";
		menu += "4. Sair";
		return menu;			
	}
}
