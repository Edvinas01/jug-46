package com.edd.jug46

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext

private typealias Call = PipelineContext<*, ApplicationCall>

suspend fun Call.badRequest(message: String) = call.respond(
    message = MessageResponse(message),
    status = HttpStatusCode.BadRequest
)

suspend fun Call.notFound(message: String) = call.respond(
    message = MessageResponse(message),
    status = HttpStatusCode.NotFound
)
