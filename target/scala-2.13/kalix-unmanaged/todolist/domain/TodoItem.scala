package todolist.domain

import com.google.protobuf.empty.Empty
import kalix.scalasdk.valueentity.ValueEntity
import kalix.scalasdk.valueentity.ValueEntityContext
import todolist.api

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class TodoItem(context: ValueEntityContext) extends AbstractTodoItem {
  override def emptyState: TodoItemState =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def addItem(currentState: TodoItemState, todoItem: api.TodoItem): ValueEntity.Effect[Empty] =
    effects.error("The command handler for `AddItem` is not implemented, yet")

  override def getItemById(currentState: TodoItemState, getItemByIdRequest: api.GetItemByIdRequest): ValueEntity.Effect[api.TodoItem] =
    effects.error("The command handler for `GetItemById` is not implemented, yet")

  override def updateItem(currentState: TodoItemState, updateItemRequest: api.UpdateItemRequest): ValueEntity.Effect[api.TodoItem] =
    effects.error("The command handler for `UpdateItem` is not implemented, yet")

  override def markAsDone(currentState: TodoItemState, markAsDoneRequest: api.MarkAsDoneRequest): ValueEntity.Effect[api.TodoItem] =
    effects.error("The command handler for `MarkAsDone` is not implemented, yet")

  override def deleteItem(currentState: TodoItemState, deleteItemRequest: api.DeleteItemRequest): ValueEntity.Effect[Empty] =
    effects.error("The command handler for `DeleteItem` is not implemented, yet")

}

