package com.client

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/client")
class ClientController {

    @Inject
    lateinit var clientService: ClientService

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Response {
        return Response.ok(clientService.findAll()).build()
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findById(@PathParam("id") id: String): Response {
        clientService.findById(id)?.let {
            return Response.ok(it).build()
        }
        return Response.ok("Client does not Exist").status(Response.Status.NOT_FOUND).build()
    }

    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findByName(@PathParam("name") name: String): Response {
        clientService.findByName(name)?.let {
            return Response.ok(it).build()
        }
        return Response.ok("Client does not Exist").status(Response.Status.NOT_FOUND).build()
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveClient(client: Client): Response {
        clientService.saveClient(client)
        return Response.ok(client).status(Response.Status.CREATED).build()
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateClient(client: Client): Response {
        clientService.updateClient(client)
        clientService.findById(client.id)?.let {
            return Response.ok(it).build()
        }
        return Response.ok("Client not  found").build()
    }

    @DELETE
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteClient(@PathParam("id") id: String): Response {
        clientService.findById(id)?.let {
            clientService.deleteClient(id)
            return Response.ok("Client deleted").build()
        }
        return Response.ok("Client does not Exist").status(Response.Status.NOT_FOUND).build()
    }
}