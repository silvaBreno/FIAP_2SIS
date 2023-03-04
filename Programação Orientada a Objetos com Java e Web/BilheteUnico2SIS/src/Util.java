import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
	
	//array para armazenar os objetos do tipo Bilhete
	BilheteUnico[] bilhete = new BilheteUnico[5];
	
	//variável para controlar as posicoes do array;
	int posicao = 0;
	
	//metodo para pesquisar um usuario pelo seu cpf. 
	//o metodo retorna a posicao do array se encontrar o usuario, ou -1 caso contrário
	public int pesquisar(String cpf) {
		int aux = -1;
		
		for(int i = 0; i < posicao ; i++) {
			if(bilhete[i].usuario.cpf.equals(cpf)) {
				aux = i; 
				break;
			} 
		}
		return aux;
	}
	
	//metodo para consultar saldo, o usuario vai inserir o CPF e precisamos mostrar o saldo dele
	public void consultarSaldo() {
		String cpf;
		int indice;
		
		cpf = showInputDialog("CPF");
		indice = pesquisar(cpf);
		
		if(indice == -1) {
			showMessageDialog(null, cpf + "não está cadastrado");
		} else {
			showMessageDialog(null, "Saldo R$" + bilhete[indice].consultarSaldo());
		}
		
	}
	
	//metodo para carregar o bilhete unico
	public void carregarBilhete() {
		String cpf;
		int indice;
		double valor;
		
		cpf = showInputDialog("CPF");
		indice = pesquisar(cpf);
		
		if(indice != -1) {
			valor = parseDouble(showInputDialog("Valor da Recarga"));
			bilhete[indice].carregar(valor);
		} else {
			showMessageDialog(null, cpf + " não está cadastrado!");
		}
	}
	
	//metodo para passar na catraca
	public void passarNaCatraca() {
		String cpf;
		int indice;
		boolean passou;

		cpf = showInputDialog("CPF");
		indice = pesquisar(cpf);
		
		if(indice != -1) {
			passou = bilhete[indice].passarNaCatraca();		
			if (passou == false) {
				showMessageDialog(null, "Saldo Insuficiente");
			}else {
				showMessageDialog(null, cpf + " Não está cadastrado");
			}
		}
		
	}
	
	//metodo para cadastrar um novo bilhete array
 	public void cadastrarBilhete() {
		String nome, tipo, cpf;
		int indice;
		
		if(posicao >= bilhete.length) {
			showMessageDialog(null, "Sistema inoperante");
		} else {
			cpf = showInputDialog("CPF");
			indice = pesquisar(cpf);
			if (indice == -1) {
				nome = showInputDialog("Nome");
				tipo = showInputDialog("Tipo (estudante / professor / normal)");
				 bilhete[posicao]= new BilheteUnico(nome, cpf, tipo);
				 posicao++;
			} else {
				showMessageDialog(null, cpf + "já está cadastrado");
			}
			
		}
	}

	public void menuPrincipal() {
		String aux = "Escolha uma opção\n1. Administrador\n2. Usuário\n3. Finalizar";
		int opcao;
		
		do {
			opcao = parseInt(showInputDialog(aux));
			if (opcao < 1 || opcao > 3) {
				showMessageDialog(null, "Opção Inválida!");
			} else if(opcao == 1){
				menuAdministrador();
			} else if (opcao== 2) {
				menuUsuario();
			}
		}while(opcao !=3);
	}
	
	public void menuAdministrador() {
		String aux = "Escolha uma opção\n1. Cadastrar Bilhete\n2. Consultar Bilhete\n3. Sair";
		int opcao;
		
		do {
			opcao = parseInt(showInputDialog(aux));
			if (opcao < 1 || opcao > 3) {
				showMessageDialog(null, "Opção Inválida!");
			} else if(opcao == 1){
				cadastrarBilhete();
			}
		}while(opcao !=3);
	}
	
	public void menuUsuario() {
		String aux = "Escolha uma opção\n1. Consultar Saldo\n2. Carregar o Bilhete\n"
				+ "3. Passar na Catraca\n4. Sair";
		int opcao;
		
		do {
			opcao = parseInt(showInputDialog(aux));
			if (opcao < 1 || opcao > 4) {
				showMessageDialog(null, "Opção Inválida!");
			} else if (opcao == 1){
				consultarSaldo();
			} else if (opcao == 2) {
				carregarBilhete();
			} else if(opcao == 3) {
				passarNaCatraca();
			}
		}while(opcao != 4);
	}
	
}

	
