/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.rest;

import edu.sangerardo.edspace.proyecto.service.CommunityService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author jorgemalla
 */
@Stateless
@Path("/communities")
public class CommunityResource {

    @EJB
    private CommunityService communityService;

    public CommunityResource() {
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<CommunityDTO> findAll() {
//        return communityService.getCommunitiesParent();
//    }

}
