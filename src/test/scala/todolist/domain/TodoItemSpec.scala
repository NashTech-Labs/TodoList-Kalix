package todolist.domain


import com.google.protobuf.empty.Empty
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TodoItemSpec
  extends AnyWordSpec
    with Matchers {

  "TodoItem" must {

    "handle command AddItem" in {
      val service = TodoItemTestKit(new TodoItem(_))
      val result = service.addItem(todolist.api.TodoItem(
        itemId = "1",
        title = "Scala Test",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      ))
      val reply = result.reply
      reply shouldBe Empty.defaultInstance
    }

    "handle command GetItem" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      val service = TodoItemTestKit(new TodoItem(_))
      service.addItem(item)
      val result = service.getItemById(todolist.api.GetItemByIdRequest(itemId = "1"))
      val reply = result.reply
      reply shouldBe item
    }

    "handle command DeleteItem" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      val service = TodoItemTestKit(new TodoItem(_))
      service.addItem(item)
      val result = service.deleteItem(todolist.api.DeleteItemRequest(itemId = "1"))
      val reply = result.reply
      reply shouldBe Empty.defaultInstance
    }

    "handle command UpdateItem" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )

      val updateItemRequest = todolist.api.UpdateItemRequest(
        itemId = "1",
        title = Some("Kalix"),
        description = Some("Learning Scala Test in Kalix")
      )

      val updatedItem = todolist.api.TodoItem(
        itemId = "1",
        title = "Kalix",
        description = "Learning Scala Test in Kalix",
        addedBy = "prakhar.singh@knoldus.com"
      )
      val service = TodoItemTestKit(new TodoItem(_))
      service.addItem(item)
      val result = service.updateItem(updateItemRequest)
      // result.updatedState
      val reply = result.reply
      reply shouldBe updatedItem
    }

    "handle command MarkAsDone" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      val service = TodoItemTestKit(new TodoItem(_))
      service.addItem(item)
      val result = service.markAsDone(todolist.api.MarkAsDoneRequest(itemId = "1"))
      val reply = result.reply
      assert(reply.done)
    }
  }
}
