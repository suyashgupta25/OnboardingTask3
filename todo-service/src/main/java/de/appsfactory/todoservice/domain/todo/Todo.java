package de.appsfactory.todoservice.domain.todo;

import lombok.*;

import java.util.Optional;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {

    private final TodoId id;

    @Getter
    @NonNull
    private final TodoTitle todoTitle;

    @Getter
    @NonNull
    private final TodoDescription todoDescription;

    public static Todo withId(TodoId id,
                              TodoTitle todoTitle,
                              TodoDescription todoDescription) {
        return new Todo(id, todoTitle, todoDescription);
    }

    public static Todo withoutId(TodoTitle todoTitle,
                                 TodoDescription todoDescription) {
        return new Todo(null, todoTitle, todoDescription);
    }

    public Optional<TodoId> getId(){
        return Optional.ofNullable(this.id);
    }

    @Value
    public static class TodoId {
        private Long value;
    }
}
