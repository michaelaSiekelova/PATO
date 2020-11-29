import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/service")
@Produces({ "application/json" })
@Api(value = "/service")
public class TestService {

    @GET
    @Path("/user")
    @ApiOperation(value = "gets user profile")
    public String getUser()  {

        return "Response.ok(authEJB.getCurrentUserProfile()).build()";
    }

}