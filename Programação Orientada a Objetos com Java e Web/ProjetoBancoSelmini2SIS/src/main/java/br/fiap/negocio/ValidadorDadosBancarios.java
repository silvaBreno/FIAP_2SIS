package br.fiap.negocio;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import br.fiap.dao.AgenciaDAO;
import br.fiap.dao.BancoDAO;
import br.fiap.dao.ContaBancariaDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;
import br.fiap.entidades.ContaBancaria;

public class ValidadorDadosBancarios {
	private BancoDAO bancoDao;
	private AgenciaDAO agenciaDao;
	private ContaBancariaDAO contaDao;

	public ValidadorDadosBancarios() {
		bancoDao = new BancoDAO();
		agenciaDao = new AgenciaDAO();
		contaDao = new ContaBancariaDAO();
	}

	public ContaBancaria buscaValidaConta() {
		Agencia agencia = buscaValidaAgencia();
		if (agencia == null)
			return null;

		String numeroConta = showInputDialog("Digite o n�mero da conta: ");
		ContaBancaria contaInformada = contaDao.consultar(agencia, numeroConta);
		if (contaInformada == null) {
			showMessageDialog(null, "A conta informada n�o existe");
		}
		return contaInformada;
	}

	public Agencia buscaValidaAgencia() {
		Banco banco = buscaValidaBanco();
		if (banco == null)
			return null;

		String numAgencia = showInputDialog("Digite o n�mero da ag�ncia: ");
		Agencia agenciaInformada = agenciaDao.consultar(banco, numAgencia);
		if (agenciaInformada == null) {
			showMessageDialog(null, "A ag�ncia informada n�o existe");
		}
		return agenciaInformada;
	}

	public Banco buscaValidaBanco() {
		String codBanco = showInputDialog("Digite o c�digo do banco: ");
		Banco bancoInformado = bancoDao.consultar(codBanco);
		if (bancoInformado == null) {
			showMessageDialog(null, "O c�digo de banco informado n�o existe");
		}
		return bancoInformado;
	}
}
