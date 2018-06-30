package app

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onKeyDownFunction
import model.Todo
import react.*
import react.dom.h1
import react.dom.header
import react.dom.input
import util.translate
import util.value

class HeaderInput : RComponent<HeaderInput.Props, HeaderInput.State>()
{

    override fun componentDidMount()
    {
        setState {
            title = ""
        }
    }

    override fun RBuilder.render()
    {
        header(classes = "header")
        {
            h1 {
                +"todos".translate()
            }
            input(classes = "new-todo", type = InputType.text)
            {
                attrs {
                    autoFocus = true
                    placeholder = "What needs to be done?".translate()

                    value = state.title

                    onChangeFunction = {event ->
                        val newValue = event.value

                        setState {
                            title = newValue
                        }
                    }

                    onKeyDownFunction = {KeyEvent ->
                        val key = KeyEvent.asDynamic().key as String

                        if(key === "Enter" && state.title.isNotBlank())
                        {
                            props.createTodos(Todo(title = state.title))

                            setState {
                                title = ""
                            }
                        }


                    }
                }
            }
        }
    }
    class Props(var createTodos: (Todo) -> Unit) : RProps
    class State(var title: String) : RState
}

fun RBuilder.headerInput(createTodos: (Todo) -> Unit) = child(HeaderInput::class) {
    attrs.createTodos = createTodos
}