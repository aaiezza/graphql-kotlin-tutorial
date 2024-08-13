package io.github.aaiezza

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.generator.annotations.GraphQLIgnore
import com.expediagroup.graphql.server.operations.Query
import io.github.aaiezza.widget.Widget
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

/**
 * Example query that showcases usage of `SpringDataFetcher`.
 */
@Component
class SpringAwareQuery : Query {
    @GraphQLDescription("retrieves Widget from the repository by ID")
    fun widgetById(
        @GraphQLIgnore @Autowired repository: WidgetRepository,
        @GraphQLDescription("The special ingredient") id: Int
    ): Widget? = repository.findWidget(id)

    @GraphQLDescription("retrieves all widgets from repository")
    fun availableWidgets(@GraphQLIgnore @Autowired repository: WidgetRepository): List<Widget> = repository.retrieveAllWidgets()
}

@Service
class WidgetRepository {
    private val widgets = mapOf(
        1 to Widget(1, "Example Widget"),
        2 to Widget(2, "Example Widget")
    )

    fun findWidget(id: Int): Widget? = widgets[id]

    fun retrieveAllWidgets(): List<Widget> = widgets.values.toList()
}
