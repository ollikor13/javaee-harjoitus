package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.service.DemoService;
import fi.ptuomaal.ping.service.PongService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import fi.ptuomaal.ping.entity.DemoEntity;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.List;

@Path("demo")
public class DemoResource {    /**
 Testiluokka joka sisältää yhden testin
 */

@Inject
DemoService service;

    @GET
    @Path("/DET/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemoEntity> getEntitiesByName(@PathParam("name") String name) {
        return service.getDemoEntitiesByName(name);
    }

    @GET
    @Path("/DET")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemoEntity> getAllEntities() {
        return service.getAllEntities();
    }
}
