/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.rest;

import com.demo.controller.ClienteMb;
import com.demo.model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Gary
 */
@Path("cliente")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class ClienteEndpoint {

    @EJB
    ClienteMb clienteFacade;

    @GET
    public List<Cliente> listAll() {
        return clienteFacade.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Cliente findByIf(@PathParam("id") Integer id) {
        return clienteFacade.findById(id);
    }

    @POST
    public Response create(Cliente cliente) {
        clienteFacade.create(cliente);
        return Response.created(UriBuilder.fromResource(ClienteEndpoint.class).path(String.valueOf(cliente.getId())).build()).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Integer id, Cliente cliente) {
        clienteFacade.update(cliente);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id") Integer id) {
        Cliente cliente =  clienteFacade.findById(id);
        clienteFacade.delete(cliente);
        return Response.noContent().build();
    }

}
