package todolist.domain

import com.google.protobuf.Descriptors
import com.google.protobuf.empty.EmptyProto
import kalix.scalasdk.valueentity.ValueEntityContext
import kalix.scalasdk.valueentity.ValueEntityOptions
import kalix.scalasdk.valueentity.ValueEntityProvider
import todolist.api

import scala.collection.immutable.Seq

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

object TodoItemProvider {
  def apply(entityFactory: ValueEntityContext => TodoItem): TodoItemProvider =
    new TodoItemProvider(entityFactory, ValueEntityOptions.defaults)
}
class TodoItemProvider private(entityFactory: ValueEntityContext => TodoItem, override val options: ValueEntityOptions)
  extends ValueEntityProvider[TodoItemState, TodoItem] {

  def withOptions(newOptions: ValueEntityOptions): TodoItemProvider =
    new TodoItemProvider(entityFactory, newOptions)

  override final val serviceDescriptor: Descriptors.ServiceDescriptor =
    api.TodolistApiProto.javaDescriptor.findServiceByName("TodoListService")

  override final val entityType = "todolist"

  override final def newRouter(context: ValueEntityContext): TodoItemRouter =
    new TodoItemRouter(entityFactory(context))

  override final val additionalDescriptors: Seq[Descriptors.FileDescriptor] =
    api.TodolistApiProto.javaDescriptor ::
    EmptyProto.javaDescriptor ::
    TodolistDomainProto.javaDescriptor :: Nil
}

