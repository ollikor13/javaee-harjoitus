package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ping")
public class PongResource {

    /**
    Tämä luokka alustaa routet
    /{name} Palauttaa listan pongeja
    /id/{id} Palauttaa tietyn pongin tietyllä id:llä
     */

    @Inject
    PongService service;

    @GET
    @Path("/{name}")
    /**@Produces(MediaType.APPLICATION_JSON)**/
    @Produces({MediaType.TEXT_HTML})
    public List<Pong> ping(@PathParam("name") String name) {
        return service.getPongs(name);
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong getPong(@PathParam("id") Long id) {
        return service.getPong(id);
    }

    @POST
    @Path("/create/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong createPong(@PathParam("name") String name) {
        return service.createPong(name);
    }

    @POST
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removePong(@PathParam("id") Long id) {
        if(service.removePong(id)){
            return "Removed successfully!";
        }else{
            return "Could not remove pong by id: " + id;
        }
    }
}
