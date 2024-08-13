package io.github.aaiezza.graphql

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import io.github.aaiezza.widget.repository.WidgetRepository

val widgetRepository = WidgetRepository()
val widgetQuery = widgetRepository.WidgetQuery()
val widgetMutation = widgetRepository.WidgetMutation()
val schema
    get() = toSchema(
        config = SchemaGeneratorConfig(listOf("io.github.aaiezza")),
        queries = listOf(TopLevelObject(widgetQuery)),
        mutations = listOf(TopLevelObject(widgetMutation))
    )
