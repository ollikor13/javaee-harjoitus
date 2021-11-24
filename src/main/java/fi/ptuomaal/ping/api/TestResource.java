package fi.ptuomaal.ping.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("test")
public class TestResource {

    /**
    Testiluokka joka sisältää yhden testin
     */

    @Inject
    PongService service;

    @GET
    @Path("/test/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String test(@PathParam("name") String name) {
        return service.getResponseForTest(name);
    }
}
