package io.github.aaiezza.graphql

import com.expediagroup.graphql.server.types.GraphQLServerRequest

interface GraphQLRequestParser<Request> {
    suspend fun parseRequest(request: Request): GraphQLServerRequest?
}
