package de.appsfactory.todoservice.application.todo.port.in;

import de.appsfactory.todoservice.domain.todo.Todo;

public interface CreateOrUpdateTodoUseCase {

    Todo create(Todo todo);

    Todo update(Todo todo);

}
