package com.example.evam3.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Entity
@Table (name = "scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Double = 0.0
    var minutes: Int = 0

    @JoinColumn(name = "film_id")
    var filmId: Long? = null
}