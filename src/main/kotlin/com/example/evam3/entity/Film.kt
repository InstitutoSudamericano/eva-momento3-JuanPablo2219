package com.example.evam3.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
@Table (name="film")
class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var title: String? = null
    var director: String? = null
    var duration: Long? = null
    var gender: String? = null

    @Column(name = "release_date" )
    var releaseDate: LocalDate? = null
}