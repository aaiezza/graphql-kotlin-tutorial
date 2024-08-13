package io.github.aaiezza.widget.repository

import io.github.aaiezza.widget.Widget

class WidgetRepository {
    val widgetStorage: MutableList<Widget> = mutableListOf()
    val nextId: Int
        get() = widgetStorage.maxBy { it.id }.id + 1

    inner class WidgetQuery {
        fun widgetById(id: Int): Widget =
            // grabs widget from a data source
            widgetStorage.firstOrNull { it.id == id } ?: error("Widget (id = $id) not found.")
    }

    inner class WidgetMutation {
        fun saveWidget(value: String): Widget =
            // some logic for saving widget
            Widget(nextId, value)
                .also(widgetStorage::add)
    }
}
