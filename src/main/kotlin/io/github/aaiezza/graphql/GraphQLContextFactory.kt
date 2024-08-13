package io.github.aaiezza.graphql

import com.expediagroup.graphql.generator.extensions.toGraphQLContext
import graphql.GraphQLContext
import org.springframework.stereotype.Component

interface GraphQLContextFactory<Request> {
    suspend fun generateContext(request: Request): GraphQLContext =
        emptyMap<Any, Any>().toGraphQLContext()
}
