package br.fiap.menu;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

import javax.swing.JOptionPane;

import br.fiap.constantes.TipoContaEnum;
import br.fiap.dao.AgenciaDAO;
import br.fiap.dao.BancoDAO;
import br.fiap.dao.ContaBancariaDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;
import br.fiap.entidades.ContaBancaria;

public class MenuConta {

	private BancoDAO bancoDao;
	private AgenciaDAO dao;
	private ContaBancariaDAO contaDAO;

	public void menuConta() {

		int opcao = 0;
		bancoDao = new BancoDAO();
		dao = new AgenciaDAO();
		contaDAO = new ContaBancariaDAO();
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuAdmin()));

				switch (opcao) {

				case 1:
					cadastraConta();
					break;

				case 2:
					listar();
					break;

				case 3:
					consultar();
					break;

				case 4:
					deposito();
					break;

				case 5:
					saque();
					break;
				}

			} catch (NumberFormatException e) {
				showMessageDialog(null, "A op��o deve ser um n�mero entre 1 e 4\n");
			}
			;

		} while (opcao != 6);

	}

	public String gerarMenuAdmin() {
		String menu = "Escolha uma operacao:\n";
		menu += "1. Inserir Conta\n";
		menu += "2. Listar Conta\n";
		menu += "3. Consultar Conta\n";
		menu += "4. Depositar Saldo na Conta\n";
		menu += "5. Sacar da Conta\n";
		menu += "6. Sair";
		return menu;
	}

	private void cadastraConta() {

		Agencia agencia = buscaValidaAgencia();
		if (agencia != null) {

			TipoContaEnum[] opcao = { TipoContaEnum.CONTA_CORRENTE, TipoContaEnum.CONTA_POUPANCA };
			TipoContaEnum tipo = (TipoContaEnum)showInputDialog(null, "Tipo de Conta","Tipo de Conta", JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);

			contaDAO.inserirConta(new ContaBancaria(agencia, tipo));
		}
	}

	private void listar() {
		Agencia agencia = buscaValidaAgencia();
		if (agencia != null) {
			List<ContaBancaria> lista = contaDAO.listarContaBancaria(agencia, agencia.getBanco());
			String aux = "Conta banc�rias do banco " + agencia.getBanco().getNome() + " Ag " + agencia.getNumAgencia()
					+ ": \n\n";
			for (ContaBancaria contaBancaria : lista) {
				aux += contaBancaria + "\n";
			}
			showMessageDialog(null, aux);
		}
	}

	private void consultar() {
		ContaBancaria conta = buscaValidaConta();

		if (conta != null) {
			showMessageDialog(null, conta);
		}

	}

	private void deposito() {
		ContaBancaria conta = buscaValidaConta();
		if (conta != null) {
			double valorInserido = Double.parseDouble(showInputDialog("Digite o valor do deposito: "));
			conta.deposita(valorInserido);
			contaDAO.alterar(conta, valorInserido);
		}
	}

	private void saque() {
		ContaBancaria conta = buscaValidaConta();
		if (conta != null) {
			double valorInserido = Double.parseDouble(showInputDialog("Digite o valor do saque: "));
			conta.saque(valorInserido);
			contaDAO.alterar(conta, valorInserido);
		}
	}

	private ContaBancaria buscaValidaConta() {
		Agencia agencia = buscaValidaAgencia();
		if (agencia != null) {
			String numeroConta = showInputDialog("Digite o n�mero da conta: ");
			ContaBancaria contaInformada = contaDAO.consultar(agencia, numeroConta);
			if (contaInformada == null) {
				showMessageDialog(null, "A conta informada nao existe");
			}
			return contaInformada;
		}
		return null;
	}

	private Agencia buscaValidaAgencia() {
		Banco banco = buscaValidaBanco();
		if (banco != null) {
			String numAgencia = showInputDialog("Digite o n�mero da ag�ncia: ");
			Agencia agenciaInformada = dao.consultar(banco, numAgencia);
			if (agenciaInformada == null) {
				showMessageDialog(null, "A ag�ncia informada n�o existe");
			}
			return agenciaInformada;
		}
		return null;
	}

	private Banco buscaValidaBanco() {
		String codBanco = showInputDialog("Digite o c�digo do banco: ");
		Banco bancoInformado = bancoDao.consultar(codBanco);
		if (bancoInformado == null) {
			showMessageDialog(null, "O c�digo de banco informado n�o existe");
		}
		return bancoInformado;
	}
}