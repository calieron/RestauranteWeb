/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CaixaDAO;
import br.edu.ifsul.modelo.Caixa;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "controleCaixa")
@ViewScoped
public class ControleCaixa implements Serializable{
    
    @EJB
    private CaixaDAO dao;
    private Caixa objeto;

    public ControleCaixa() {
    }
    
    public String listar(){
        return "/privado/caixa/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Caixa();
    }
    
    public void salvar(){
        try{
            if (objeto.getRegistro() == null){
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
    
    

    public CaixaDAO getDao() {
        return dao;
    }

    public void setDao(CaixaDAO dao) {
        this.dao = dao;
    }

    public Caixa getObjeto() {
        return objeto;
    }

    public void setObjeto(Caixa objeto) {
        this.objeto = objeto;
    }
    
       
}
