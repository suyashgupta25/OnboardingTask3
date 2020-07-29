package de.appsfactory.todoservice.adapter.persistence;

import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.domain.todo.TodoDescription;
import de.appsfactory.todoservice.domain.todo.TodoTitle;
import org.springframework.stereotype.Component;

@Component
class TodoMapper {

    Todo mapToDomainEntity(TodoJpaEntity entity) {
        return Todo.withId(new Todo.TodoId(entity.getId()),
                TodoTitle.from(entity.getTitle()),
                TodoDescription.from(entity.getDescription()));
    }

    TodoJpaEntity mapToJpaEntity(Todo todo) {
        Long id = todo.getId().map(Todo.TodoId::getValue).orElse(null);
        return new TodoJpaEntity(id,
                todo.getTodoTitle().getTitle(), todo.getTodoDescription().getDescription());
    }
}
