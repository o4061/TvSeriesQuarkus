package com.tvmazedatabase.series

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.metrics.MetricUnits
import org.eclipse.microprofile.metrics.annotation.Counted
import org.eclipse.microprofile.metrics.annotation.Gauge
import org.eclipse.microprofile.metrics.annotation.Metered
import org.eclipse.microprofile.metrics.annotation.Timed

@Path("/v2/tvserie")
class TvSerieController {

    @Inject
    lateinit var tvSerieService: TvSerieService

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "getAllTvSeries", description = "Count how many times the getAllTvSeries has been invoked ")
    @Transactional
    fun getAllTvSeries(): Response {
        return Response.ok(tvSerieService.findAll()).build()
    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "countFetchTvSeries", description = "Count how many times the getTvSerie has been invoked ")
    @Timed(
        name = "timeFetchTvSeries",
        description = "How long it takes to invoke the getTvSerie",
        unit = MetricUnits.MILLISECONDS
    )
    @Metered(
        name = "meteredFetchTvSeries",
        description = "Measures throughput of getTvSerie method"
    )
    @Gauge(
        name = "gaugeFetchTvSeries",
        description = "Time to getTvSerie method",
        unit = MetricUnits.MILLISECONDS
    )
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