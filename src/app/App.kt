package app

import model.Todo
import react.*
import react.dom.section

class App : RComponent<RProps, App.State>() {

    init
    {
        state.todos = loadTodos()
    }

    fun loadTodos(): List<Todo>
    {
        return listOf(
                Todo(id = 1.0, title = "Joao do Gás"),
                Todo(id = 2.0, title = "Zinbabuwe")
        )
    }

    fun createTodo(todo: Todo)
    {
        val oldTodos = state.todos
        setState {
            todos = oldTodos + todo
        }
    }

    fun removeTodo(todo: Todo)
    {
        val oldTodos = state.todos
        setState {
            todos = oldTodos - todo
        }
    }

    fun updateTodo(todo: Todo)
    {
        val newTodos = state.todos.map { oldTodos ->
            if(todo.id == oldTodos.id)
            {
                todo
            }
            else
            {
                oldTodos
            }
        }

        setState {
            todos = newTodos
        }
    }

    override fun RBuilder.render()
    {
        section(classes = "todoapp")
        {
            headerInput(::createTodo)
            section(classes = "main") {
                todoList(state.todos, ::removeTodo, ::updateTodo)
            }


        }
    }

    class State(var todos: List<Todo>) : RState
}
fun RBuilder.app() = child(App::class) {}
