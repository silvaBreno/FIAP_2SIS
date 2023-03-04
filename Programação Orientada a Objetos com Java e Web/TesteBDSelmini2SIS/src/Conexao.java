import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//nome do driver
	private String driver = "oracle.jdbc.driver.OracleDriver";
	//caminho do banco de dados
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	//login para acesso
	private String login = "rm88332";
	//senha para acesso
	private String senha = "200395";
	//classe para criar a variavel que guarda a conexao com o banco;
	private Connection connection;
	
	public Connection conectar() {
		
		try {
			//utilizado para carregar o driver
			Class.forName(driver);
			//metodo que encontra o driver e estabelece a conexao
			connection = DriverManager.getConnection(url, login, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("erro ao carregar o driver\n" + e);			
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erro ao conectar ao banco de dados\n" + e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return connection;
	}
}
