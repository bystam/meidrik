package com.meidrik.rsvp

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.JoinFormula
import org.hibernate.annotations.Where
import java.time.Instant
import javax.persistence.*

@Entity
data class Guest(
    @Column(nullable = false) val name: String
) {
    @Id @GeneratedValue val id: Long = -1

    @ManyToOne
    @JoinFormula("(SELECT rsvp.id FROM rsvp WHERE rsvp.guest_id = id AND rsvp.deleted_at IS NULL)")
    @JsonManagedReference
    var currentRsvp: Rsvp? = null
}

@Entity
data class Rsvp(
    @Column(nullable = false) val decision: Boolean
) {
    @Id @GeneratedValue val id: Long = -1
    @Column(nullable = false) val createdAt: Instant = Instant.now()
    @Column var deletedAt: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    @JsonBackReference
    lateinit var guest: Guest
}
