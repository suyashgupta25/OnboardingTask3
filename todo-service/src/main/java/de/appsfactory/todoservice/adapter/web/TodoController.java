package de.appsfactory.todoservice.adapter.web;

import de.appsfactory.todoservice.adapter.web.response.WebTodo;
import de.appsfactory.todoservice.application.todo.port.in.CreateOrUpdateTodoUseCase;
import de.appsfactory.todoservice.application.todo.port.in.DeleteTodoUseCase;
import de.appsfactory.todoservice.application.todo.port.in.GetTodoQuery;
import de.appsfactory.todoservice.domain.todo.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static de.appsfactory.todoservice.adapter.web.pages.Mappings.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = DOMAIN_TODO)
class TodoController {

    private final GetTodoQuery getTodoQuery;
    private final CreateOrUpdateTodoUseCase createOrUpdateTodoUseCase;
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final TodoControllerMapper todoControllerMapper;

    @RequestMapping(value = DOMAIN_TODO_GET_ALL, method = RequestMethod.GET)
    public String getUser(Model model) {
        log.debug("Getting all todos");
        List<Todo> todos = getTodoQuery.getTodos();
        List<WebTodo> todoList = todos.stream()
                .map(todoControllerMapper::mapToWebTodo)
                .collect(Collectors.toList());
        model.addAttribute("todoList", todoList);
        return PAGE_TODO_ALL;
    }

    @RequestMapping(value = DOMAIN_TODO_ADD, method = RequestMethod.GET)
    public String addTodo(ModelMap view) {
        log.debug("Add a new todo");
        WebTodo webTodo = new WebTodo();
        view.addAttribute("webTodo", webTodo);
        return PAGE_TODO_ADD;
    }

    @RequestMapping(value = DOMAIN_TODO_ADD, method = RequestMethod.POST)
    public String createTodo(@Valid WebTodo webTodo, BindingResult result, ModelMap view) {
        if (result.hasErrors()) {
            log.debug("Error while creating a new todo");
            return PAGE_TODO_ADD;
        }
        log.debug("Creating a new todo");
        createOrUpdateTodoUseCase.create(todoControllerMapper.mapToDomainTodo(webTodo));
        return redirectToAllTodos();
    }

    private String redirectToAllTodos() {
        return "redirect:" + DOMAIN_TODO + DOMAIN_TODO_GET_ALL;
    }

    @RequestMapping(value = {DOMAIN_TODO_EDIT + "/{id}",}, method = RequestMethod.GET)
    public String editTodo(ModelMap view, @PathVariable long id) {
        log.debug("Creating a editing todo");
        Todo todoById = getTodoQuery.getTodoById(new Todo.TodoId(id));
        view.addAttribute("webTodo", todoControllerMapper.mapToWebTodo(todoById));
        return PAGE_TODO_EDIT;
    }

    @RequestMapping(value = {DOMAIN_TODO_EDIT + "/{id}"}, method = RequestMethod.POST)
    public String updateTodo(@Valid WebTodo webTodo, BindingResult result) {
        log.debug("Creating a updating todo");
        if (result.hasErrors()) {
            return PAGE_TODO_EDIT;
        }
        Todo todo = todoControllerMapper.mapToDomainTodo(webTodo);
        createOrUpdateTodoUseCase.update(todo);
        return redirectToAllTodos();
    }

    @RequestMapping(value = {DOMAIN_TODO_DELETE + "/{id}"}, method = RequestMethod.GET)
    public String deleteTodo(@PathVariable long id) {
        deleteTodoUseCase.deleteTodo(new Todo.TodoId(id));
        return redirectToAllTodos();
    }
}
