import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//agrupar as operacoes de banco de dados para o aluno
public class AlunoDAO {
	
	//variáveis para manipular os dados do banco 
	private Connection connection; //armazena a conexao com o banco de dados
	private PreparedStatement ps; // configura e executa a instrucao sql
	//tudo que volta do banco eh objeto e fica armazenado na variavel ResultSet
	private ResultSet rs; // armazena o resultado do select
	private String sql; //estamos utilizando essa variavel apenas para montar a instrucao sql
	
	//metodo para inserir alunos na base de dados
	public void inserir(Aluno aluno) {
		sql = "insert into aluno_selmini(rm,nome) values(?,?)";
		connection = new Conexao().conectar();
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, aluno.getRm());
			ps.setString(2, aluno.getNome());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco\n" + e);
		}
	}
	
	public boolean pesquisar(int rm) {
		boolean aux = false;
		//selecione todos os dados da tabela aluno onde o campo rm é igual 
		sql = "select * from aluno_selmini where rm = ?";
		connection = new Conexao().conectar();
		
		try {
			//essa variavel sabe aonde ta o banco, sabe qual eh a porta e sabe com a variavel sql qual instrucao levar
			ps = connection.prepareStatement(sql);
			//sempre que tive uma interrogacao na instrucao eh necessario dizer que o ponto precisa ser substituido por alguma informacao, no caso o RM
			ps.setInt(1, rm);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco\n" + e);
		}
		
		return aux;
	}
	
	public List<Aluno> listar(){
		List<Aluno> lista = new ArrayList<Aluno>();	
		sql = "select * from aluno_selmini";
		connection = new Conexao().conectar();
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				lista.add(new Aluno(rs.getInt("rm"), rs.getString("nome")));
			}
		}
		catch(SQLException e) {
			System.out.println("Erro ao lista alunos\n" + e);
		}
		
		return lista;
	}
}
