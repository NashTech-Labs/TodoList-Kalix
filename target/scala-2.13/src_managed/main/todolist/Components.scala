package todolist

import kalix.scalasdk.DeferredCall


// This code is managed by Kalix tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

/**
 * Not intended for user extension, provided through generated implementation
 */
trait Components {
 import Components._

 def todoItem: TodoItemCalls

}

object Components{

 trait TodoItemCalls {
   def addItem(command: _root_.todolist.api.TodoItem): DeferredCall[_root_.todolist.api.TodoItem, _root_.com.google.protobuf.empty.Empty]

   def getItemById(command: _root_.todolist.api.GetItemByIdRequest): DeferredCall[_root_.todolist.api.GetItemByIdRequest, _root_.todolist.api.TodoItem]

   def updateItem(command: _root_.todolist.api.UpdateItemRequest): DeferredCall[_root_.todolist.api.UpdateItemRequest, _root_.todolist.api.TodoItem]

   def markAsDone(command: _root_.todolist.api.MarkAsDoneRequest): DeferredCall[_root_.todolist.api.MarkAsDoneRequest, _root_.todolist.api.TodoItem]

   def deleteItem(command: _root_.todolist.api.DeleteItemRequest): DeferredCall[_root_.todolist.api.DeleteItemRequest, _root_.com.google.protobuf.empty.Empty]

 }

}
