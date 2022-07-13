package todolist.view

import com.google.protobuf.Descriptors
import com.google.protobuf.EmptyProto
import kalix.javasdk.impl.view.UpdateHandlerNotFound
import kalix.scalasdk.impl.view.ViewRouter
import kalix.scalasdk.view.View
import kalix.scalasdk.view.ViewCreationContext
import kalix.scalasdk.view.ViewOptions
import kalix.scalasdk.view.ViewProvider
import todolist.domain.TodoItemState

import scala.collection.immutable.Seq

// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

object TodoListByNameViewProvider {
  def apply(viewFactory: ViewCreationContext => TodoListByNameView): TodoListByNameViewProvider =
    new TodoListByNameViewProvider(viewFactory, viewId = "TodoListByName", options = ViewOptions.defaults)
}

class TodoListByNameViewProvider private(
    viewFactory: ViewCreationContext => TodoListByNameView,
    override val viewId: String,
    override val options: ViewOptions)
  extends ViewProvider[TodoItemState, TodoListByNameView] {

  /**
   * Use a custom view identifier. By default, the viewId is the same as the proto service name.
   * A different identifier can be needed when making rolling updates with changes to the view definition.
   */
  def withViewId(viewId: String): TodoListByNameViewProvider =
    new TodoListByNameViewProvider(viewFactory, viewId, options)

  def withOptions(newOptions: ViewOptions): TodoListByNameViewProvider =
    new TodoListByNameViewProvider(viewFactory, viewId, newOptions)

  override final def serviceDescriptor: Descriptors.ServiceDescriptor =
    TodolistViewProto.javaDescriptor.findServiceByName("TodoListByName")

  override final def newRouter(context: ViewCreationContext): TodoListByNameViewRouter =
    new TodoListByNameViewRouter(viewFactory(context))

  override final def additionalDescriptors: Seq[Descriptors.FileDescriptor] =
    TodolistViewProto.javaDescriptor ::
    Nil
}
