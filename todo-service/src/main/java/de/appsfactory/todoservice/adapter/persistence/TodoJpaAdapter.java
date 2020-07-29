package de.appsfactory.todoservice.adapter.persistence;

import de.appsfactory.todoservice.application.todo.port.out.CreateOrUpdateTodoPort;
import de.appsfactory.todoservice.application.todo.port.out.DeleteTodoPort;
import de.appsfactory.todoservice.application.todo.port.out.LoadTodoPort;
import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
@Slf4j
class TodoJpaAdapter implements LoadTodoPort, CreateOrUpdateTodoPort, DeleteTodoPort {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public List<Todo> loadTodos() {
        List<TodoJpaEntity> all = todoRepository.findAll();
        return all.stream()
                .map(countryEntity -> todoMapper.mapToDomainEntity(countryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Todo loadTodoById(Todo.TodoId todoId) {
        Optional<TodoJpaEntity> todoById = todoRepository.findById(todoId.getValue());
        if(todoById.isPresent()) {
            return todoMapper.mapToDomainEntity(todoById.get());
        } else {
            throw new EntityNotFoundException(Todo.class, "id", Objects.toString(todoId.getValue()));
        }
    }

    @Override
    public Todo create(Todo todo) {
        TodoJpaEntity todoJpaEntity = todoMapper.mapToJpaEntity(todo);
        TodoJpaEntity savedTodo = todoRepository.saveAndFlush(todoJpaEntity);
        return todoMapper.mapToDomainEntity(savedTodo);
    }

    @Override
    public Todo update(Todo todo) {
        TodoJpaEntity todoJpaEntity = todoMapper.mapToJpaEntity(todo);
        TodoJpaEntity savedTodo = todoRepository.saveAndFlush(todoJpaEntity);
        return todoMapper.mapToDomainEntity(savedTodo);
    }

    @Override
    public void deleteTodo(Todo.TodoId todoId) {
        todoRepository.deleteById(todoId.getValue());
    }

    @Override
    public Boolean todoExists(Todo.TodoId todoId) {
        return todoRepository.existsById(todoId.getValue());
    }
}
