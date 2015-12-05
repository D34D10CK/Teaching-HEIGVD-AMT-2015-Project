/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("events")
public class EventsResource {
    @EJB
    private ApplicationDAOLocal applicationsDAO;
    
    @Context
    UriInfo uriInfo;
    
    
}
