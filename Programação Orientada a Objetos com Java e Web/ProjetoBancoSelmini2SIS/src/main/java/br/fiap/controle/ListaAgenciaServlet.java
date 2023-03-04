package br.fiap.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AgenciaDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

/**
 * Servlet implementation class ListaAgenciaServlet
 */
@WebServlet("/listaAgencia")
public class ListaAgenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaAgenciaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AgenciaDAO dao = new AgenciaDAO();
		Agencia agencia;
		String codBanco = request.getParameter("codigoBanco");
		String nomeBanco = request.getParameter("nomeBanco");
		Banco banco = new Banco(codBanco, nomeBanco);
		String numAgencia = request.getParameter("numAgencia");
		agencia = dao.consultar(banco, numAgencia);
		if (agencia != null) {
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/formAgencia/formListaAgencia.jsp");
		dispatcher.forward(request, response);
	}

}
