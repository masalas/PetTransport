<html>
	<head>
		<title>PetTransport</title>
                <link rel="stylesheet" type="text/css" href="libs/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
                <meta charset="UTF-8"/>
                <script src="libs/js/jquery.js"></script>
                
	</head>
	<body>
		<header>
			<jsp:include page="menu.jsp"/>
		</header>
		<div id="corpo_cadastro">
			<h3>Faça seu Cadastro!</h3>

			<form id="meuForm" method="post">
                            <input id="acao" name="acao" value="add">
                            <div id="selectedit">
                                <h4>Selecione um Motorista.</h4>
                                <select id="motoSelecionado">
                                    <option value="-1">Selecionar...</option> 
                                </select>
                            </div>
				<div class="entrada">
					<p>E-mail:</p>
					<input type="text" id="email" name="email" placeholder="Insira seu e-mail aqui...">
				</div>
				<div class="entrada">
					<p>Nome:</p>
					<input type="text" id="nome" name="nome" placeholder="Insira seu nome aqui...">
				</div>
				<div class="entrada">
					<p>Telefone:</p>
					<input type="text" id="telefone" name="telefone" placeholder="Insira seu telefone aqui...">
				</div>
                                <div class="entrada">
					<p>CEP:</p>
					<input type="text" id="cep" name="cep" placeholder="Insira seu cep aqui...">
				</div>
				<div class="entrada">
					<p>Rua:</p>
					<input type="text" id="rua" name="rua" placeholder="Insira seu endereço aqui...">
				</div>
				<div class="entrada">
					<p>Bairro:</p>
					<input type="text" id="bairro" name="bairro" placeholder="Insira o bairro da sua resedencia...">
				</div>
                                <div class="entrada">
                                    <p>Cidade:</p>
                                    <input type="text" id="cidade" name="cidade" placeholder="Insira sua cidade aqui...">
                                </div>
                                <div class="entrada">
                                    <p>Estado:</p>
                                    <input type="text" id="estado" name="estado" placeholder="Insira seu estado aqui...">
                                </div>
                                <div class="entrada">
					<p>Complemento:</p>
					<input type="text" name="complemento" placeholder="Insira seu complemento aqui...">
				</div>
                           
                            <input type="submit" id="btn_update" name="botao_update" value="Atualizar">
				<input type="submit" id="btn_enviar" name="botao_enviar" value="Enviar" >
				<input type="Reset" name="botao_reset" value="Recarregar">
			</form>
		</div>
                <script type="text/javascript" src="js/cep.js"> </script>
                <script type="text/javascript" src="js/motorista.js"> </script>
        </body>
        
</html>