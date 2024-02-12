package com.client

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class ClientService {

    @Inject
    private lateinit var clientRepository: ClientRepository

    fun saveClient(client: Client) {
        clientRepository.persist(client)
    }

    fun findAll(): List<Client> {
        return clientRepository.listAll()
    }

    fun findById(id: String): Client? {
        return clientRepository.findById(id)
    }

    fun findByName(name: String): Client? {
        return clientRepository.findByName(name)
    }

    fun deleteClient(id: String) {
        clientRepository.delete("id", id)
    }

    @Transactional
    fun updateClient(updateClient: Client) {
        updateClient.id.let { id ->
            clientRepository.findById(id)?.apply {
                name = updateClient.name
                surname = updateClient.surname
                email = updateClient.email
                basicSalary = updateClient.basicSalary
                dob = updateClient.dob
            }?.let { clientRepository.persist(it) }
        }
    }
}