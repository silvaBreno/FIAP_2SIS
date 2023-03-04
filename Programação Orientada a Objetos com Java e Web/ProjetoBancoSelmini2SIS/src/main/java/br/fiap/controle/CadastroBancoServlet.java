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
 * Servlet implementation class CadastroBancoServlet
 */
@WebServlet("/cadastroBanco")
public class CadastroBancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroBancoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// para cadastrar um banco eu preciso do codigo do Banco e do nome do banco

		BancoDAO dao = new BancoDAO();
		String codBanco, name;

		codBanco = request.getParameter("codigoBanco");
		name = request.getParameter("nomeBanco");

		Banco banco = new Banco(codBanco, name);
		banco.setCodBanco(codBanco);
		banco.setNome(name);

		if (dao.pesquisar(banco.getCodBanco())) {
			request.setAttribute("Erros", "Banco Inválido");
		} else {
			dao.inserir(banco);
		}

		// mando para pagina de volta do index
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
