package todolist

import kalix.scalasdk.Context
import kalix.scalasdk.DeferredCall
import kalix.scalasdk.Metadata
import kalix.scalasdk.impl.InternalContext
import kalix.scalasdk.impl.ScalaDeferredCallAdapter


// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for direct instantiation, called by generated code, use Action.components() to access
 */
final class ComponentsImpl(context: InternalContext) extends Components {

  def this(context: Context) =
    this(context.asInstanceOf[InternalContext])

  private def getGrpcClient[T](serviceClass: Class[T]): T =
    context.getComponentGrpcClient(serviceClass)

 @Override
 override def todoItem: Components.TodoItemCalls =
   new TodoItemCallsImpl();


 private final class TodoItemCallsImpl extends Components.TodoItemCalls {
   override def addItem(command: _root_.todolist.api.TodoItem): DeferredCall[_root_.todolist.api.TodoItem, _root_.com.google.protobuf.empty.Empty] =
     ScalaDeferredCallAdapter(
       command,
       Metadata.empty,
       "todolist.api.TodoListService",
       "AddItem",
       () => getGrpcClient(classOf[_root_.todolist.api.TodoListService]).addItem(command)
     )
   override def getItemById(command: _root_.todolist.api.GetItemByIdRequest): DeferredCall[_root_.todolist.api.GetItemByIdRequest, _root_.todolist.api.TodoItem] =
     ScalaDeferredCallAdapter(
       command,
       Metadata.empty,
       "todolist.api.TodoListService",
       "GetItemById",
       () => getGrpcClient(classOf[_root_.todolist.api.TodoListService]).getItemById(command)
     )
   override def updateItem(command: _root_.todolist.api.UpdateItemRequest): DeferredCall[_root_.todolist.api.UpdateItemRequest, _root_.todolist.api.TodoItem] =
     ScalaDeferredCallAdapter(
       command,
       Metadata.empty,
       "todolist.api.TodoListService",
       "UpdateItem",
       () => getGrpcClient(classOf[_root_.todolist.api.TodoListService]).updateItem(command)
     )
   override def markAsDone(command: _root_.todolist.api.MarkAsDoneRequest): DeferredCall[_root_.todolist.api.MarkAsDoneRequest, _root_.todolist.api.TodoItem] =
     ScalaDeferredCallAdapter(
       command,
       Metadata.empty,
       "todolist.api.TodoListService",
       "MarkAsDone",
       () => getGrpcClient(classOf[_root_.todolist.api.TodoListService]).markAsDone(command)
     )
   override def deleteItem(command: _root_.todolist.api.DeleteItemRequest): DeferredCall[_root_.todolist.api.DeleteItemRequest, _root_.com.google.protobuf.empty.Empty] =
     ScalaDeferredCallAdapter(
       command,
       Metadata.empty,
       "todolist.api.TodoListService",
       "DeleteItem",
       () => getGrpcClient(classOf[_root_.todolist.api.TodoListService]).deleteItem(command)
     )
 }

}
