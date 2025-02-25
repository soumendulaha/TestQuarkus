package org.acme;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.UserDTO;
import org.acme.service.UserService;

import java.util.List;

//@Path("/hello")
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController  {

   // @GET
   // @Produces(MediaType.TEXT_PLAIN)
   // public String hello() {
    //    return "Hello from Quarkus REST boss";
    //}

        @Inject
        UserService userService;

        @GET
        public List<UserDTO> getUsers() {
            return userService.getAllUsers();
        }

        @POST
        public Response createUser(@Valid UserDTO userDTO) {
            userService.addUser(userDTO);
            return Response.status(Response.Status.CREATED).build();
        }
}
