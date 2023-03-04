package br.fiap.controle;

import static javax.swing.JOptionPane.*;
import java.util.ArrayList;

import br.fiap.cliente.Cliente;
import br.fiap.empregado.Empregado;
import br.fiap.empregado.Gerente;
import br.fiap.empregado.Vendedor;
import br.fiap.pessoa.Pessoa;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;


public class Controle {
		
	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	
	public void menu() {
		int opcao = 0 ;
		
		String aux = "Escolha uma opçao\n";
		aux += "1. Cadastrar Empregado\n";
		aux += "2. Cadastrar Cliente\n";
		aux += "3. Pesquisar\n";
		aux += "4. Listar Empregados\n";
		aux += "5. Listar Clientes\n";
		aux += "6. Remover\n";
		aux += "7. Finalizar";
	
		do {
			try {
				opcao = parseInt(showInputDialog(aux));
				
				if(opcao < 1  ||  opcao > 7) {
					showMessageDialog(null, "Opcao Inválida");
				} else {
					switch(opcao) {
						case 1:
							cadastrarEmpregado();
							break;
						case 2:
							cadastrarCliente();
							break;
						case 3:
							pesquisar();
							break;
						case 4:
							listarEmpregado();
							break;
						case 5:
							listarCliente();
							break;
						case 6:
							remover();
							break;
					}
				}
			}
			catch(NumberFormatException e) {
			};
		}while (opcao != 7);
	}

	private void remover() {
		int indice = pesquisarCpf();
		//criamos a variavel resposta pq a janela tem os botoes que representam numeros, portanto 
		//a variavel vai capturar o numero correspontes a resposta do usurio
		int resposta;
		if(indice != -1) {
			resposta = showConfirmDialog(null, "Deseja excluir? ");
			if(resposta == YES_OPTION) {
				lista.remove(indice);
			}
		}	
		
	}

	private void pesquisar() {
		int indice = pesquisarCpf();
		String tipo;
		if( indice != -1) {
			if(lista.get(indice) instanceof Empregado) {
				tipo = "Empregado\n";
			} else {
				tipo = "Cliente\n";
			}
			
			showMessageDialog(null, tipo + lista.get(indice));
		}		
	
	}
	
	private int pesquisarCpf() {
		int indice = -1;
		String cpf;
		cpf = showInputDialog("CPF para pesquisa");
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCpf().equals(cpf)){
				indice = i;				
			} 
		}
		
		if(indice == -1) {
			showMessageDialog(null, cpf + " nao encontrado");
		}
		
		return indice;
	}

	private void listarCliente() {
		String aux = "";
		
		for (Pessoa p : lista) {
			if(p instanceof Cliente) {
				aux += p + "\n";
			}
		}
		
		showMessageDialog(null, aux + "\n");
		
	}

	private void cadastrarCliente() {
		String nome, cpf;
		double valorDaDivida;
		
		
		nome = showInputDialog("Nome");
		cpf = showInputDialog("CPF");
		
		valorDaDivida = parseDouble(showInputDialog("Valor da Dívida"));
		
		lista.add(new Cliente(nome, cpf, valorDaDivida));
			
		
	}

	private void listarEmpregado() {
		
		String gerente = "";
		String vendedor = "";
		
		for(Pessoa p : lista) {
			if ( p instanceof Gerente) {
				gerente += p + "\n";
			} else if (p instanceof Vendedor) {
				vendedor += p + "\n";
			}
		}
		showMessageDialog(null, vendedor + "\n" + gerente);
	}

	private void cadastrarEmpregado() {
		String nome, cpf, matricula;
		double salario, bonus;
		double totalDasVendas,comissao;
		int opcao = 0;
		String aux = "Escolha o tipo de empregado\n";
		aux += "1. Gerente\n";
		aux += "2. Vendedor\n";
		aux += "3. Retornar\n";
		
		do {
			try {
				opcao = parseInt(showInputDialog(aux));
				
				if(opcao < 1 || opcao > 3) {
					showMessageDialog(null, "Opcao invalida");
				}else {
					if(opcao != 3) {
						nome = showInputDialog("Nome");
						cpf = showInputDialog("CPF");
						matricula = showInputDialog("Matrícula");
						
						if(opcao == 1) {
							salario = parseDouble(showInputDialog("Salário"));
							bonus = parseDouble(showInputDialog("Bônus"));
							
							lista.add(new Gerente(nome, cpf, matricula, salario, bonus));
						} else {
							totalDasVendas = parseDouble(showInputDialog("totalDasVendas"));
							comissao = parseDouble(showInputDialog("Comissão"));
							
							lista.add(new Vendedor(nome, cpf, matricula, totalDasVendas, comissao));
						}
					}
				}
				
			}catch(NumberFormatException e) {
				showMessageDialog(null, "A opcao deve ser um número");
			};
		}while (opcao != 3);
	}

	
}
