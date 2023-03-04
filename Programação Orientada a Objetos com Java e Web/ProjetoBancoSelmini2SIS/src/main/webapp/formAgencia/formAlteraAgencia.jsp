<%@page import="br.fiap.dao.AgenciaDAO"%>
<%@page import="br.fiap.dao.BancoDAO"%>
<%@page import="br.fiap.entidades.Banco"%>
<%@page import="br.fiap.entidades.Agencia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Altera Ag�ncia</title>
	<link rel="stylesheet" type="text/css" href="../css/styleAlteraAgencia.css">
</head>
<body>
	<div class="container">	
		<form method="post" action="../alteraAgencia">
			<fieldset>
				<legend>Menu do Gerente</legend>
				<%
				String codBanco = request.getParameter("codigoBanco");
				String numAgencia = request.getParameter("numAgencia");
				Banco banco = new BancoDAO().consultar(codBanco);
				Agencia agencia = new AgenciaDAO().consultar(banco, numAgencia);
				%>
				<h4>Altera��o de Ag�ncia - <%=banco.getCodBanco()%> <%=banco.getNome()%></h4>
				
				<input name="codigoBanco" type="hidden" value="<%=banco.getCodBanco()%>" value="readonly"/>
	
				<p>
					<label for="numAgencia">N�mero da Ag�ncia:&ensp;</label> 
					<%= agencia.getNumAgencia()%>
					<input id="numAgencia" name="numAgencia" type="hidden" value="<%= agencia.getNumAgencia()%>" placeholder="n�mero da Ag�ncia" value="readonly"/>
				</p>
				<p>
					<label for="digitoAgencia">D�gito da Ag�ncia:&ensp;</label>
					<%= agencia.getDigito()%>
				<p>
					<label for="nomeAgencia">Nome da Ag�ncia:&ensp;</label> 
					<input id="nomeAgencia" name="nomeAgencia" required="required" type="text" placeholder="nome da Ag�ncia"/>
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