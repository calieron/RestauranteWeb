/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
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
public class PessoaDAO implements Serializable{
    @PersistenceContext(unitName = "SistemaParaRestaurante")
    private EntityManager em;
    private List<Pessoa> listarTodos;

    public PessoaDAO() {
    }
    
    public void persist(Pessoa obj) throws Exception{
        getEm().persist(obj);
    }
    
    public void merge(Pessoa obj) throws Exception{
        getEm().merge(obj);
    }
    
    public void remove(Pessoa obj) throws Exception{
        obj = getEm().merge(obj);
        getEm().remove(obj);
    }
    
    public Pessoa getObjectById(Integer id) throws Exception{
        return getEm().find(Pessoa.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Pessoa> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<Pessoa> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
    
    
}
