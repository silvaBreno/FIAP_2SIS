package br.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

public class AgenciaDAO extends DAO {
	public void inserir(Agencia agencia) {
		try {
			ps = prepareStatement(
					"INSERT INTO AGENCIA (NRO_AGENCIA, COD_BANCO, NOME, DIG_AGENCIA) VALUES (?, ?, ?, ?)");
			ps.setString(1, agencia.getNumAgencia());
			ps.setString(2, agencia.getCodBanco());
			ps.setString(3, agencia.getNome());
			ps.setInt(4, agencia.getDigito());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir ag�ncia: " + e);
		}
	}

	public List<Agencia> listar(Banco banco) {
		List<Agencia> agencias = new ArrayList<Agencia>();
		try {
			ps = prepareStatement("SELECT * FROM AGENCIA WHERE COD_BANCO = ?");
			ps.setString(1, banco.getCodBanco());
			rs = ps.executeQuery();
			while (rs.next()) {
				agencias.add(new Agencia(rs.getString("NRO_AGENCIA"), rs.getInt("DIG_AGENCIA"), rs.getString("NOME"),
						banco));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar as ag�ncias: " + e);
		}
		return agencias;
	}

	public boolean pesquisar(String codBanco, String numAgencia) {
		boolean encontrou = false;
		try {
			ps = prepareStatement("SELECT * FROM AGENCIA WHERE NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, numAgencia);
			ps.setString(2, codBanco);
			rs = ps.executeQuery();
			encontrou = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar ag�ncia por n�mero: " + e);
		}
		return encontrou;
	}

	public Agencia consultar(Banco banco, String numAgencia) {
		Agencia agencia = null;
		try {
			ps = prepareStatement("SELECT * FROM AGENCIA WHERE NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, numAgencia);
			ps.setString(2, banco.getCodBanco());
			rs = ps.executeQuery();
			while (rs.next()) {
				agencia = new Agencia(rs.getString("NRO_AGENCIA"), rs.getInt("DIG_AGENCIA"), rs.getString("NOME"),
						banco);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar ag�ncia por n�mero: " + e);
		}
		return agencia;
	}

	public void alterar(Agencia agencia) {
		try {
			ps = prepareStatement("UPDATE AGENCIA SET NOME = ? WHERE NRO_AGENCIA = ? AND COD_BANCO = ?");
			ps.setString(1, agencia.getNome());
			ps.setString(2, agencia.getNumAgencia());
			ps.setString(3, agencia.getCodBanco());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados da ag�ncia: " + e);
		}
	}
}
