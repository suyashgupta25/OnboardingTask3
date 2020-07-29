package de.appsfactory.todoservice.application.todo.port.out;

import de.appsfactory.todoservice.domain.todo.Todo;

import java.util.List;

public interface LoadTodoPort {

    List<Todo> loadTodos();

    Todo loadTodoById(Todo.TodoId todoId);

    Boolean todoExists(Todo.TodoId todoId);

}
