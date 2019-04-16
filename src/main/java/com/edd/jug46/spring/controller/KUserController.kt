package com.edd.jug46.spring.controller

import com.edd.jug46.spring.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kusers")
open class KUserController(private val users: UserService) {

    @GetMapping
    fun getUsers() = KUserMapper.map(users.users)
}
