package com.meidrik.rsvp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RsvpRepository: CrudRepository<Rsvp, UUID> {
}