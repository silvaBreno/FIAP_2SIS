<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.fiap.entidades.ContaBancaria"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Saca Saldo</title>
	<link rel="stylesheet" type="text/css" href="./css/styleSacarDepositar.css">
</head>
<body>
	<%
		ContaBancaria conta = (ContaBancaria) request.getAttribute("conta");
		String codBanco = conta.getCodBanco();
		String numAgencia = conta.getNumAgencia();
		String numeroConta = conta.getNumeroConta();
		String erro = (String) request.getAttribute("erro");
	%>
	<div class="container">
		<form action="./sacar" method="post">
			<fieldset>
				<legend>Menu do Gerente</legend>
				<h4>
					Conta Bancária <%=codBanco%>/<%=numAgencia%> N° <%=numeroConta%>
				</h4>
				<p>Saldo Atual: <%=conta.getSaldo()%></p>
				<label>Valor de Saque:&ensp;</label>
				<input name="valor" type="text"/>
				<input name="codBanco" type="hidden" value="<%=codBanco%>"/>
				<input name="numAgencia" type="hidden" value="<%=numAgencia%>"/>
				<input name="numeroConta" type="hidden" value="<%=numeroConta%>"/>
				<div class="botaoCadastrar">
					<p>
					<input type="submit" value="Sacar" id="botaoPersonalizado"/>
					</p>
				</div>
			</fieldset>
		</form>
	</div>	
</body>
</html>