package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class MenuPrincipal {
	
	public void menuPrincipal() {
	
		int opcao = 0;
		//formatar to string da conta bancaria, to string do banco
		//validar se o banco/agencia da existe ao cadastrar
		//validar valores de deposito e saldo (se eh negativo ou se ultrapassou o saldo)
		
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuPrincipal()));
				switch (opcao) {
				
				case 1: 
					new MenuBanco().menuBanco();					
					break;
				case 2:
					new MenuAgencia().menuAgencia();
					break;
				case 3:
					new MenuConta().menuConta();
					break;
			}
				
				
			}
			catch(NumberFormatException	e){
				showMessageDialog(null, "A opção deve ser um número entre 1 e 4\n");
			};
		}while(opcao != 4);
	
	}
	
	private String gerarMenuPrincipal() {
		String menu = "Escolha uma operacao:\n";
		menu += "1. Manusear Banco\n";
		menu += "2. Manusear Agencia\n";
		menu += "3. Manusear Conta Corrente\n";
		menu += "4. Sair";
		return menu;
	}
}
