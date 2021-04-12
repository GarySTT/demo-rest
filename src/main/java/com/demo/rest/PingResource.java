/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Gary
 */
@Path("ping")
public class PingResource {

    @GET
    public String ping() {
        return "Ping";
    }
}
