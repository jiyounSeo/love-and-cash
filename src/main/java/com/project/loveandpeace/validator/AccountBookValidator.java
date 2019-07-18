package com.project.loveandpeace.validator;

import com.project.loveandpeace.common.enumeration.SaveState;
import com.project.loveandpeace.common.validator.DomainValidator;
import com.project.loveandpeace.domain.AccountBook;
import org.springframework.validation.Errors;

public class AccountBookValidator implements DomainValidator<AccountBook> {
    @Override
    public boolean supports(Class<?> clazz) {
        return AccountBook.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(SaveState saveState, AccountBook target, Errors errors) {

    }
}
