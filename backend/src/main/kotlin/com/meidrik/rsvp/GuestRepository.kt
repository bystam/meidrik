package com.meidrik.rsvp

import org.springframework.data.repository.CrudRepository

interface GuestRepository: CrudRepository<Guest, Long>
