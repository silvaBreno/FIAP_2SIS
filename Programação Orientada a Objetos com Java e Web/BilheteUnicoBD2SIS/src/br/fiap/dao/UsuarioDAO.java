package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.fiap.conexao.Conexao;
import br.fiap.usuario.Usuario;
public class UsuarioDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public boolean pesquisarCpf(String cpf) {
		boolean aux = false;
		//conecta no banco
		connection = new Conexao().conectar();
		//configura a string sql
		sql = "select * from java_usuario where cpf = ?";
		//manda para o banco de dados e recebe a informacao
		try {
			ps = connection.prepareStatement(sql);
			// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			aux = rs.next();	
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o usuário pelo cpf\n" + e);
		}
		return aux;
	}	
	public void inserir(Usuario usuario) {
		//conecta no banco
			connection = new Conexao().conectar();		
		//configura a string sql (os campos nome, cpf e tipo precisam ser iguais aos da base de dados)
			sql = "insert into java_usuario (nome, cpf, tipo) values (?, ?, ?)";			
		//manda para o banco de dados e recebe a informacao		
			try {
				// a variavel ps conhece aonde esta o banco e oq ela precisa levar para o banco
				ps = connection.prepareStatement(sql);
				// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getCpf());
				ps.setString(3, usuario.getTarifa());
				// executo as instrucoes
				ps.execute();
			} catch (SQLException e) {
				System.out.println("Erro ao inserir usuário\n" + e);
		}
	}	
}
