/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Caixa;
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
public class CaixaDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Caixa> listarTodos;

    public CaixaDAO() {
    }
    
    public void persist(Caixa obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Caixa obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Caixa obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Caixa getObjectById(Integer id) throws Exception{
        return getEm().find(Caixa.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Caixa> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Caixa> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
