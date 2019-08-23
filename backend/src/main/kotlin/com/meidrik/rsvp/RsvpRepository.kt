package com.meidrik.rsvp

import org.springframework.data.repository.CrudRepository
import java.util.*

interface RsvpRepository: CrudRepository<Rsvp, UUID>
