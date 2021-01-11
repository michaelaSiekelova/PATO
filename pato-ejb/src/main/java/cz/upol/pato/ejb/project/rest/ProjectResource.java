package cz.upol.pato.ejb.project.rest;

import cz.upol.pato.ejb.autentification.api.AutentificationEJBLocal;
import cz.upol.pato.ejb.autentification.dto.UserDto;
import cz.upol.pato.ejb.project.api.ProjectManagementEJBLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.logging.Logger;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Path("/model/project")
@Produces({ "application/json" })
@Api(value = "/model/project")
@Getter @Setter  @AllArgsConstructor
public class ProjectResource {

    Logger log = Logger.getLogger(ProjectResource.class.getName());

    @Inject
    private ProjectManagementEJBLocal projectEJB;

    @Inject
    private AutentificationEJBLocal authEJB;

    private UserDto currentlyLoggedUser;

    public ProjectResource(){
        log.info("calling constructor ProjectResource");
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if (principal instanceof KeycloakPrincipal){
            KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>)principal;
            String email = kp.getKeycloakSecurityContext().getIdToken().getEmail();
            currentlyLoggedUser = authEJB.getCurrentUserProfile(email);
        }
    }


    @GET
    @Path("/allProjects")
    @ApiOperation(value = "gets all projects", response = Json.class)
    public Response getAllProjects()  {
        return Response.ok(projectEJB.getAllProjectsForUser(1)).build();
    }

    @GET
    @Path("/projectDetail/{projectId}")
    @ApiOperation(value = "gets projectDetail", response = Json.class)
    public Response getProjectDetail(@PathParam("projectId") long id)  {
        return Response.ok(projectEJB.getProjectDetail(id)).build();
    }

    @GET
    @Path("/create/{newProjectName}/{newProjectKey}")
    @ApiOperation(value = "creates project", response = Json.class)
    public Response createProject(@PathParam("newProjectName") String name, @PathParam("newProjectKey") String key)  {
        log.info("rest");
        return Response.ok(projectEJB.createProject(name, key)).build();
    }
}
