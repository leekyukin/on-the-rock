package com.kyukin.ontherock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class OnTheRockApplication

fun main(args: Array<String>) {
    runApplication<OnTheRockApplication>(*args)
}
