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
import br.fiap.dao.ContaBancariaDAO;
import br.fiap.entidades.Agencia;
import br.fiap.entidades.Banco;
import br.fiap.entidades.ContaBancaria;

@WebServlet("/depositar")
public class DepositarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContaBancaria getConta(String codBanco, String numAgencia, String numeroConta) {
		BancoDAO bancoDao = new BancoDAO();
		Banco banco = bancoDao.consultar(codBanco);
		AgenciaDAO agenciaDao = new AgenciaDAO();
		Agencia agencia = agenciaDao.consultar(banco, numAgencia);
		ContaBancariaDAO dao = new ContaBancariaDAO();
		ContaBancaria conta = dao.consultar(agencia, numeroConta);
		return conta;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codBanco = request.getParameter("codBanco");
		String numAgencia = request.getParameter("numAgencia");
		String numeroConta = request.getParameter("numeroConta");

		ContaBancaria conta = getConta(codBanco, numAgencia, numeroConta);

		request.setAttribute("conta", conta);

		RequestDispatcher dispatcher = request.getRequestDispatcher("formConta/formDepositar.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codBanco = request.getParameter("codBanco");
		String numAgencia = request.getParameter("numAgencia");
		String numeroConta = request.getParameter("numeroConta");
		Double valor = Double.parseDouble(request.getParameter("valor"));

		ContaBancaria conta = getConta(codBanco, numAgencia, numeroConta);

		conta.deposita(valor);

		ContaBancariaDAO dao = new ContaBancariaDAO();
		dao.alterar(conta);

		response.sendRedirect("listaConta?codBanco=" + codBanco + "&numAgencia=" + numAgencia);
	}

}
