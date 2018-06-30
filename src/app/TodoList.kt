package app

import model.Todo
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.label
import react.dom.li
import react.dom.ul

class TodoList : RComponent<TodoList.Props, RState>() {

    override fun RBuilder.render()
    {
        ul(classes = "todo-list")
        {
            props.todos.mapIndexed{ index, todo ->
                val classes = when {
                    todo.completed -> "completed"
                    else -> ""
                }
                li(classes = classes) {
                    todoItem(todo, props.removeTodo, props.updateTodo)
                }
            }
        }

    }

    class Props(var todos:List<Todo>, var removeTodo: (Todo) -> Unit, var updateTodo: (Todo) -> Unit) : RProps

}
fun RBuilder.todoList(todos: List<Todo>, removeTodo:  (Todo) -> Unit, updateTodo: (Todo) -> Unit) = child(TodoList::class) {
    attrs.todos = todos
    attrs.removeTodo = removeTodo
    attrs.updateTodo = updateTodo
}
