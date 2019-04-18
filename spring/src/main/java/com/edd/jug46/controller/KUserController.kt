package com.edd.jug46.controller

import com.edd.jug46.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kusers")
open class KUserController(private val users: UserService) {

    @GetMapping
    fun getUsers() = KUserMapper.map(users.users)
}
