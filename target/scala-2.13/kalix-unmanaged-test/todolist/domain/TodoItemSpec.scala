package todolist.domain

import com.google.protobuf.empty.Empty
import kalix.scalasdk.testkit.ValueEntityResult
import kalix.scalasdk.valueentity.ValueEntity
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import todolist.api

class TodoItemSpec
    extends AnyWordSpec
    with Matchers {

  "TodoItem" must {

    "have example test that can be removed" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = service.someOperation(SomeRequest)
      // verify the reply
      // val reply = result.getReply()
      // reply shouldBe expectedReply
      // verify the final state after the command
      // service.currentState() shouldBe expectedState
    }

    "handle command AddItem" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // val result = service.addItem(api.TodoItem(...))
    }

    "handle command GetItemById" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // val result = service.getItemById(api.GetItemByIdRequest(...))
    }

    "handle command UpdateItem" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // val result = service.updateItem(api.UpdateItemRequest(...))
    }

    "handle command MarkAsDone" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // val result = service.markAsDone(api.MarkAsDoneRequest(...))
    }

    "handle command DeleteItem" in {
      val service = TodoItemTestKit(new TodoItem(_))
      pending
      // val result = service.deleteItem(api.DeleteItemRequest(...))
    }

  }
}
