package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.materiaprima.MateriaPrima;

public class MateriaPrimaDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void inserirMateriaPrima(MateriaPrima mp) {
		
		connection = new Conexao().conectar();
		
		String sql = "insert into materia_prima(nome, quantidade) values (?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, mp.getNome());
			ps.setString(2, mp.getQuantidade());		
			ps.execute();

		}catch(SQLException e) {
			System.out.println("Erro ao inserir usuário\n" + e);
		};
	}
}
