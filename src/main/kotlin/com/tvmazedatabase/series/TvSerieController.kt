package com.tvmazedatabase.series

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/v2/tvserie")
class TvSerieController {

    @Inject
    lateinit var tvSerieService: TvSerieService

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun getAllTvSeries(): Response {
        return Response.ok(tvSerieService.findAll()).build()
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getTvSerie(
        @PathParam("id") id: Int
    ): Response {
        tvSerieService.findById(id)?.let {
            return Response.ok(it).build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }

    @GET
    @Path("id/{id}/episodes")
    @Produces(MediaType.APPLICATION_JSON)
    fun getEpisodes(
        @PathParam("id") id: Int
    ): Response {
        tvSerieService.findById(id)?.let {
            return Response.ok(it.episodes).build()
        }
        return Response.status(Response.Status.NOT_FOUND).build()
    }
}