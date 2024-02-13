package com.tvmazedatabase.series

import com.tvmazedatabase.episodes.EpisodesProxy
import jakarta.annotation.PostConstruct
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.rest.client.inject.RestClient

@Path("/v2/tvserie")
class TvSerieController {

    @Inject
    @RestClient
    lateinit var tvSeriesProxy: TvSeriesProxy

    @Inject
    lateinit var tvSerieService: TvSerieService

    @Inject
    @RestClient
    lateinit var episodesProxy: EpisodesProxy

    @PostConstruct
    @Transactional
    fun init() {
        for (i in 1..100) {
            try {
                val serie = tvSeriesProxy.getTvSerie(i)
                tvSerieService.saveTvSerie(serie)

//                serie.episodes = episodesProxy.getEpisodes(i)
//                tvSeries.add(serie)
            } catch (e: Exception) {
                fallBackGet()
            }
        }
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun getAllTvSeries(): Response {
        return Response.ok(tvSerieService.findAll()).build()
    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    fun getTvSerie(
//        @PathParam("id") id: Int
//    ): Response {
//        val serie = tvSeries.firstOrNull { it.id == id }
//        return serie?.let {
//            Response.ok(it).build()
//        } ?: Response.status(Response.Status.NOT_FOUND).build()
//    }

//    @GET
//    @Path("/{id}/episodes")
//    @Produces(MediaType.APPLICATION_JSON)
//    fun getEpisodes(
//        @PathParam("id") id: Int
//    ): Response {
//        val episodes = tvSeries.firstOrNull { it.id == id }?.episodes
//        return episodes?.let {
//            Response.ok(it).build()
//        } ?: Response.status(Response.Status.NOT_FOUND).build()
//    }

    private fun fallBackGet() = Response.ok(ArrayList<Any>()).build()
}