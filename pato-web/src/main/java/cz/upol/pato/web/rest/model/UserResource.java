package cz.upol.pato.web.rest.model;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import cz.upol.pato.ejb.autentification.api.AutentificationEJBLocal;
import cz.upol.pato.ejb.autentification.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.logging.Logger;

import java.util.Locale;


@RequestScoped
@Path("/model/user")
@Produces({ "application/json" })
@Api(value = "/model/user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserResource {

    Logger log = Logger.getLogger(UserResource.class.getName());

    @Inject
    private AutentificationEJBLocal authEJB;

    @GET
    @Path("/userDto")
    @ApiOperation(value = "gets user profile", response = UserDto.class, responseContainer = "List")
    public Response getUser()  {
        log.info("calling getUser ------------------------------");
        return Response.ok(authEJB.getCurrentUserProfile()).build();
    }

}
