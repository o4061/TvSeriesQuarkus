package com.tvmazedatabase.episodes

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("")
@Produces(MediaType.APPLICATION_JSON)
interface EpisodesProxy {

    @GET
    @Path("/shows/{id}/episodes")
    fun getEpisodes(@PathParam("id") id: Int): Episodes
}