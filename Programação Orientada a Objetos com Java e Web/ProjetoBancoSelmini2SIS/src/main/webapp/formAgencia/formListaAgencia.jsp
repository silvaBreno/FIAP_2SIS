<%@page import="br.fiap.dao.BancoDAO"%>
<%@page import="br.fiap.entidades.Banco"%>
<%@page import="br.fiap.entidades.Agencia"%>
<%@page import="java.util.List"%>
<%@page import="br.fiap.dao.AgenciaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Agência</title>
	<link rel="stylesheet" type="text/css" href="../css/styleListaAgencia.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Menu do Gerente</legend>
			<%
			String codBanco = request.getParameter("codigoBanco");
			Banco banco = new BancoDAO().consultar(codBanco);
			%>
			<div class="bloco_inicial">
				<h4>Lista de Agências - <%=banco.getCodBanco()%> <%=banco.getNome()%></h4> 
					<div class="bloco_inicial_interno">	
						<a href="./formCadastroAgencia.jsp?codigoBanco=<%=banco.getCodBanco()%>" style="text-decoration: none">
							<button id="botaoPersonalizado">Cadastrar nova Agência</button>
						</a> 
						<a href="../formBanco/formLista.jsp" style="text-decoration: none">
							<button id="botaoPersonalizado">Voltar</button>
						</a>
					</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>Número da Agência</th>
						<th>Nome da Agência</th>
						<th>Ação</th>
						<th>Contas</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Agencia> listaAgencia = new AgenciaDAO().listar(banco);
					for (Agencia agencia : listaAgencia) {
					%>
					<tr>
						<td><%=agencia.getNumAgencia() + agencia.getDigito()%></td>
						<td><%=agencia.getNome()%></td>
						<td><a href="./formAlteraAgencia.jsp?codigoBanco=<%=banco.getCodBanco()%>&numAgencia=<%= agencia.getNumAgencia()%>">
								<button id="botaoAlterar" type="submit">Alterar&ensp;<i class="fa-solid fa-share"></i></button>
						</a></td>
						<td>
							<a href="../listaConta?codBanco=<%= banco.getCodBanco() %>&numAgencia=<%= agencia.getNumAgencia() %>" style="text-decoration: none">
								<button id="botaoAlterar">Contas&ensp;<i class="fa-regular fa-eye"></i></button>
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