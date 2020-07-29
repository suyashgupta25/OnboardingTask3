package de.appsfactory.todoservice.application.todo.port.in;

import de.appsfactory.todoservice.domain.todo.Todo;

import java.util.List;

public interface GetTodoQuery {

    List<Todo> getTodos();

    Todo getTodoById(Todo.TodoId todoId);

}
