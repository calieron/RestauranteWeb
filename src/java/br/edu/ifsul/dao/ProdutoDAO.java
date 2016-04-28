/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Produto;
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
public class ProdutoDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Produto> listarTodos;

    public ProdutoDAO() {
    }
    
    public void persist(Produto obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Produto obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Produto obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Produto getObjectById(Integer id) throws Exception{
        return getEm().find(Produto.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Produto> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Produto> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
