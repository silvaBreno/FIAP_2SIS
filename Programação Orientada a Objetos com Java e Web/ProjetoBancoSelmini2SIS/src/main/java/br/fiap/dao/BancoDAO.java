package br.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.entidades.Banco;

public class BancoDAO extends DAO {
	public void inserir(Banco banco) {
		try {
			ps = prepareStatement("INSERT INTO BANCO(COD_BANCO, NOME) values(?, ?)");
			ps.setString(1, banco.getCodBanco());
			ps.setString(2, banco.getNome());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no Banco: " + e);
		}
	}

	public boolean pesquisar(String codBanco) {
		boolean aux = false;

		try {
			ps = prepareStatement("SELECT * FROM BANCO where COD_BANCO = ?");
			ps.setString(1, codBanco);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o Banco: " + e);
		}

		return aux;
	}

	public Banco consultar(String codBanco) {
		Banco banco = null;

		try {
			ps = prepareStatement("SELECT * FROM BANCO WHERE COD_BANCO = ?");
			ps.setString(1, codBanco);
			rs = ps.executeQuery();
			while (rs.next()) {
				banco = new Banco(rs.getString("cod_banco"), rs.getString("nome"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar banco: " + e);
		}

		return banco;
	}

	public List<Banco> listar() {
		List<Banco> lista = new ArrayList<Banco>();

		try {
			ps = prepareStatement("SELECT * FROM BANCO");
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Banco(rs.getString("cod_Banco"), rs.getString("nome")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o Banco pelo número: " + e);
		}

		return lista;
	}

	public void alterar(String codBanco, String nome) {
		try {
			ps = prepareStatement("UPDATE BANCO set NOME = ? where COD_BANCO = ?");
			ps.setString(1, nome);
			ps.setString(2, codBanco);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar o banco: " + e);
		}
	}
}
