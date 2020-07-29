package de.appsfactory.todoservice.adapter.web;

import de.appsfactory.todoservice.adapter.web.response.WebTodo;
import de.appsfactory.todoservice.domain.todo.Todo;
import de.appsfactory.todoservice.domain.todo.TodoDescription;
import de.appsfactory.todoservice.domain.todo.TodoTitle;
import org.springframework.stereotype.Component;

@Component
public class TodoControllerMapper {

    WebTodo mapToWebTodo(Todo todo) {
        Long id = todo.getId().map(Todo.TodoId::getValue).orElse(null);
        return new WebTodo(id, todo.getTodoTitle().getTitle(), todo.getTodoDescription().getDescription());
    }

    Todo mapToDomainTodo(WebTodo webTodo) {
        return Todo.withId(new Todo.TodoId(webTodo.getId()), TodoTitle.from(webTodo.getTitle()), TodoDescription.from(webTodo.getDescription()));
    }
}
