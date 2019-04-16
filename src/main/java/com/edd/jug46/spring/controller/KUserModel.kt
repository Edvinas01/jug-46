package com.edd.jug46.spring.controller

data class KUserModel(
    val id: Long,
    val username: String,
    val picture: String,
    val posts: List<KPostModel>
)
