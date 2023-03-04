<%@page import="br.fiap.dao.BancoDAO"%>
<%@page import="br.fiap.entidades.Banco"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Altera Banco</title>
	<link rel="stylesheet" type="text/css" href="../css/styleAlteraBanco.css">
</head>
<body>
	<div class="container">	
		<form method="post" action="../alteraBanco">
			<fieldset>
				<legend>Menu do Gerente</legend>
				<h4>Alteração de Dados</h4>
				<%	String codBanco =  request.getParameter("codigoBanco");
					Banco banco = new BancoDAO().consultar(codBanco);
				%>
				
				<p>
					<label for="codigoBanco">Código do Banco:&ensp;</label>
					<%= banco.getCodBanco()%>
					<input id="codigoBanco" name="codigoBanco" type="hidden" value="<%=banco.getCodBanco()%>" value="readonly"/>
				</p>
				
				<p>
					<label for="nomeBanco">Nome: </label>
					<input id="nomeBanco" name="nomeBanco" type="text" value="<%=banco.getNome()%>" />
				</p>
				<div class="botaoAlterar">
					<p>
						<input type="submit" value="Alterar" id="botaoPersonalizado"/>
					</p>
				</div>	
			</fieldset>
		</form>
	</div>	
</body>
</html>