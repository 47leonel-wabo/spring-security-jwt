package com.aiwa.photon.app.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class PhotonAppUsersApiApplication

fun main(args: Array<String>) {
	runApplication<PhotonAppUsersApiApplication>(*args)
}
