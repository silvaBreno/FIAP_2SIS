package br.fiap.controle;

import static java.lang.Integer.parseInt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AgenciaDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

/**
 * Servlet implementation class CadastroAgenciaServlet
 */
@WebServlet("/cadastroAgencia")
public class CadastroAgenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroAgenciaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codBanco, name;
		AgenciaDAO dao = new AgenciaDAO();
		String numAgencia, nomeAgencia;
		int digitoAgencia;

		codBanco = request.getParameter("codigoBanco");
		name = request.getParameter("nomeBanco");
		Banco banco = new Banco(codBanco, name);

		// falta validacao do banco

		numAgencia = request.getParameter("numAgencia");
		digitoAgencia = parseInt(request.getParameter("digitoAgencia"));
		nomeAgencia = request.getParameter("nomeAgencia");

		Agencia agencia = new Agencia(numAgencia, digitoAgencia, nomeAgencia, banco);

		agencia.setNumAgencia(numAgencia);
		agencia.setDigito(digitoAgencia);
		agencia.setNome(nomeAgencia);
		agencia.setBanco(banco);

		// falta validacao da agencia
		if (dao.pesquisar(banco.getCodBanco(), numAgencia)) {
			request.setAttribute("Erros", "Agencia Inválido");
		} else {
			dao.inserir(agencia);
		}

		response.sendRedirect("formAgencia/formListaAgencia.jsp?codigoBanco=" + codBanco);

	}

}
