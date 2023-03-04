<%@page import="br.fiap.dao.BancoDAO"%>
<%@page import="br.fiap.entidades.Banco"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lista Banco</title>
	<link rel="stylesheet" type="text/css" href="../css/styleListaBanco.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Menu do Gerente</legend>
			<div class="bloco_inicial">
				<h4>Lista de Bancos</h4>
				<div class="bloco_inicial_interno">
				
					<a href="./formCadastro.jsp" style="text-decoration: none">
						<button id="botaoPersonalizado">Cadastrar novo Banco</button>	
					</a>	
					<a href="../index.jsp" style="text-decoration: none">
						<button id="botaoPersonalizado">Voltar</button>
					</a>
				</div>
			</div>
			
			<table>
				<thead>
					<tr>
						<th>Código do Banco</th>
						<th>Nome do Banco</th>
						<th>Ação</th>
						<th>Agências</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Banco> lista = new BancoDAO().listar();
					for (Banco banco : lista) {
					%>
					<tr>
						<td><%=banco.getCodBanco()%></td>
						<td><%=banco.getNome()%></td>
						<td><a href="./formAltera.jsp?codigoBanco=<%=banco.getCodBanco()%>">
								<button id="botaoAlterar" type="submit"> Alterar&ensp;<i class="fa-solid fa-share"></i></button>
						</a></td>
						<td><a href="../formAgencia/formListaAgencia.jsp?codigoBanco=<%=banco.getCodBanco()%>">
							<button id="botaoAlterar" type="submit">Agências&ensp;<i class="fa-regular fa-eye"></i></button>
						</a></td>
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