package todolist

import kalix.scalasdk.Kalix
import kalix.scalasdk.valueentity.ValueEntityContext
import kalix.scalasdk.view.ViewCreationContext
import todolist.domain.TodoItem
import todolist.domain.TodoItemProvider
import todolist.view.TodoListByNameView
import todolist.view.TodoListByNameViewProvider

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

object KalixFactory {

  def withComponents(
      createTodoItem: ValueEntityContext => TodoItem,
      createTodoListByNameView: ViewCreationContext => TodoListByNameView): Kalix = {
    val kalix = Kalix()
    kalix
      .register(TodoItemProvider(createTodoItem))
      .register(TodoListByNameViewProvider(createTodoListByNameView))
  }
}
