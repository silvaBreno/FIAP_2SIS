<%@page import="br.fiap.entidades.ContaBancaria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.fiap.dao.ContaBancariaDAO"%>
<%@ page import="br.fiap.entidades.Agencia"%>
<%@ page import="br.fiap.entidades.Banco"%>
<%@ page import="br.fiap.entidades.ContaBancaria"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Conta</title>
	<link rel="stylesheet" type="text/css" href="./css/styleListaConta.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Menu do Gerente</legend>
			<%
				ContaBancariaDAO dao = new ContaBancariaDAO();
				Agencia agencia = (Agencia) request.getAttribute("agencia");
				Banco banco = agencia.getBanco();
			%>
			<div class="bloco_inicial">
				<h4>Lista de Contas Bancárias - <%= banco.getCodBanco() %>/<%= agencia.getNumAgencia() + agencia.getDigito() %></h4>
					<div class="bloco_inicial_interno">	
						<a href="./cadastroConta?codBanco=<%= banco.getCodBanco() %>&numAgencia=<%= agencia.getNumAgencia() %>&tipoConta=CC" style="text-decoration: none">
							<button id="botaoPersonalizado">Cadastrar Conta Corrente</button>
						</a>
						<a href="./cadastroConta?codBanco=<%= banco.getCodBanco() %>&numAgencia=<%= agencia.getNumAgencia() %>&tipoConta=CP" style="text-decoration: none">
							<button id="botaoPersonalizado">Cadastrar Conta Poupança</button>
						</a>
						<a href="./formAgencia/formListaAgencia.jsp?codigoBanco=<%=banco.getCodBanco()%>" style="text-decoration: none">
							<button id="botaoPersonalizado">Voltar</button>
						</a>
					</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>Número da Conta</th>
						<th>Saldo (R$)</th>
						<th>Tipo de Conta</th>
						<th>Sacar</th>
						<th>Depositar</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<ContaBancaria> listaContas = dao.listarContasBancaria(agencia);
					for (ContaBancaria conta : listaContas) {
					%>
					<tr>
						<td><%=conta.getNumeroConta() + conta.getDigitoConta()%></td>
						<td><%=conta.getSaldo()%></td>
						<td><%=conta.getTipo().toString()%></td>
						<td>
							<a href="./sacar?codBanco=<%= banco.getCodBanco() %>&numAgencia=<%= agencia.getNumAgencia() %>&numeroConta=<%= conta.getNumeroConta() %>" style="text-decoration: none">
								<button id="botaoAlterar">Sacar&ensp;<i class="fa-solid fa-circle-dollar-to-slot"></i></button>
							</a>
						</td>
						<td>
							<a href="./depositar?codBanco=<%= banco.getCodBanco() %>&numAgencia=<%= agencia.getNumAgencia() %>&numeroConta=<%= conta.getNumeroConta() %>" style="text-decoration: none">
								<button id="botaoAlterar">Depositar&ensp;<i class="fa-solid fa-hand-holding-dollar"></i></button>
							</a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</fieldset>
	</div>
</body>
</html>