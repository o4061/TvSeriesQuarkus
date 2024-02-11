package com.tvmaze.series

import com.tvmaze.episodes.EpisodesProxy
import jakarta.annotation.PostConstruct
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.rest.client.inject.RestClient

@Path("/tvserie")
class TvSerieController {

    @Inject
    @RestClient
    lateinit var tvSeriesProxy: TvSeriesProxy
    private val tvSeries = ArrayList<TvSerie>()

    @Inject
    @RestClient
    lateinit var episodesProxy: EpisodesProxy

    @PostConstruct
    fun init() {
        for (i in 1..10) {
            val serie = tvSeriesProxy.getTvSerie(i)
            serie.episodes = episodesProxy.getEpisodes(i)
            tvSeries.add(serie)
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllTvSeries(): Response {
        return Response.ok(tvSeries).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getTvSerie(
        @PathParam("id") id: Int
    ): Response {
        val serie = tvSeries.firstOrNull { it.id == id }
        return serie?.let {
            Response.ok(it).build()
        } ?: Response.status(Response.Status.NOT_FOUND).build()
    }

    @GET
    @Path("/{id}/episodes")
    @Produces(MediaType.APPLICATION_JSON)
    fun getEpisodes(
        @PathParam("id") id: Int
    ): Response {
        val episodes = tvSeries.firstOrNull { it.id == id }?.episodes
        return episodes?.let {
            Response.ok(it).build()
        } ?: Response.status(Response.Status.NOT_FOUND).build()
    }
}