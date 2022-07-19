# kalix-todolist
This project demonstrates using Value Entities in Kalix.
It is a Todo list application. Item is represented as follows:
```
message TodoItemState {
  string item_id = 1;
  string title = 2;
  string description = 3;
  string added_by = 4;
  bool done = 5;

}
```
### The app allows user to perform following functions: 

1. Add an Item:

2. Get the Item based on **added_by** field

3. Update the Item
  - An item which marked as done cannot be updated
  
4. Delete the Item
  - An item which is marked as done cannot be deleted
  
5. Mark an Item as done

### The app also provides a view which gets all the items added

## Steps to run

To build and publish the container image and then deploy the service, follow these steps:

1. Use the Docker/publish task to build the container image and publish it to your container registry. At the end of this command sbt will show you the container image URL you’ll need in the next part of this process.
    ```
    sbt Docker/publish -Ddocker.username=[your-docker-hub-username]`
    ```
2. If you haven’t done so yet, sign in to your Kalix account. If this is your first time using Kalix, this will let you register an account, create your first project, and set this project as the default.
    ```
    kalix auth login
    ```
3. Deploy the service with the published container image from above:
    ```
    kalix service deploy <service name> <container image>
    ```
4. You can verify the status of the deployed service using:
    ```
    kalix service list
    ```
5. Invoke your service

6. Once the service has started successfully, you can start a proxy locally to access the service:
    ```
    kalix service proxy <service name> --grpcui
    ```
The --grpcui option also starts and opens a gRPC web UI for exploring and invoking the service (available at http://127.0.0.1:8080/ui/).

Or you can use postman and other option to hit the above-mentioned endpoints with correspondence requests.
