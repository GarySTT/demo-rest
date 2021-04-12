package com.demo.controller;

import com.demo.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Stateless
public class ClienteSP {

    @PersistenceContext
    EntityManager em;

    public List<Cliente> findall() {
        //List<Cliente> lstCliente = new ArrayList<>();
        StoredProcedureQuery query = em.createStoredProcedureQuery("obtenerCliente", Cliente.class);
        return query.getResultList();
    }

    public Cliente findId(Integer id) {
        return em.find(Cliente.class, id);
    }

    public void creat(Cliente cliente) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("InsertarCliente")
                .registerStoredProcedureParameter("NOMBRE", String.class, ParameterMode.IN)
                .setParameter("NOMBRE", cliente.getNombre())
                .registerStoredProcedureParameter("APELLIDO", String.class, ParameterMode.IN)
                .setParameter("APELLIDO", cliente.getApellido())
                .registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN)
                .setParameter("EMAIL", cliente.getEmail())
                .registerStoredProcedureParameter("SALDO", String.class, ParameterMode.IN)
                .setParameter("SALDO", cliente.getSaldo())
                .registerStoredProcedureParameter("TELEFONO", String.class, ParameterMode.IN)
                .setParameter("TELEFONO", cliente.getTelefono());
        query.execute();
    }

    public void update(Cliente cliente) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("ModificarCliente")
                .registerStoredProcedureParameter("ID_cliente", int.class, ParameterMode.IN)
                .setParameter("ID_cliente", cliente.getId())
                .registerStoredProcedureParameter("NOMBRE", String.class, ParameterMode.IN)
                .setParameter("NOMBRE", cliente.getNombre())
                .registerStoredProcedureParameter("APELLIDO", String.class, ParameterMode.IN)
                .setParameter("APELLIDO", cliente.getApellido())
                .registerStoredProcedureParameter("EMAIL", String.class, ParameterMode.IN)
                .setParameter("EMAIL", cliente.getEmail())
                .registerStoredProcedureParameter("SALDO", String.class, ParameterMode.IN)
                .setParameter("SALDO", cliente.getSaldo())
                .registerStoredProcedureParameter("TELEFONO", String.class, ParameterMode.IN)
                .setParameter("TELEFONO", cliente.getTelefono());
        query.execute();

    }
}
