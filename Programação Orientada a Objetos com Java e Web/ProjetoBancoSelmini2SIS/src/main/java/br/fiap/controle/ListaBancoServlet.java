package br.fiap.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.BancoDAO;
import br.fiap.entidades.Banco;

/**
 * Servlet implementation class ListaBancoServlet
 */
@WebServlet("/listaBanco")
public class ListaBancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaBancoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BancoDAO dao = new BancoDAO();
		Banco banco;

		String codBanco = request.getParameter("codigoBanco");

		banco = dao.consultar(codBanco);

		if (banco != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/formBanco/formLista.jsp");
			dispatcher.forward(request, response);
		}

	}

}
