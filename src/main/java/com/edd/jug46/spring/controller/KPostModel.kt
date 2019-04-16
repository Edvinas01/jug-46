package com.edd.jug46.spring.controller

data class KPostModel(
    val id: Long,
    val content: String,
    val likedBy: List<String>
)
