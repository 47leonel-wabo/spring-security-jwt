package com.aiwa.photon.app.eureka.dicovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class PhotonAppDiscoveryServiceApplication

fun main(args: Array<String>) {
	runApplication<PhotonAppDiscoveryServiceApplication>(*args)
}
