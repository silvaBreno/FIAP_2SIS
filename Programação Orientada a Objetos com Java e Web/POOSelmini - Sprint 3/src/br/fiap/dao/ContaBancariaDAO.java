package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.constantes.TipoContaEnum;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;
import br.fiap.entidades.ContaBancaria;

public class ContaBancariaDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public boolean pesquisaId(int id) {
		
		boolean aux = false;
		//conecta no banco
		connection = new Conexao().conectar();
		
		//configura a string sql
		sql = "select * from CONTA_BANCARIA where id_conta = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			// se eu usei interrogacao na instrucao para o banco preciso configurar o ponto de interrogacao
			ps.setInt(1, id);
			rs = ps.executeQuery();
			aux = rs.next();
			
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar a conta pelo ID\n" + e);
		}
		
		
		return aux;
	}
	
	public void inserirConta(ContaBancaria conta) {
		//conecta no banco
		connection = new Conexao().conectar();
		
		//configura a string sql (os campos nome, cpf e tipo precisam ser iguais aos da base de dados)
		sql = "insert into CONTA_BANCARIA (id_conta, saldo, nro_conta, dig_conta, nro_agencia, cod_banco, tipo) values (?, ?, ?, ?, ?, ?, ?)";	
		
		//manda para o banco de dados e recebe a informacao	
		try {
			//levo com a variavel ps a info para o banco 
			ps = connection.prepareStatement(sql);
			//configuro os pontos de interrogacao
			ps.setLong(1, conta.getIdConta());
			ps.setDouble(2, conta.getSaldo());
			ps.setString(3, conta.getNumeroConta());
			ps.setInt(4, conta.getDigitoConta());
			ps.setString(5, conta.getAgencia().getNumAgencia());
			ps.setString(6, conta.getBanco().getCodBanco());
			ps.setString(7, conta.getTipo().getValor());
			//executo as instrucoes
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Conta Corrente\n" + e);
		}
	}
	
	public List<ContaBancaria> listarContaBancaria(Agencia agencia, Banco banco){
		List<ContaBancaria> lista = new ArrayList<ContaBancaria>();
		
		//conecta no banco
			connection = new Conexao().conectar();
			
		//configura a string sql
		   sql = "select * from CONTA_BANCARIA";
		   
		try {
			ps = connection.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(new ContaBancaria(rs.getLong("id_conta"), rs.getDouble("saldo"), rs.getString("nro_conta"), rs.getInt("dig_conta"), banco, agencia, TipoContaEnum.getEnum(rs.getString("tipo"))));
			}
		}
		catch(SQLException e) {
			System.out.println("Erro ao listar as contas bancárias\n" + e);
		}
		
		return lista;
	}
	
	public void alterar(ContaBancaria conta, double valor) {
		//conecta no banco
		connection = new Conexao().conectar();
		
		//configura a instrucao sql
		sql = "UPDATE CONTA_BANCARIA SET SALDO = ? WHERE id_conta = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, valor);
			ps.setLong(2, conta.getIdConta());
			ps.execute();
		}
		catch(SQLException e) {
			System.out.println("Erro ao alterar saldo da conta: " + e);
		}
	}
	
	public ContaBancaria consultar(Agencia agencia, String numeroConta) {
		ContaBancaria contaBancaria = null;
		//conecta no banco
		connection = new Conexao().conectar();
		
		//configura a string sql
		 sql = "select * from CONTA_BANCARIA WHERE NRO_CONTA = ? AND NRO_AGENCIA = ? AND COD_BANCO = ? ";
		 
		 try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, numeroConta);
			 ps.setString(2, agencia.getNumAgencia());
			 ps.setString(3, agencia.getCodBanco());
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 contaBancaria = new ContaBancaria(rs.getLong("id_conta"), rs.getDouble("saldo"), rs.getString("nro_conta"), rs.getInt("dig_conta"), agencia.getBanco(), agencia, TipoContaEnum.getEnum(rs.getString("tipo")));
			 }
		 }
		 catch(SQLException e) {
			 System.out.println("Erro ao consultar conta por número: " + e);
		 }
		
		return contaBancaria;
	}

	public boolean pesquisaNumeroConta(String numeroConta, Agencia agencia) {
		
		boolean aux = false;
		//conecta no banco
		connection = new Conexao().conectar();
		
		//configura a string sql
		sql = "select * from CONTA_BANCARIA WHERE NRO_CONTA = ? AND NRO_AGENCIA = ? AND COD_BANCO = ? ";
		 
		 try {
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, numeroConta);
			 ps.setString(2, agencia.getNumAgencia());
			 ps.setString(3, agencia.getCodBanco());
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 aux = true;
			 }
		 }
		 catch(SQLException e) {
			 System.out.println("Erro ao consultar conta por número: " + e);
		 }
		
		
		return aux;
	}
}
