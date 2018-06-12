<%-- 
    Document   : login
    Created on : 05/05/2018, 15:04:12
    Author     : masalas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>PetTransport</title>
                <link rel="stylesheet" type="text/css" href="libs/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
	</head>
	<body>
		<header>
                    <h1>Bem Vindo!</h1>
                </header>
            <div id="geral">
                <div id="background">
                        <img src="img/pet.jpg" alt = "Logo" width="450px" height="450px" >
                </div>
            
		<div id="corpo_login">
                    
			<h3>Faça seu Login!</h3>

			<form method="post">
				<div class="entrada">
                                        <p>E-mail:</p>
					<input type="text" name="email" placeholder="Insira seu e-mail aqui...">
				</div>
				<div class="entrada">
					<p>Senha:</p>
					<input type="password" name="senha" placeholder="Insira sua senha aqui...">
                                </div>
                            <a href="" onclick="alert('Em construção...')">Esqueceu sua senha?</a>
				<input type="submit" name="botao_enviar" value="Logar" >
				<input type="Reset" name="botao_reset" value="Recarregar">
			</form>
		</div>
            </div>
	</body>
</html>