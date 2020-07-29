package de.appsfactory.todoservice.application.todo.port.out;

import de.appsfactory.todoservice.domain.todo.Todo;

public interface DeleteTodoPort {

    void deleteTodo(Todo.TodoId todoId);

    Boolean todoExists(Todo.TodoId todoId);

}
