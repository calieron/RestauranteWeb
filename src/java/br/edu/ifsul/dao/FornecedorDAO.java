/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class FornecedorDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Fornecedor> listarTodos;

    public FornecedorDAO() {
    }
    
    public void persist(Fornecedor obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Fornecedor obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Fornecedor obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Fornecedor getObjectById(Integer id) throws Exception{
        return getEm().find(Fornecedor.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Fornecedor> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Fornecedor> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
