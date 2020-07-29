package de.appsfactory.todoservice.adapter.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class WebTodo {

    private Long id;

    @NonNull
    @Size(min = 3, max = 40, message = "The title must be between {min} and {max} characters long")
    private String title;

    @NonNull
    @Size(min = 3, max = 150, message = "The description must be between {min} and {max} characters long")
    private String description;

    public WebTodo() {
        title = "";
        description = "";
    }
}
