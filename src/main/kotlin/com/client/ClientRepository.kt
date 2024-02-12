package com.client

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ClientRepository : PanacheRepositoryBase<Client, String> {
    fun findByName(name: String): Client? {
        return find("name", name).firstResult()
    }
}