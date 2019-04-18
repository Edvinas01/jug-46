package com.edd.jug46.controller

data class KPostModel(
    val id: Long,
    val content: String,
    val likedBy: List<String>
)
