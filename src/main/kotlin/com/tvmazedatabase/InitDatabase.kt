package com.tvmazedatabase

import com.tvmazedatabase.episodes.EpisodesProxy
import com.tvmazedatabase.series.TvSerieService
import com.tvmazedatabase.series.TvSeriesProxy
import io.quarkus.runtime.ShutdownEvent
import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger

@ApplicationScoped
class InitDatabase {

    @Inject
    @RestClient
    lateinit var tvSeriesProxy: TvSeriesProxy

    @Inject
    @RestClient
    lateinit var episodesProxy: EpisodesProxy

    @Inject
    lateinit var tvSerieService: TvSerieService

    private val logger = Logger.getLogger(InitDatabase::class.simpleName)

    fun onStart(@Observes event: StartupEvent?) {
        logger.info("The quarkus application is starting...")
        init()
    }

    fun onStop(@Observes event: ShutdownEvent?) {
        logger.info("The quarkus application is stopping...")
    }

    @Transactional
    fun init() {
        logger.info("TvSerie count before: ${tvSerieService.countTvSerie()}")
        val totalSeries = 10
        for (i in 1..totalSeries) {
            try {
                val serie = tvSeriesProxy.getTvSerie(i)
                serie.episodes = episodesProxy.getEpisodes(i)
                tvSerieService.saveTvSerie(serie)
                printLoadingBar(i, totalSeries)
            } catch (e: Exception) {
                fallBackGet()
            }
        }
        logger.info("TvSerie count after: ${tvSerieService.countTvSerie()}")
    }

    private fun fallBackGet() = Response.ok(ArrayList<Any>()).build()

    fun printLoadingBar(current: Int, total: Int) {
        val barLength = 100
        val percentage = (current.toDouble() / total * 100).toInt()
        val progressMarks = (current.toDouble() / total * barLength).toInt()
        val progressBar = "=".repeat(progressMarks) + " ".repeat(barLength - progressMarks)
        print("\rInitialize database [${progressBar}] $percentage% Completed")
        if (current == total) println()
    }
}