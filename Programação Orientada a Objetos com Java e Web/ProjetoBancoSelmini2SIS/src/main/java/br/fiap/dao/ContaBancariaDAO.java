package br.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.constantes.TipoContaEnum;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.ContaBancaria;

public class ContaBancariaDAO extends DAO {
	public boolean pesquisaId(long id) {
		boolean aux = false;

		try {
			ps = prepareStatement("SELECT * FROM CONTA_BANCARIA WHERE id_conta = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar a conta pelo ID: " + e);
		}

		return aux;
	}

	public void inserirConta(ContaBancaria conta) {
		try {
			ps = prepareStatement(
					"INSERT INTO CONTA_BANCARIA (id_conta, saldo, nro_conta, dig_conta, nro_agencia, cod_banco, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, conta.getIdConta());
			ps.setDouble(2, conta.getSaldo());
			ps.setString(3, conta.getNumeroConta());
			ps.setInt(4, conta.getDigitoConta());
			ps.setString(5, conta.getAgencia().getNumAgencia());
			ps.setString(6, conta.getBanco().getCodBanco());
			ps.setString(7, conta.getTipo().getValor());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir nova conta: " + e);
		}
	}

	public List<ContaBancaria> listarContasBancaria(Agencia agencia) {
		List<ContaBancaria> lista = new ArrayList<ContaBancaria>();

		try {
			ps = prepareStatement("SELECT * FROM CONTA_BANCARIA WHERE NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, agencia.getNumAgencia());
			ps.setString(2, agencia.getCodBanco());
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new ContaBancaria(rs.getLong("id_conta"), rs.getDouble("saldo"), rs.getString("nro_conta"),
						rs.getInt("dig_conta"), agencia, TipoContaEnum.getEnum(rs.getString("tipo"))));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar as contas bancárias: " + e);
		}

		return lista;
	}

	public void alterar(ContaBancaria conta) {
		try {
			ps = prepareStatement("UPDATE CONTA_BANCARIA SET SALDO = ? WHERE id_conta = ?");
			ps.setDouble(1, conta.getSaldo());
			ps.setLong(2, conta.getIdConta());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar saldo da conta: " + e);
		}
	}

	public ContaBancaria consultar(Agencia agencia, String numeroConta) {
		ContaBancaria contaBancaria = null;

		try {
			ps = prepareStatement(
					"SELECT * FROM CONTA_BANCARIA WHERE NRO_CONTA = ? AND NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, numeroConta);
			ps.setString(2, agencia.getNumAgencia());
			ps.setString(3, agencia.getCodBanco());
			rs = ps.executeQuery();
			while (rs.next()) {
				contaBancaria = new ContaBancaria(rs.getLong("id_conta"), rs.getDouble("saldo"),
						rs.getString("nro_conta"), rs.getInt("dig_conta"), agencia,
						TipoContaEnum.getEnum(rs.getString("tipo")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar conta por número: " + e);
		}

		return contaBancaria;
	}

	public boolean pesquisaNumeroConta(String numeroConta, Agencia agencia) {
		boolean aux = false;

		try {
			ps = prepareStatement(
					"SELECT * FROM CONTA_BANCARIA WHERE NRO_CONTA = ? AND NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, numeroConta);
			ps.setString(2, agencia.getNumAgencia());
			ps.setString(3, agencia.getCodBanco());
			rs = ps.executeQuery();
			while (rs.next()) {
				aux = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar conta por número: " + e);
		}

		return aux;
	}
}
