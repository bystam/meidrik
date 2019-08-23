package com.meidrik.rsvp

import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
data class Rsvp(
    @Id val id: UUID = UUID.randomUUID(),
    @Column(nullable = false) val time: Instant = Instant.now(),
    @Column(nullable = false) val name: String,
    @Column(nullable = true) val foodPreferences: String?
)