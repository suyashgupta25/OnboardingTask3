package de.appsfactory.todoservice.domain.todo;

import de.appsfactory.todoservice.error.exception.InvalidParameterException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import org.apache.commons.lang.StringUtils;

@Value
public class TodoTitle {

    @NonNull
    @Getter
    private final String title;

    public static TodoTitle from(@NonNull String value) {
        if(isAValidTitle(value)) {
            return new TodoTitle(value);
        } else {
            throw new InvalidParameterException(Todo.class, "title", value);
        }
    }

    private static boolean isAValidTitle(@NonNull String title){
        return StringUtils.isNotEmpty(title);
    }
}
