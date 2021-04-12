/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.rest;

import com.demo.controller.ClienteSP;
import com.demo.model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Gary
 */
@Path("clientesp")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class ClienteSPEndPoint {

    @EJB
    ClienteSP clienteSP;

    @GET
    public List<Cliente> listAll() {

        return clienteSP.findall();

    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Cliente findByIf(@PathParam("id") Integer id) {
        return clienteSP.findId(id);
    }

    @GET
    @Path("/json")
    public JSONArray listalljson() {
        List<Cliente> lstCliente = clienteSP.findall();
        JSONArray lstClientes = new JSONArray();
        for (Cliente c : lstCliente) {
            JSONObject obj = new JSONObject();
            obj.put("id", c.getId());
            obj.put("nombre", c.getNombre());
            lstClientes.add(obj);
        }
        return lstClientes;
    }

    @POST
    public Response create(Cliente cliente) {
        clienteSP.creat(cliente);
        return Response.created(UriBuilder.fromResource(ClienteSPEndPoint.class).path(String.valueOf(cliente.getId())).build()).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Integer id, Cliente cliente) {
        clienteSP.update(cliente);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id") Integer id, Cliente cliente) {
        clienteSP.delte(cliente);
        return Response.noContent().build();
    }
}
