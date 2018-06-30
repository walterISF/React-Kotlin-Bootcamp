package model

import kotlin.js.Date

data class Todo
(
    val id: Double = Date().getTime(),
    val title: String = "",
    val completed: Boolean = false
)