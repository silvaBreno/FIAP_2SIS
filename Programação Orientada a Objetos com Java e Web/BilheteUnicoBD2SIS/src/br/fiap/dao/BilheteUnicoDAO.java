package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.fiap.conexao.Conexao;
import br.fiap.modelo.BilheteUnico;
public class BilheteUnicoDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	//pesquisar Numero do bilhete
	public boolean pesquisarNumero(int numero) {
		boolean aux = false;
	            //conecta no banco
				connection = new Conexao().conectar();		
				//configura a string sql
				sql = "select * from java_bilhete where numero = ?";		
				//manda para o banco de dados e recebe a informacao
				try {
					ps = connection.prepareStatement(sql);
					// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
					ps.setInt(1, numero);
					rs = ps.executeQuery();
					aux = rs.next();			
				} catch (SQLException e) {
					System.out.println("Erro ao pesquisar o bilhete pelo número\n" + e);
				}
		return aux;
	}
	
	public void inserir(BilheteUnico bilheteUnico) {
		//conecta no banco
			connection = new Conexao().conectar();	
		//configura a string sql (os campos nome, cpf e tipo precisam ser iguais aos da base de dados)
			sql = "insert into java_bilhete (numero, cpf, saldo, valorpassagem) values (?, ?, ?, ?)";		
		//manda para o banco de dados e recebe a informacao		
			try {
				// a variavel ps conhece aonde esta o banco e oq ela precisa levar para o banco
				ps = connection.prepareStatement(sql);
				// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
				ps.setInt(1, bilheteUnico.getNumero());
				ps.setString(2, bilheteUnico.getCpf());
				ps.setDouble(3, bilheteUnico.getSaldo());
				ps.setDouble(4, bilheteUnico.getValorPassagem());
				// executo as instrucoes
				ps.execute();
			} catch (SQLException e) {
				System.out.println("Erro ao inserir bilhete unico\n" + e);
		}		
	}

	public BilheteUnico pesquisarCpf(String cpf) {
		BilheteUnico bilhete = null;		
			//conecta no banco
				connection = new Conexao().conectar();			
			//configura a string sql
			sql = "select * from java_bilhete where cpf = ?";			
			//manda para o banco de dados e recebe a informacao
			try {
				ps = connection.prepareStatement(sql);
				// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
				ps.setString(1, cpf);
				rs = ps.executeQuery();		
				while(rs.next()){
					// para utilizar os get eu tenho duas opcoes, ou eu uso o numero da coluna no banco de dados ou eu uso o nome da coluna
					bilhete = new BilheteUnico(rs.getInt("numero"), cpf, rs.getDouble("saldo"));
				}
			} catch (SQLException e) {
				System.out.println("Erro ao pesquisar o bilhete pelo número\n" + e);
			}
		return bilhete;
	}
	
	public List<BilheteUnico> listarBilheteUnico() {
		List<BilheteUnico> lista = new ArrayList<BilheteUnico>();
		//conecta no banco
				connection = new Conexao().conectar();	
				//configura a string sql
				sql = "select * from java_bilhete";
				//manda para o banco de dados e recebe a informacao
				try {
					ps = connection.prepareStatement(sql);
					// nesse caso nao precisa configurar nenhuma interrogacao porque queremos tudo
					rs = ps.executeQuery();		
					while(rs.next()){
						// 
						lista.add(new BilheteUnico(rs.getInt("numero"), rs.getString("cpf"), rs.getDouble("saldo")));
					}
				} catch (SQLException e) {
					System.out.println("Erro ao pesquisar o bilhete pelo número\n" + e);
				}
		return lista;
	}
	
	public void carregar(String cpf, double valor) {
		//conecta no banco
		connection = new Conexao().conectar();
		//configura a string sql
		sql = "update java_bilhete set saldo = ? where cpf = ?";	
		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, valor);
			ps.setString(2, cpf);
			ps.execute();
		}
		catch(SQLException e) {
			System.out.println("Erro ao carregar o bilhete\n" + e);
		};
	}
}
