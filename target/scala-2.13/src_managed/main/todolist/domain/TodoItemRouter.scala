package todolist.domain

import kalix.javasdk.impl.valueentity.ValueEntityRouter.CommandHandlerNotFound
import kalix.scalasdk.impl.valueentity.ValueEntityRouter
import kalix.scalasdk.valueentity.CommandContext
import kalix.scalasdk.valueentity.ValueEntity
import todolist.api

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * A value entity handler that is the glue between the Protobuf service <code>CounterService</code>
 * and the command handler methods in the <code>Counter</code> class.
 */
class TodoItemRouter(entity: TodoItem) extends ValueEntityRouter[TodoItemState, TodoItem](entity) {
  def handleCommand(commandName: String, state: TodoItemState, command: Any, context: CommandContext): ValueEntity.Effect[_] = {
    commandName match {
      case "AddItem" =>
        entity.addItem(state, command.asInstanceOf[api.TodoItem])

      case "GetItemById" =>
        entity.getItemById(state, command.asInstanceOf[api.GetItemByIdRequest])

      case "UpdateItem" =>
        entity.updateItem(state, command.asInstanceOf[api.UpdateItemRequest])

      case "MarkAsDone" =>
        entity.markAsDone(state, command.asInstanceOf[api.MarkAsDoneRequest])

      case "DeleteItem" =>
        entity.deleteItem(state, command.asInstanceOf[api.DeleteItemRequest])

      case _ =>
        throw new CommandHandlerNotFound(commandName)
    }
  }
}

