package com.example.kotlinbasicexample.examples.basic.service

import com.example.kotlinbasicexample.examples.basic.domain.Hello
import org.springframework.stereotype.Service

@Service
class BasicExampleService (wowService: WowService) {
    private val wowService: WowService = wowService

    fun getHelloThroughWowService(): Hello {
        return wowService.getHello()
    }
}