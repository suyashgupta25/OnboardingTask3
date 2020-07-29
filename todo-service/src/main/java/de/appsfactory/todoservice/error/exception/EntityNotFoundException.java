package de.appsfactory.todoservice.error.exception;


import org.apache.commons.lang.StringUtils;

import java.util.Map;

import static de.appsfactory.todoservice.error.exception.ErrorMessageConvert.toMap;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, String... searchParamsMap) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), toMap(String.class, String.class, searchParamsMap)));
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return StringUtils.capitalize(entity) +
                " was not found for parameters " +
                searchParams;
    }
}
