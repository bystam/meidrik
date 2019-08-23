package com.meidrik

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {

    @Autowired
    fun objectMapper(objectMapper: ObjectMapper) {
        objectMapper.registerModule(KotlinModule())
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
