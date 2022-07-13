package todolist.domain

import com.google.protobuf.empty.Empty
import kalix.scalasdk.Metadata
import kalix.scalasdk.testkit.ValueEntityResult
import kalix.scalasdk.testkit.impl.TestKitValueEntityCommandContext
import kalix.scalasdk.testkit.impl.TestKitValueEntityContext
import kalix.scalasdk.testkit.impl.ValueEntityResultImpl
import kalix.scalasdk.valueentity.ValueEntity
import kalix.scalasdk.valueentity.ValueEntityContext
import todolist.api

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * TestKit for unit testing TodoItem
 */
object TodoItemTestKit {
  /**
   * Create a testkit instance of TodoItem
   * @param entityFactory A function that creates a TodoItem based on the given ValueEntityContext,
   *                      a default entity id is used.
   */
  def apply(entityFactory: ValueEntityContext => TodoItem): TodoItemTestKit =
    apply("testkit-entity-id", entityFactory)

  /**
   * Create a testkit instance of TodoItem with a specific entity id.
   */
  def apply(entityId: String, entityFactory: ValueEntityContext => TodoItem): TodoItemTestKit =
    new TodoItemTestKit(entityFactory(new TestKitValueEntityContext(entityId)), entityId)
}

/**
 * TestKit for unit testing TodoItem
 */
final class TodoItemTestKit private(entity: TodoItem, entityId: String) {
  private var state: TodoItemState = entity.emptyState

  /**
   * @return The current state of the TodoItem under test
   */
  def currentState(): TodoItemState =
    state

  private def interpretEffects[Reply](effect: ValueEntity.Effect[Reply]): ValueEntityResult[Reply] = {
    val result = new ValueEntityResultImpl[Reply](effect)
    if (result.stateWasUpdated)
      this.state = result.updatedState.asInstanceOf[TodoItemState]
    result
  }

  def addItem(command: api.TodoItem, metadata: Metadata = Metadata.empty): ValueEntityResult[Empty] = {
    entity._internalSetCommandContext(Some(new TestKitValueEntityCommandContext(entityId = entityId, metadata = metadata)))
    val effect = entity.addItem(state, command)
    interpretEffects(effect)
  }

  def getItemById(command: api.GetItemByIdRequest, metadata: Metadata = Metadata.empty): ValueEntityResult[api.TodoItem] = {
    entity._internalSetCommandContext(Some(new TestKitValueEntityCommandContext(entityId = entityId, metadata = metadata)))
    val effect = entity.getItemById(state, command)
    interpretEffects(effect)
  }

  def updateItem(command: api.UpdateItemRequest, metadata: Metadata = Metadata.empty): ValueEntityResult[api.TodoItem] = {
    entity._internalSetCommandContext(Some(new TestKitValueEntityCommandContext(entityId = entityId, metadata = metadata)))
    val effect = entity.updateItem(state, command)
    interpretEffects(effect)
  }

  def markAsDone(command: api.MarkAsDoneRequest, metadata: Metadata = Metadata.empty): ValueEntityResult[api.TodoItem] = {
    entity._internalSetCommandContext(Some(new TestKitValueEntityCommandContext(entityId = entityId, metadata = metadata)))
    val effect = entity.markAsDone(state, command)
    interpretEffects(effect)
  }

  def deleteItem(command: api.DeleteItemRequest, metadata: Metadata = Metadata.empty): ValueEntityResult[Empty] = {
    entity._internalSetCommandContext(Some(new TestKitValueEntityCommandContext(entityId = entityId, metadata = metadata)))
    val effect = entity.deleteItem(state, command)
    interpretEffects(effect)
  }
}
