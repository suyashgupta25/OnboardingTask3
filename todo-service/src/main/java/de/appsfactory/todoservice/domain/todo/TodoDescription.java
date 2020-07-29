package de.appsfactory.todoservice.domain.todo;

import de.appsfactory.todoservice.error.exception.InvalidParameterException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import org.apache.commons.lang.StringUtils;

@Value
public class TodoDescription {

    @NonNull
    @Getter
    private final String description;

    public static TodoDescription from(@NonNull String value) {
        if(isAValidDescription(value)) {
            return new TodoDescription(value);
        } else {
            throw new InvalidParameterException(Todo.class, "description", value);
        }
    }

    private static boolean isAValidDescription(@NonNull String description){
        return StringUtils.isNotEmpty(description);
    }
}
