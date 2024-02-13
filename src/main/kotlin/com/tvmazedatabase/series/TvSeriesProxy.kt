package com.tvmazedatabase.series

import com.tvmazedatabase.series.model.TvSerie
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("")
@Produces(MediaType.APPLICATION_JSON)
interface TvSeriesProxy {

    @GET
    @Path("/shows/{id}")
    fun getTvSerie(@PathParam("id") id: Int): TvSerie
}