package de.appsfactory.todoservice.application.todo.service;

import de.appsfactory.todoservice.application.todo.port.in.CreateOrUpdateTodoUseCase;
import de.appsfactory.todoservice.application.todo.port.out.CreateOrUpdateTodoPort;
import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
class CreateOrUpdateTodoService implements CreateOrUpdateTodoUseCase {

    private final CreateOrUpdateTodoPort createOrUpdateTodoPort;

    @Override
    public Todo create(Todo todo) {
        return createOrUpdateTodoPort.create(todo);
    }

    @Override
    public Todo update(Todo todo) {
        if (todo.getId().isPresent() && !createOrUpdateTodoPort.todoExists(todo.getId().get())) {
            Todo.TodoId todoId = todo.getId().get();
            log.error("id not found:"+todoId.getValue());
            throw new EntityNotFoundException(Todo.class, "id", Objects.toString(todoId.getValue()));
        }
        return createOrUpdateTodoPort.update(todo);
    }
}
