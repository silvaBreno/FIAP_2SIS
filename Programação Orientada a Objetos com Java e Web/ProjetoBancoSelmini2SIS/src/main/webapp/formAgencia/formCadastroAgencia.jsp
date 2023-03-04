<%@page import="br.fiap.dao.BancoDAO"%>
<%@page import="br.fiap.entidades.Banco"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastra Agência</title>
	<link rel="stylesheet" type="text/css" href="../css/styleCadastroAgencia.css">
</head>
<body>
	<div class="container">
		<form method="post" action="../cadastroAgencia">
			<fieldset>
			<legend>Menu do Gerente</legend>
				<h4>Cadastro de Agência</h4>
				<%	String codBanco =  request.getParameter("codigoBanco");
					Banco banco = new BancoDAO().consultar(codBanco);
				%>
				<p>
					<label for="codigoBanco">Código do Banco:&ensp;</label>
					<%=banco.getCodBanco()%>
					<input name="codigoBanco" type="hidden" value="<%=banco.getCodBanco()%>" value="readonly"/>
				</p>
				<p>
					<label for="nomeBanco">Nome:&ensp;</label>
					<%=banco.getNome()%>
					<input name="nomeBanco" type="hidden" value="<%=banco.getNome()%>" value="readonly"/>
				</p>
				<p>
					<label for="numAgencia">Número da Agência:&ensp;</label> 
					<input id="numAgencia" name="numAgencia" required="required" type="text" placeholder="número da Agência"/>
				</p>
				<p>
					<label for="digitoAgencia">Dígito da Agência:&ensp;</label> 
					<input id="digitoAgencia" name="digitoAgencia" required="required" type="text" placeholder="dígito da Agência"/>
				</p>
				<p>
					<label for="nomeAgencia">Nome da Agência:&ensp;</label> 
					<input id="nomeAgencia" name="nomeAgencia" required="required" type="text" placeholder="nome da Agência"/>
				</p>
				<div class="botaoCadastrar">			
					<p>
						<input type="submit" value="Cadastrar" id="botaoPersonalizado"/>
					</p>
				</div>	
			</fieldset>
		</form>
	</div>	
</body>
</html>