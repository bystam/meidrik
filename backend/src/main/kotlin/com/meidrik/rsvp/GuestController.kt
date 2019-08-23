package com.meidrik.rsvp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.time.Instant
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/guest")
class GuestController {
    @Autowired
    private lateinit var guestRepository: GuestRepository
    @Autowired
    private lateinit var rsvpRepository: RsvpRepository

    @GetMapping
    fun all(): ResponseEntity<Guests> =
        ResponseEntity.ok(Guests(guestRepository.findAll().toList()))

    @GetMapping("/{guestId}")
    fun one(@PathVariable guestId: Long): ResponseEntity<Guest> =
        ResponseEntity.ok(guestRepository.findById(guestId).orElseThrow { NotFound() })

    @PostMapping
    fun create(@Valid @RequestBody guest: Guest): ResponseEntity<Guest> =
        ResponseEntity.ok(guestRepository.save(guest))

    @PostMapping("/{guestId}/rsvp")
    fun rsvp(@PathVariable guestId: Long, @Valid @RequestBody rsvp: Rsvp): ResponseEntity<Rsvp> {
        val guest = guestRepository.findById(guestId).orElseThrow { NotFound() }
        guest.currentRsvp?.deletedAt = Instant.now()
        rsvp.guest = guest
        guestRepository.save(guest)
        return ResponseEntity.ok(rsvpRepository.save(rsvp))
    }

    data class Guests(val rsvps: List<Guest>)

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Guest not found")
    class NotFound: RuntimeException()
}