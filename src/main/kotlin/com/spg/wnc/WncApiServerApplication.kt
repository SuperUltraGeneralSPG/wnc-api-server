package com.spg.wnc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WncApiServerApplication

fun main(args: Array<String>) {
    runApplication<WncApiServerApplication>(*args)
}
