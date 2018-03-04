/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.rest;

import edu.sangerardo.edspace.services.CommunityService;
import edu.sangerardo.edspace.dto.CommunityDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<CommunityDTO> findAll() {
        return communityService.getCommunitiesParent();
    }

}
