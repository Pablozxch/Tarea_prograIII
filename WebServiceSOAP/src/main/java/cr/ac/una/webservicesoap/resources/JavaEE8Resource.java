package cr.ac.una.webservicesoap.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("javaee8")
public class JavaEE8Resource {
    
    @GET
    @Path("ping2")
    public Response ping(){
        return Response
                .ok("asdvoiuhbguysdfgiusdafihgbsfadsifdhbugp")
                .build();
    }
}
