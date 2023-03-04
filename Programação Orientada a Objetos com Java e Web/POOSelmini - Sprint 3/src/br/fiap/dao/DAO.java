package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;

public abstract class DAO {

	protected Connection con;
	protected ResultSet rs;
	protected PreparedStatement ps;

	public DAO() {
		con = new Conexao().conectar();
	}

	protected PreparedStatement prepareStatement(String sql) throws SQLException {
		return con.prepareStatement(sql);
	}

}
