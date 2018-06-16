/* 
 * Masalas copyright 2018 - 123893'21
 */

window.onload = function(){
    $.get("https://steveown.github.io/pizzariajson/motoristas.json", function( data ) {
        var motorista = JSON.parse(JSON.stringify(data));
        for(i=0; i<motorista.length; i+=1){
            var id=motorista[i]["id"];
            var nome = motorista[i]["nome"];
            
            $("#motoSelecionado").append("<option value='"+id+"'>"+nome+"</option> ");
        }
    });
};

var motoSele = document.getElementById("motoSelecionado");
motoSele.onchange = function(){
    var id = motoSele.value;
    if (id==="-1"){
        document.getElementById("meuForm").reset();
        $("#btn_enviar").show();
        $("#btn_update").hide();
        $("#acao").val("add");
    }
    else{
        $.get("https://steveown.github.io/pizzariajson/motoristas.json", function( data ) {
            var motorista = getMotoristaById(id, JSON.parse(JSON.stringify(data)));
            preencheCampos(motorista);
        });
        $("#btn_enviar").hide();
        $("#btn_update").show();
        $("#acao").val("atualizar");
    }
    
};

function getMotoristaById(id, data){
    for(i=0; i<data.length; i+=1){
        if (id === data[i]["id"]){
            return data[i];
        }
    }
}


function preencheCampos(motorista){
    if (motorista["email"]!=="undefined"){
        document.getElementById("email").value = motorista["email"];
    }
    if (motorista["nome"]!=="undefined"){
        document.getElementById("nome").value = motorista["nome"];
    }
    if (motorista["telefone"]!=="undefined"){
        document.getElementById("telefone").value = motorista["telefone"];
    }
    if (motorista["cep"]!=="undefined"){
        document.getElementById("cep").value = motorista["cep"];
    }
    if (motorista["rua"]!=="undefined"){
         document.getElementById("rua").value = motorista["rua"];
     }
    if (motorista["bairro"]!=="undefined"){
         document.getElementById("bairro").value = motorista["bairro"];
     }
    if (motorista["cidade"]!=="undefined"){
        document.getElementById("cidade").value = motorista["cidade"];
    }
    if (motorista["estado"]!=="undefined"){
        document.getElementById("estado").value = motorista["estado"];
    }
    if (motorista["complemento"]!=="undefined"){
        document.getElementById("complemento").value = motorista["complemento"];
    }
}