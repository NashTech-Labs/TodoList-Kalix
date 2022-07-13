package todolist.view

import kalix.javasdk.impl.view.UpdateHandlerNotFound
import kalix.scalasdk.impl.view.ViewRouter
import kalix.scalasdk.view.View
import todolist.domain.TodoItemState

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

class TodoListByNameViewRouter(view: TodoListByNameView)
  extends ViewRouter[TodoItemState, TodoListByNameView](view) {

  override def handleUpdate(
      eventName: String,
      state: TodoItemState,
      event: Any): View.UpdateEffect[TodoItemState] = {

    eventName match {
      

      case _ =>
        throw new UpdateHandlerNotFound(eventName)
    }
  }

}
