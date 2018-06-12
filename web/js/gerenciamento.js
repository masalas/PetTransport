/* 
* Masalas copyright 2018 - 123893'21
 */
var paraEsquerda=null;
var paraDireita=null;

window.onload = function(){
    $.get("https://steveown.github.io/pizzariajson/motoristas.json", function( data ) {
        var motorista = JSON.parse(JSON.stringify(data));
        for(i=0; i<motorista.length; i+=1){
            var id=motorista[i]["id"];
            var nome = motorista[i]["nome"];
            
            $("#motoSelecionado").append("<option value='"+id+"'>"+nome+"</option> ");
        }
    });
    
    $('#listaPets').on('click', '.clickable-row', function(event) {
        $(this).addClass('ativo').siblings().removeClass('ativo');    
        paraEsquerda = $(this);
        
    });
     $('#listaAtribuidos').on('click', '.clickable-row', function(event) {
        $(this).addClass('ativo').siblings().removeClass('ativo');    
        paraDireita = $(this);
        
    });
};

var motoSele = document.getElementById("motoSelecionado");
motoSele.onchange = function(){
    $("#listaAtribuidos").empty();
    $("#listaPets").empty();
    if (motoSele.value==="-1"){
        $("#motoristaEdit").hide();
    }
    else{
        $.get("https://steveown.github.io/pizzariajson/pets.json", function( data ) {
            var pets = JSON.parse(JSON.stringify(data));
            for(i=0; i<pets.length; i+=1){
                var id=pets[i]["id"];
                var nome = pets[i]["pet"];
                $("#listaPets").append('<tr class="clickable-row"><th scope="row">'+id+'</th><td>'+nome+'</td></tr>');
            }
        });
        $("#motoristaEdit").show();
    }
    
};

var btnEsquerda = document.getElementById("btnEsq");
btnEsquerda.onclick = function(){
    if (paraEsquerda!=null){
        $("#listaAtribuidos").append(paraEsquerda.removeClass("ativo"));
    }
    paraEsquerda = null;
};

var btnDireita = document.getElementById("btnDir");
btnDireita.onclick = function(){
    if (paraDireita!=null){
        $("#listaPets").append(paraDireita.removeClass("ativo"));
    }
    paraDireita = null;
};