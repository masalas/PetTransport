/* 
* Masalas copyright 2018 - 123893'21
 */
var paraEsquerda=null;
var paraDireita=null;

window.onload = function(){
    $.post("cadastromotorista", {"acao": "motoristas"})
        .done(function( data ) {
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
        $.post("gerenciamento", {"acao": "pets", "motorista": motoSele.value})
            .done(function( data ) {
            var pets = JSON.parse(JSON.stringify(data));
            for(i=0; i<pets.length; i+=1){
                var id=pets[i]["id"];
                var nome = pets[i]["nome"];
                var dados = "<input type=text style='display: none' name='pet' value='"+id+"'/>"+
                            "<input type=text style='display: none' name='motorista' value='"+motoSele.value+"'/>";
                $("#listaPets").append('<tr class="clickable-row"><th scope="row">'+id+'</th><td>'+nome+'</td><td>'+dados+'</td></tr>');
            }
        });
        $.post("gerenciamento", {"acao": "pets-associados", "motorista": motoSele.value})
            .done(function( data ) {
            var pets = JSON.parse(JSON.stringify(data));
            for(i=0; i<pets.length; i+=1){
                var id=pets[i]["id"];
                var nome = pets[i]["nome"];
                var dados = "<input type=text style='display: none' name='pet' value='"+id+"'/>"+
                            "<input type=text style='display: none' name='motorista' value='"+motoSele.value+"'/>";
                $("#listaAtribuidos").append('<tr class="clickable-row"><th scope="row">'+id+'</th><td>'+nome+'</td><td>'+dados+'</td></tr>');
            }
        });        
        $("#motoristaEdit").show();
    }
    
};

var btnEsquerda = document.getElementById("btnEsq");
btnEsquerda.onclick = function(){
    if (paraEsquerda!=null){
        $("#listaAtribuidos").append(paraEsquerda.removeClass("ativo"));
        var petId = paraEsquerda.find("input[name='pet']").val();
        var motoristaId = paraEsquerda.find("input[name='motorista']").val();
        $.post("gerenciamento", {"acao": "associar", "pet": petId, "motorista": motoristaId});
    }
    paraEsquerda = null;
};

var btnDireita = document.getElementById("btnDir");
btnDireita.onclick = function(){
    if (paraDireita!=null){
        $("#listaPets").append(paraDireita.removeClass("ativo"));
        var petId = paraDireita.find("input[name='pet']").val();
        var motoristaId = paraDireita.find("input[name='motorista']").val();
        $.post("gerenciamento", {"acao": "desassociar", "pet": petId, "motorista": motoristaId});
    }
    paraDireita = null;
};