package de.appsfactory.todoservice.application.todo.port.in;

import de.appsfactory.todoservice.domain.todo.Todo;

public interface DeleteTodoUseCase {
    void deleteTodo(Todo.TodoId todoId);
}
