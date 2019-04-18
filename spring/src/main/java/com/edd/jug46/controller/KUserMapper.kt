package com.edd.jug46.controller

import com.edd.jug46.domain.Post
import com.edd.jug46.domain.User

object KUserMapper {

    @JvmStatic
    fun map(users: Collection<User>) = users.map { map(it) }

    private fun map(post: Post) = KPostModel(
        id = post.id,
        content = post.content,
        likedBy = post.likedBy.map { it.username }
    )

    private fun map(user: User) = KUserModel(
        id = user.id,
        username = user.username,
        picture = user.picture,
        posts = user.posts.map { map(it) }
    )
}
