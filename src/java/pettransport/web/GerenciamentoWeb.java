/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pettransport.web;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pettransport.controller.ControllerMotorista;
import pettransport.controller.ControllerPet;
import pettransport.controller.ControllerRequisicao;
import pettransport.controller.ControllerSessao;
import pettransport.controller.impl.ControllerMotoristaImpl;
import pettransport.controller.impl.ControllerPetImpl;
import pettransport.controller.impl.ControllerRequisicaoImpl;
import pettransport.controller.impl.ControllerSessaoImpl;
import pettransport.models.Motorista;
import pettransport.models.Pet;
import pettransport.models.Requisicao;

/**
 *
 * @author masalas
 */
@WebServlet("/gerenciamento")
public class GerenciamentoWeb extends HttpServlet {
    
    private ControllerSessao controllerSessao;
    private ControllerPet controllerPet;
    private ControllerMotorista controllerMotorista;
    private ControllerRequisicao controllerRequisicao;
    
    public GerenciamentoWeb(){
        this.controllerSessao = new ControllerSessaoImpl();
        this.controllerPet = new ControllerPetImpl();
        this.controllerRequisicao = new ControllerRequisicaoImpl();
        this.controllerMotorista = new ControllerMotoristaImpl();
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.controllerSessao.isLogado(req)){
            this.controllerSessao.redirectLogin(resp);
        }
        else{
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/gerenciamento.jsp");
            rd.forward(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.controllerSessao.isLogado(req)){
            this.controllerSessao.redirectLogin(resp);
        }
        else{
            int motoristaId;
            Motorista motorista;
            int petId;
            Pet pet;
            List<Pet> petsAsso;
            switch(req.getParameter("acao")){
                case "pets" : 
                    motoristaId = Integer.valueOf(req.getParameter("motorista"));
                    motorista = this.controllerMotorista.buscarPorId(motoristaId);
                    
                    List<Pet> pets = this.controllerPet.getTodosPets();
                    List<Pet> petsDisponiveis = new ArrayList<>();
                    
                    List<Requisicao> reqs = this.controllerRequisicao.getRequisicaoByMotorista(motorista);
                    
                    for(Pet p: pets){
                        if (this.isDisponivel(reqs, p)){
                            petsDisponiveis.add(p);
                        }                        
                    }
                    
                    String json = new Gson().toJson(petsDisponiveis);
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(json);
                    break;
                case "pets-associados":
                    motoristaId = Integer.valueOf(req.getParameter("motorista"));
                    motorista = this.controllerMotorista.buscarPorId(motoristaId);
                    
                    petsAsso = new ArrayList<>();
                    
                    for(Requisicao requi : this.controllerRequisicao.getRequisicaoByMotorista(motorista)){
                        petsAsso.add(requi.getPet());
                    }
                    String jsonAsso = new Gson().toJson(petsAsso);
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(jsonAsso);
                    break;
                case "associar":
                    petId = Integer.valueOf(req.getParameter("pet"));
                    motoristaId = Integer.valueOf(req.getParameter("motorista"));
                    
                    motorista = this.controllerMotorista.buscarPorId(motoristaId);
                    pet = this.controllerPet.getPetById(petId);
                    
                    Requisicao requisicao = new Requisicao();
                    requisicao.setMotorista(motorista);
                    requisicao.setPet(pet);

                    this.controllerRequisicao.adicionarRequisicao(requisicao);
                    break;
                   
                case "desassociar":
                    petId = Integer.valueOf(req.getParameter("pet"));
                    motoristaId = Integer.valueOf(req.getParameter("motorista"));
                    
                    motorista = this.controllerMotorista.buscarPorId(motoristaId);
                    pet = this.controllerPet.getPetById(petId);
                    
                    Requisicao reqExcluir = this.controllerRequisicao.getRequisicaoByMotoristaPet(motorista, pet);
                    this.controllerRequisicao.deletarRequisicao(reqExcluir);
                    
                    
            }
        }
    }
    
    private boolean isDisponivel(List<Requisicao> reqs, Pet pet){
        for(Requisicao requi : reqs){
            if (requi.getPet().getId()==pet.getId()){
                return false;
            }
        }
        return true;
    }
}
