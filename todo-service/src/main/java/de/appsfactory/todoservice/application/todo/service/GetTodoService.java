package de.appsfactory.todoservice.application.todo.service;

import de.appsfactory.todoservice.application.todo.port.in.GetTodoQuery;
import de.appsfactory.todoservice.application.todo.port.out.LoadTodoPort;
import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
class GetTodoService implements GetTodoQuery {

    private final LoadTodoPort loadTodoPort;

    @Override
    public List<Todo> getTodos() {
        return loadTodoPort.loadTodos();
    }

    @Override
    public Todo getTodoById(Todo.TodoId todoId) {
        if(loadTodoPort.todoExists(todoId)) {
            return loadTodoPort.loadTodoById(todoId);
        } else {
            throw new EntityNotFoundException(Todo.class, "id", Objects.toString(todoId.getValue()));
        }
    }
}
