package br.fiap.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AgenciaDAO;
import br.fiap.dao.BancoDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

/**
 * Servlet implementation class AlteraAgenciaServlet
 */
@WebServlet("/alteraAgencia")
public class AlteraAgenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlteraAgenciaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AgenciaDAO dao = new AgenciaDAO();
		BancoDAO daoBanco = new BancoDAO();
		String codBanco;
		codBanco = request.getParameter("codigoBanco");
		Banco banco = daoBanco.consultar(codBanco);

		String numAgencia, nomeAgencia;
		numAgencia = request.getParameter("numAgencia");

		Agencia agencia = dao.consultar(banco, numAgencia);
		nomeAgencia = request.getParameter("nomeAgencia");
		agencia.setNome(nomeAgencia);

		dao.alterar(agencia);

		response.sendRedirect("formAgencia/formListaAgencia.jsp?codigoBanco=" + banco.getCodBanco());
	}

}
