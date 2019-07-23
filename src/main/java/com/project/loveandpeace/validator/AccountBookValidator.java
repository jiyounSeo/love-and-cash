package com.project.loveandpeace.validator;

import com.project.loveandpeace.common.validator.AbstractValidator;
import com.project.loveandpeace.domain.AccountBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class AccountBookValidator extends AbstractValidator<AccountBook> {

    private static final String TYPE = "type";
    private static final String INCOME_CATEGORY = "incomeCategory";
    private static final String OUTGOING_CATEGORY = "outgoingCategory";
    private static final String ACCOUNT_BOOK_ID = "id";
    private static final String OBJECT_TYPE = "objectType";
    private static final String PRICE= "price";
    private static final String DESCRIPTION= "description";
    private static final String USING_DATE= "usingDate";

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountBook.class.isAssignableFrom(clazz);
    }

    @Override
    protected void onCreate(AccountBook target, Errors errors) {
        validateCommon(target, errors);
    }

    @Override
    protected void onUpdate(AccountBook target, Errors errors) {
        validateEmpty(errors, ACCOUNT_BOOK_ID, target.getId());
        validateCommon(target, errors);
    }

    private void validateCommon(AccountBook target, Errors errors) {
        validateEmpty(errors, OBJECT_TYPE, target.getObjectType());
        validateEmpty(errors, PRICE, target.getPrice());
        validateEmpty(errors, USING_DATE, target.getUsingDate());
        validateStringIntegrally(errors, DESCRIPTION, "", target.getDescription(), false, 100);
        validateTypeAndCategory(target, errors);
    }

    private void validateTypeAndCategory(AccountBook target, Errors errors) {
       validateEmpty(errors, TYPE, target.getType());

        if (target.isIncomeType()) {
            validateEmpty(errors, INCOME_CATEGORY, target.getIncomeCategory());
        } else {
            validateEmpty(errors, OUTGOING_CATEGORY, target.getOutgoingCategory());
        }
    }
}
