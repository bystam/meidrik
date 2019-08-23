package com.meidrik.rsvp

import org.hibernate.annotations.Table
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Rsvp(
    @Id @GeneratedValue
    val id: UUID,
    val name: String,
    val time: Instant
)