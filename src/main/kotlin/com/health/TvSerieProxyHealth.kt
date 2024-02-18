package com.health

import com.tvmazedatabase.series.TvSeriesProxy
import jakarta.inject.Inject
import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import org.eclipse.microprofile.rest.client.inject.RestClient

@Liveness
class TvSerieProxyHealth : HealthCheck {

    @Inject
    @RestClient
    lateinit var tvSeriesProxy: TvSeriesProxy

    override fun call(): HealthCheckResponse? {
        tvSeriesProxy.getTvSerie(1)
        return HealthCheckResponse.named("TvMaze APIs").up().build()
    }
}