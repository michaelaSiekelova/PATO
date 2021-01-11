package cz.upol.pato.ejb.autentification.rest;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import cz.upol.pato.ejb.autentification.api.AutentificationEJBLocal;
import cz.upol.pato.ejb.autentification.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.logging.Logger;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

import java.security.Principal;

@Path("/model/user")
@Produces({ "application/json" })
@Api(value = "/model/user")
@Getter @Setter  @AllArgsConstructor
public class UserResource {

    Logger log = Logger.getLogger(UserResource.class.getName());

    @Inject
    private AutentificationEJBLocal authEJB;


    private UserDto currentlyLoggedUser;

    public UserResource(){
        log.info("calling constructor ProjectResource");
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if (principal instanceof KeycloakPrincipal){
            KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>)principal;
            String email = kp.getKeycloakSecurityContext().getIdToken().getEmail();
            currentlyLoggedUser = authEJB.getCurrentUserProfile(email);
        }
    }


    @GET
    @Path("/userDto")
    @ApiOperation(value = "gets user profile", response = UserDto.class)
    public Response getUser()  {
        log.info("calling getUser ------------------------------");
        return Response.ok(currentlyLoggedUser).build();
    }

}
