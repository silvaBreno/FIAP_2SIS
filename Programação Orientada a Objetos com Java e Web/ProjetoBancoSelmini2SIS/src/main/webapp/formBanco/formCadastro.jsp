<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro Banco</title>
	<link rel="stylesheet" type="text/css" href="../css/styleCadastraBanco.css">
</head>
<body>
	<div class="container">
		<form method="post" action="../cadastroBanco">
			<fieldset>
				<legend>Menu do Gerente</legend>
				<h4>Cadastro</h4>

				<p>
					<label for="codigoBanco">Código do banco: </label> <input
						id="codigoBanco" name="codigoBanco" required="required"
						type="text" placeholder="código do Banco" />
				</p>

				<p>
					<label for="nomeBanco">Nome do banco: </label> <input
						id="nomeBanco" name="nomeBanco" required="required" type="text"
						placeholder="nome do Banco" />
				</p>

				<div class="botaoCadastrar">
					<p>
						<input type="submit" value="Cadastrar" id="botaoPersonalizado" />
					</p>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>