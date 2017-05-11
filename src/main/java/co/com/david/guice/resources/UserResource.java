package co.com.david.guice.resources;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import co.com.david.guice.model.User;
import co.com.david.guice.service.UserService;

/**
 * Created by aurel.avramescu on 14/06/2014.
 */
@Path("/users")
@Produces("application/json")
public class UserResource {

    @Inject
    private UserService userService;


    @POST
    @Consumes("application/json")
    public Response addUser(User user) {
        User copyUser = new UserBuilder().withId(UUID.randomUUID()).build();
        return Response.status(Response.Status.CREATED).entity(userService.addUser(copyUser)).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") String userId) {
        return Response.ok().entity(userService.findById(UUID.fromString(userId))).build();
    }

    @PUT
    @Path("/{userId}")
    @Consumes("application/json")
    public Response updateUser(@PathParam("userId") String userId, User user) {
        return Response.status(Response.Status.CREATED).entity(userService.updateUser(user)).build();
    }

    @GET
    public Response getUsers() {
        return Response.ok().entity(userService.findUsers()).build();
    }


}
