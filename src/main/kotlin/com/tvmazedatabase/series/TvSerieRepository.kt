package com.tvmazedatabase.series

import com.tvmazedatabase.series.model.TvSerie
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class TvSerieRepository : PanacheRepositoryBase<TvSerie, Int>