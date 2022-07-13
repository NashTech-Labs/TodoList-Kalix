package todolist.domain

import com.google.protobuf.empty.Empty
import kalix.scalasdk.valueentity.{ValueEntity, ValueEntityContext}
import todolist.api
import todolist.api.{DeleteItemRequest, GetItemByIdRequest, MarkAsDoneRequest, UpdateItemRequest}

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class TodoItem(context: ValueEntityContext) extends AbstractTodoItem {
  override def emptyState: TodoItemState = TodoItemState()
    // throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def addItem(currentState: TodoItemState, item: api.TodoItem): ValueEntity.Effect[Empty] = {
    // effects.error("The command handler for `AddItem` is not implemented, yet")
    effects.updateState(convertToDomain(item)).thenReply(Empty.defaultInstance)
  }


  def convertToDomain(item: api.TodoItem): TodoItemState = {
    TodoItemState(
      itemId = item.itemId,
      title = item.title,
      description = item.description,
      addedBy = item.addedBy,
      done = item.done
    )
  }

  def convertToDomain(item: api.UpdateItemRequest, currentState: TodoItemState): TodoItemState = {
    TodoItemState(
      itemId = item.itemId,
      title = item.title.getOrElse(currentState.title),
      description = item.description.getOrElse(currentState.description),
      addedBy = currentState.addedBy,
      done = currentState.done
    )
  }



  override def getItemById(currentState: TodoItemState, getItemByIdRequest: GetItemByIdRequest): ValueEntity.Effect[api.TodoItem] = {
    if(currentState.itemId == "") effects.error(s"Item with ${getItemByIdRequest.itemId} not found")
    else effects.reply(convertToApi(currentState))
  }

  def convertToApi(item: TodoItemState): api.TodoItem = {
    api.TodoItem (
      itemId = item.itemId,
      title = item.title,
      description = item.description,
      addedBy = item.addedBy,
      done = item.done
    )
  }

  def convertToApi(item: UpdateItemRequest, currentState: TodoItemState): api.TodoItem = {
    api.TodoItem (
      itemId = item.itemId,
      title = item.title.getOrElse(currentState.title),
      description = item.description.getOrElse(currentState.description),
      addedBy = currentState.addedBy,
      done = currentState.done
    )
  }

  override def updateItem(currentState: TodoItemState, updateItemRequest: UpdateItemRequest): ValueEntity.Effect[api.TodoItem] = {
    if(currentState.itemId == "") effects.error(s"Item with ${updateItemRequest.itemId} not found")
    else if(currentState.done) effects.error(s"Item cannot be completed post completion")
    else effects
      .updateState(convertToDomain(updateItemRequest, currentState))
      .thenReply(convertToApi(updateItemRequest, currentState))
  }

  override def markAsDone(currentState: TodoItemState, markAsDoneRequest: MarkAsDoneRequest): ValueEntity.Effect[api.TodoItem] = {
    if(currentState.itemId == "") effects.error(s"Item with ${markAsDoneRequest.itemId} not found")
    else {
      val updatedState = currentState.copy(done = true)
      effects
        .updateState(updatedState)
        .thenReply(convertToApi(updatedState))
    }
  }

  override def deleteItem(currentState: TodoItemState, deleteItemRequest: DeleteItemRequest): ValueEntity.Effect[Empty] = {
    if(currentState.itemId == "") effects.error(s"Item with ${deleteItemRequest.itemId} not found")
    else if(currentState.done) effects.error("Cannot delete an item post completion")
    else effects
      .deleteState
      .thenReply(Empty.defaultInstance)
  }
}

