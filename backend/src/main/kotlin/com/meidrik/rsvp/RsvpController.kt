package com.meidrik.rsvp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/rsvp")
class RsvpController {
    @Autowired
    private lateinit var rsvpRepository: RsvpRepository

    @GetMapping
    fun all(): ResponseEntity<List<Rsvp>> =
        ResponseEntity.ok(rsvpRepository.findAll().toList())

    @PostMapping
}