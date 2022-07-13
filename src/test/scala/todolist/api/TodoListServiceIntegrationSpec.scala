package todolist.api

import com.google.protobuf.empty.Empty
import kalix.scalasdk.testkit.KalixTestKit
import org.scalatest.BeforeAndAfterAll
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec
import todolist._

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class TodoListServiceIntegrationSpec
    extends AnyWordSpec
    with Matchers
    with BeforeAndAfterAll
    with ScalaFutures {

  implicit private val patience: PatienceConfig =
    PatienceConfig(Span(5, Seconds), Span(500, Millis))

  private val testKit = KalixTestKit(Main.createKalix()).start()

  private val client = testKit.getGrpcClient(classOf[TodoListService])

  "TodoListService" must {

    "handle command AddItem" in {
      val itemToBeAdded = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      val result = client.addItem(itemToBeAdded)
      val reply = result.futureValue
      reply shouldBe Empty.defaultInstance
    }

    "handle command GetItem" in {
      val itemToBeAdded = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      client.addItem(itemToBeAdded)
      val result = client.getItemById(api.GetItemByIdRequest("1"))
      val reply = result.futureValue
      reply shouldBe itemToBeAdded
    }

    "handle command UpdateItem" in {
      val itemToBeAdded = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )

      val updateItemRequest = todolist.api.UpdateItemRequest(
        itemId = "1",
        title = Some("Kalix"),
        description = Some("Learning Integration Testing in Kalix")
      )

      val updatedItem = todolist.api.TodoItem(
        itemId = "1",
        title = "Kalix",
        description = "Learning Integration Testing in Kalix",
        addedBy = "prakhar.singh@knoldus.com"
      )

      client.addItem(itemToBeAdded)
      val result = client.updateItem(updateItemRequest)
      val reply = result.futureValue
      reply shouldBe updatedItem
    }

    "handle command DeleteItem" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      client.addItem(item)
      val result = client.deleteItem(api.DeleteItemRequest("1"))
      val reply = result.futureValue
      reply shouldBe Empty.defaultInstance
    }

    "handle command MarkAsDone" in {
      val item = todolist.api.TodoItem(
        itemId = "1",
        title = "Scala",
        description = "Learning Scala Test",
        addedBy = "prakhar.singh@knoldus.com"
      )
      client.addItem(item)
      val result = client.markAsDone(api.MarkAsDoneRequest("1"))
      val reply = result.futureValue
      assert(reply.done)
    }
  }


  override def afterAll(): Unit = {
    testKit.stop()
    super.afterAll()
  }
}
