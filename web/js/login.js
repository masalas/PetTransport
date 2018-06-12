var form = document.getElementById("form_login");
 
if (form.addEventListener) {                   
	form.addEventListener("submit", validaLogin);

} else if (form.attachEvent) {                  

    form.attachEvent("onsubmit", validaLogin);

}
 
function validaLogin(){
	
	var email = document.getElementById('email');
	var senha = document.getElementById('senha');

	 
	alert("Entrou no login");
 

	if(email.value === ""){
		alert("Favor preencher o E-mail");
	}else{
		
		
	}	
 
	if(senha.value === ""){
		alert("Favor preencher a Senha");
		
	}else{
		
	}

 
	if (email.value !== "admin@admin.com" && senha.value !== "admin"){ 
		alert ('Usuario Invalido ou não existe'); 
	} else { 
	 	alert ('É Nois cxarai'); 
	 	window.location.replace("http://localhost:8080/Pizzaria/dashboard.jsp");
	} 
  		
}