package com.aiwa.ws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MobAppWsApplication

fun main(args: Array<String>) {
	runApplication<MobAppWsApplication>(*args)
}
