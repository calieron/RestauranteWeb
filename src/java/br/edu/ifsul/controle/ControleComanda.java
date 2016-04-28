/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ComandaDAO;
import br.edu.ifsul.modelo.Comanda;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "controleComanda")
@ViewScoped
public class ControleComanda implements Serializable{
    
    @EJB
    private ComandaDAO dao;
    private Comanda objeto;

    public ControleComanda() {
    }
    
    public String listar(){
        return "/privado/comanda/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Comanda();
    }
    
    public void salvar(){
        try{
            if (objeto.getId() == null){
                dao.persist(objeto);
            }else{
                dao.merge(objeto);
            }
            UtilMensagens.mensagemInformacao("objeto persistido com sucesso");
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao persistrr objeto: "+e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
        }
    }
    
    public  void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
        }catch (Exception e){
            UtilMensagens.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }
    
    

    public ComandaDAO getDao() {
        return dao;
    }

    public void setDao(ComandaDAO dao) {
        this.dao = dao;
    }

    public Comanda getObjeto() {
        return objeto;
    }

    public void setObjeto(Comanda objeto) {
        this.objeto = objeto;
    }
    
       
}
