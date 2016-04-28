/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.FornecedorDAO;
import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean(name = "controleFornecedor")
@ViewScoped
public class ControleFornecedor implements Serializable{
    
    @EJB
    private FornecedorDAO dao;
    private Fornecedor objeto;

    public ControleFornecedor() {
    }
    
    public String listar(){
        return "/privado/fornecedor/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Fornecedor();
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
    
    

    public FornecedorDAO getDao() {
        return dao;
    }

    public void setDao(FornecedorDAO dao) {
        this.dao = dao;
    }

    public Fornecedor getObjeto() {
        return objeto;
    }

    public void setObjeto(Fornecedor objeto) {
        this.objeto = objeto;
    }
    
       
}
