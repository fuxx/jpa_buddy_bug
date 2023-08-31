package com.example.abstractbug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AbstractBugApplication

fun main(args: Array<String>) {
    runApplication<AbstractBugApplication>(*args)
}
