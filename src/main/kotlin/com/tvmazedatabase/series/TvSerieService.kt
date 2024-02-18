package com.tvmazedatabase.series

import com.tvmazedatabase.series.model.TvSerie
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class TvSerieService {

    @Inject
    private lateinit var tvSerieRepository: TvSerieRepository

    fun findAll(): List<TvSerie> {
        return tvSerieRepository.findAll().list<TvSerie?>().sortedBy { it.id }
    }

    fun findById(id: Int): TvSerie? {
        return tvSerieRepository.findById(id)
    }

    fun saveTvSerie(cvSerie: TvSerie) {
        tvSerieRepository.persist(cvSerie)
    }

    fun countTvSerie(): Long {
        return tvSerieRepository.count()
    }
}