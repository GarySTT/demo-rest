package com.demo.controller;

import com.demo.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ClienteMb {

    @PersistenceContext
    EntityManager em;

    public void create(Cliente cliente) {
        em.persist(cliente);
    }

    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    public void delete(Cliente cliente) {
        em.remove(em.merge(cliente));
    }

    public List<Cliente> findAll() {
        String query = "SELECT c FROM Cliente c";

        TypedQuery<Cliente> findQuery = em.createQuery(
                query, Cliente.class);

        return findQuery.getResultList();

    }

    public Cliente findById(Integer id) {
        return em.find(Cliente.class, id);
    }
}
