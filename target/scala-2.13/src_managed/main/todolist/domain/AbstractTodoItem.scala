package todolist.domain

import com.google.protobuf.empty.Empty
import kalix.scalasdk.valueentity.ValueEntity
import todolist.Components
import todolist.ComponentsImpl
import todolist.api

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

abstract class AbstractTodoItem extends ValueEntity[TodoItemState] {

  def components: Components =
    new ComponentsImpl(commandContext())

  def addItem(currentState: TodoItemState, todoItem: api.TodoItem): ValueEntity.Effect[Empty]

  def getItemById(currentState: TodoItemState, getItemByIdRequest: api.GetItemByIdRequest): ValueEntity.Effect[api.TodoItem]

  def updateItem(currentState: TodoItemState, updateItemRequest: api.UpdateItemRequest): ValueEntity.Effect[api.TodoItem]

  def markAsDone(currentState: TodoItemState, markAsDoneRequest: api.MarkAsDoneRequest): ValueEntity.Effect[api.TodoItem]

  def deleteItem(currentState: TodoItemState, deleteItemRequest: api.DeleteItemRequest): ValueEntity.Effect[Empty]

}

