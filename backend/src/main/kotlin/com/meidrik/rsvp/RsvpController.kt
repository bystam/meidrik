package com.meidrik.rsvp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("/rsvp")
class RsvpController {
    @Autowired
    private lateinit var rsvpRepository: RsvpRepository

    @GetMapping
    fun all(): ResponseEntity<Rsvps> =
        ResponseEntity.ok(Rsvps(rsvpRepository.findAll().toList()))

    @PostMapping
    fun create(@Valid @RequestBody rsvp: Rsvp): ResponseEntity<Rsvp> =
        ResponseEntity.ok(rsvpRepository.save(rsvp))

    data class Rsvps(val rsvps: List<Rsvp>)
}