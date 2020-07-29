package de.appsfactory.todoservice.application.todo.service;

import de.appsfactory.todoservice.application.todo.port.in.DeleteTodoUseCase;
import de.appsfactory.todoservice.application.todo.port.out.DeleteTodoPort;
import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
class DeleteTodoService implements DeleteTodoUseCase {

    private final DeleteTodoPort deleteTodoPort;

    @Override
    public void deleteTodo(Todo.TodoId todoId) {
        if (!deleteTodoPort.todoExists(todoId)) {
            log.error("id not found:"+todoId.getValue());
            throw new EntityNotFoundException(Todo.class, "id", Objects.toString(todoId.getValue()));
        }
        deleteTodoPort.deleteTodo(todoId);
    }
}
