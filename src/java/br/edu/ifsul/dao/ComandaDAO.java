/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Comanda;
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
public class ComandaDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Comanda> listarTodos;

    public ComandaDAO() {
    }
    
    public void persist(Comanda obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Comanda obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Comanda obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Comanda getObjectById(Integer id) throws Exception{
        return getEm().find(Comanda.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Comanda> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Comanda> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
