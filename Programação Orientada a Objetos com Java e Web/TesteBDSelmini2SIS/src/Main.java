
public class Main {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		if (conexao.conectar() != null) {
			System.out.println("conectado");
		} else {
			System.out.println("nao conectado");
		}

		//Aluno aluno = new Aluno(1000, "João Pedro");
		//dao.inserir(aluno);
		
		Aluno aluno2 = new Aluno(2000, "Antonio Marcos Selmini");
		AlunoDAO dao = new AlunoDAO();
		//dao.inserir(aluno2);
		
		//para o caso de eu n ter esse RM na minha base
		//System.out.println(dao.pesquisar(5000));
		
		// para o caso de eu ter esse RM na minha base
		//System.out.println(dao.pesquisar(1000));
		
		System.out.println(dao.listar() );
	}
	
}
