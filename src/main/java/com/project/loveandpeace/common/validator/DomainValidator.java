package com.project.loveandpeace.common.validator;

import com.project.loveandpeace.common.enumeration.SaveState;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface DomainValidator<T> extends Validator {
    boolean supports(Class<?> clazz);

    default void validate(Object target, Errors errors) {
        validate(SaveState.NEW, (T)target, errors);
    }

    void validate(SaveState saveState, T target, Errors errors);
}
