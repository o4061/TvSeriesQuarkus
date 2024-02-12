package com.client

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.time.Period

@Entity
class Client : PanacheEntityBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    lateinit var id: String
    lateinit var name: String
    lateinit var surname: String
    lateinit var dob: LocalDate
    lateinit var email: String
    var basicSalary = 0.0
    final var age: Int = 0
        get() = Period.between(dob, LocalDate.now()).years
        private set
}