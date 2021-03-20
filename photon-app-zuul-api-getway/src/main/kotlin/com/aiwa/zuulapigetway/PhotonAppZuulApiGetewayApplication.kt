package com.aiwa.zuulapigetway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
class PhotonAppZuulApiGetewayApplication

fun main(args: Array<String>) {
    runApplication<PhotonAppZuulApiGetewayApplication>(*args)
}
