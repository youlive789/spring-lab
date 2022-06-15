package com.example.kotlinbasicexample.examples.basic

import com.example.kotlinbasicexample.examples.basic.domain.Hello
import com.example.kotlinbasicexample.examples.basic.service.BasicExampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/basic")
class BasicExampleController(_basicExampleService: BasicExampleService) {
    private val basicExampleService: BasicExampleService = _basicExampleService

    @GetMapping("/hello")
    fun hello(): Hello {
        return basicExampleService.getHelloThroughWowService()
    }
}