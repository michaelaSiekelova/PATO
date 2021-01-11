package cz.upol.pato.ejb.ticket.rest;

import cz.upol.pato.ejb.project.api.ProjectManagementEJBLocal;
import cz.upol.pato.ejb.ticket.api.TicketManagementEJBLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/model/ticket")
@Produces({ "application/json" })
@Api(value = "/model/ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResource {

    Logger log = Logger.getLogger(cz.upol.pato.ejb.ticket.rest.TicketResource.class.getName());

    @Inject
    private TicketManagementEJBLocal ticketEJB;


    @GET
    @Path("/allTicketsForCurrentUser")
    @ApiOperation(value = "gets all tickets for currently logged user", response = Json.class)
    public Response getAllTickets()  {
        return Response.ok(ticketEJB.getAllTicketsForCurrentUser()).build();
    }

    @GET
    @Path("/ticketDetail/{ticketId}")
    @ApiOperation(value = "gets projectDetail", response = Json.class)
    public Response getTicketDetail(@PathParam("ticketId") long id)  {
        return Response.ok(ticketEJB.getTicketDetail(id)).build();
    }

    @GET
    @Path("/create/{newTicketName}/{newTicketDescription}/{projectId}")
    @ApiOperation(value = "creates ticket", response = Json.class)
    public Response createTicket(@PathParam("newTicketName") String name, @PathParam("newTicketDescription") String description, @PathParam("projectId") long projectId)  {
        return Response.ok(ticketEJB.createTicket(name, description, projectId)).build();
    }
}
