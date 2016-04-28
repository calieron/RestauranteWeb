/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Nota;
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
public class NotaDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Nota> listarTodos;

    public NotaDAO() {
    }
    
    public void persist(Nota obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Nota obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Nota obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Nota getObjectById(Integer id) throws Exception{
        return getEm().find(Nota.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Nota> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Nota> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
