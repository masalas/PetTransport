<%-- 
    Document   : gerenciamento
    Created on : 06/05/2018, 21:03:52
    Author     : masalas
--%>

<html>
	<head>
		<title>PetTransport</title>
                <link rel="stylesheet" type="text/css" href="libs/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
                <script src="libs/js/jquery.js"></script>
                <meta charset="UTF-8"/>
	</head>
	<body>
		<header>
			<jsp:include page="menu.jsp"/>
		</header>
		<div id="corpo_gerenciamento">
			<h3>Gerenciamento!</h3>
                        <div class="row">
                            <div class="col">
                                <p>Selecione um Motorista</p>
                                <select id="motoSelecionado">
                                    <option value="-1">Selecionar...</option> 
                                </select>
                                
                            </div>
                        </div>
                        <div  id="motoristaEdit" >
                            <div class="jumbotron jumbotron-fluid">
                                <div class="container">
                                    <h3>Busca de pets</h3>
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <h5>Atribuídos</h5>
                                            <table class="table table-hover">
                                                <thead>
                                                  <tr>
                                                    <th scope="col">#</th>
                                                    <th scope="col">Pet</th>
                                                  </tr>
                                                </thead>
                                                <tbody id="listaAtribuidos">
                                                </tbody>
                                              </table>
                                        </div> 
                                        <div class="col-sm-2">
                                            <div class="row justify-content-md-center">
                                                <button id="btnEsq" type="button" class="btn btn-dark"><<</button>
                                                <button id="btnDir" type="button" class="btn btn-dark">>></button>
                                            </div>
                                        </div>
                                       <div class="col-sm-5">
                                            <h5>Disponíveis</h5>
                                            <table  id="tblAtribuidos" class="table table-hover">
                                                <thead>
                                                  <tr>
                                                    <th scope="col">#</th>
                                                    <th scope="col">Pet</th>
                                                  </tr>
                                                </thead>
                                                <tbody id="listaPets">
                                                </tbody>
                                              </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
		</div>
	</body>
        <script type="text/javascript" src="js/gerenciamento.js"> </script>
</html>