package com.example.kotlinbasicexample.examples.basic.service

import com.example.kotlinbasicexample.examples.basic.domain.Hello
import org.springframework.stereotype.Service

@Service
class WowServiceImpl : WowService {
    override fun getHello(): Hello {
        return Hello("wow")
    }
}