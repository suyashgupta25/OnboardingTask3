package de.appsfactory.todoservice.application.todo.port.out;


import de.appsfactory.todoservice.domain.todo.Todo;

public interface CreateOrUpdateTodoPort {

    Todo create(Todo todo);

    Todo update(Todo todo);

    Boolean todoExists(Todo.TodoId todoId);
}
