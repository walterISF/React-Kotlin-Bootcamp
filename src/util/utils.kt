package util

import org.w3c.dom.events.Event

val Event.value: String
    get() = this.currentTarget.asDynamic().value as String

private val enUSLanguage = mapOf(
        "Hello Santa" to "Hello Santa 2",
        "What needs to be done?" to "Ki sa ki bezwen fèt?",
        "todos" to "tout"
)

fun String.translate(): String
{
    return enUSLanguage[this]?: "***$this"
}