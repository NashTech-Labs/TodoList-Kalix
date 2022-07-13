package todolist.view

import kalix.scalasdk.view.View
import todolist.domain.TodoItemState

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

abstract class AbstractTodoListByNameView extends View[TodoItemState] {

  override def emptyState: TodoItemState =
    null // emptyState is only used with transform_updates=true

  
}
