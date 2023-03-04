package br.fiap.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AgenciaDAO;
import br.fiap.dao.BancoDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;

@WebServlet("/listaConta")
public class ListaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codBanco = request.getParameter("codBanco");
		String numAgencia = request.getParameter("numAgencia");

		BancoDAO bancoDao = new BancoDAO();
		Banco banco = bancoDao.consultar(codBanco);
		AgenciaDAO agenciaDao = new AgenciaDAO();
		Agencia agencia = agenciaDao.consultar(banco, numAgencia);

		request.setAttribute("agencia", agencia);

		RequestDispatcher dispatcher = request.getRequestDispatcher("formConta/formLista.jsp");
		dispatcher.forward(request, response);
	}

}
