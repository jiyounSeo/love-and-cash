package com.project.loveandpeace.common.validator;

import com.google.common.collect.Sets;
import com.project.loveandpeace.common.enumeration.SaveState;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractValidator<T> implements DomainValidator<T> {
    private static final Pattern SPECIAL_CHARACTER =
            Pattern.compile("[^\\p{Alpha}\\p{Digit}\\p{javaWhitespace}!+\\-=_^&%'\"*~@#]", Pattern.UNICODE_CHARACTER_CLASS);

    private static final Pattern ALPHABETIC_CHARACTER = Pattern.compile("[^\\p{Alpha}\\p{javaWhitespace}]");

    private static final Pattern ALPHABETIC_DIGIT_WITH_NON_WHITE_SPACE_CHARACTER_WITH_HYPHEN = Pattern.compile("[^a-z0-9-]");

    private static final Pattern ALPHABETIC_DIGIT_WITH_NON_WHITE_SPACE_CHARACTER = Pattern.compile("[^a-zA-Z0-9]");

    private static final Pattern WHITE_SPACE = Pattern.compile("[\\p{javaWhitespace}]");

    private static final Pattern NUMBER_CASE = Pattern.compile("[0-9]");

    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[!@#$%^&*_=+’-]");

    private static final Pattern SPECIAL_CHARACTER_PATTERN_ALL = Pattern.compile("[!@#$%^&*(),.?\":{}|<>/`~'\\\\;\\[\\]_=+-]");

    private <T> void invokeValidator(SaveState saveState, DomainValidator<T> validator, T target, Errors errors) {
        if (target != null && !validator.supports(target.getClass())) {
            throw new IllegalArgumentException(
                    "Validator [" + validator.getClass() + "]는 [" + target.getClass() + "]를 지원하지 않습니다.");
        }

        validator.validate(saveState, target, errors);
    }

    protected <T> void validateNested(SaveState saveState, Errors errors, String path, T item, DomainValidator<T> validator) {
        validateNested(errors, path, item, (T target) -> invokeValidator(saveState, validator, target, errors));
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String value) {
        validateStringIntegrally(errors, fieldName, null, value, true, Integer.MAX_VALUE);
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String value, int maxLength) {
        validateStringIntegrally(errors, fieldName, null, value, true, maxLength);
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String fieldDescription, String value) {
        validateStringIntegrally(errors, fieldName, fieldDescription, value, true, Integer.MAX_VALUE);
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String fieldDescription, String value, int maxLength) {
        validateStringIntegrally(errors, fieldName, fieldDescription, value, true, maxLength);
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String fieldDescription, String value, boolean required, int maxLength) {
        if (required && StringUtils.isBlank(value)) {
            rejectEmpty(errors, fieldName, fieldDescription);
        } else {
            if (StringUtils.isBlank(value)) {
                return;
            }

            if (value.length() > maxLength) {
                errors.rejectValue(
                        fieldName,
                        "size.upper_bound",
                        new Object[]{maxLength},
                        " field size is over limit. max size : " + maxLength);
            }
        }
    }

    protected void validateStringIntegrally(Errors errors, String fieldName, String value, int minLength, int maxLength) {
        if (StringUtils.isBlank(value)) {
            rejectEmpty(errors, fieldName, null);
            return;
        }

        if (value.length() < minLength || value.length() > maxLength) {
            errors.rejectValue(
                    fieldName,
                    "size.between_bound",
                    new Object[]{maxLength},
                    " field size is invalid.");
        }
    }

    protected void validateEmpty(Errors errors, String fieldName, Object value) {
        validateEmpty(errors, fieldName, null, value);
    }

    protected void validateEmpty(Errors errors, String fieldName, String fieldDescription, Object value) {

        if (value == null) {
            rejectEmpty(errors, fieldName, fieldDescription);
        }

        if (value instanceof String && StringUtils.isBlank((String) value)) {
            rejectEmpty(errors, fieldName, fieldDescription);
        }

        if (value instanceof Collection && CollectionUtils.isEmpty((Collection) value)) {
            rejectEmpty(errors, fieldName, fieldDescription);
        }
    }

    protected void validateMismatch(Errors errors, String fieldName, String fieldDescription, Object value, Object compareValue) {
        if (!ObjectUtils.notEqual(value, compareValue)) {
            return;
        }

        errors.rejectValue(fieldName, "mismatch", new Object[] {fieldDescription}, fieldDescription + " is mismatched");
    }

    protected void validateAlphabeticCharacter(Errors errors, String fieldName, String fieldDescription, String value) {

        if (StringUtils.isBlank(value)) {
            return;
        }

        final Set<String> chars = Sets.newHashSet();
        final Matcher matcher = ALPHABETIC_CHARACTER.matcher(value);

        while (matcher.find()) {
            chars.add(matcher.group());
        }

        if (!chars.isEmpty()) {
            String keywords = chars.stream().collect(Collectors.joining(""));
            errors.rejectValue(
                    fieldName,
                    "alphabetic_character_with",
                    new Object[]{fieldDescription, keywords},
                    fieldDescription + " is only use alphabetic characters. invalid value is " + keywords);
        }
    }

    private void rejectEmpty(Errors errors, String fieldName, String fieldDescription) {
        if (fieldDescription == null) {
            errors.rejectValue(fieldName, "empty", new Object[] { fieldName }, fieldName);
        } else {
            errors.rejectValue(fieldName, "empty", new Object[] { fieldDescription }, fieldDescription);
        }
    }

    private <T> void validateNested(Errors errors, String path, T item, Consumer<T> validator) {
        errors.pushNestedPath(path);
        validator.accept(item);
        errors.popNestedPath();
    }

    protected void validateNumberRange(Errors errors, String fieldName, Long value, Long minValue, Long maxValue) {
        if (value == null) {
            return;
        }

        if (minValue != null && value.compareTo(minValue) == -1) {
            errors.rejectValue(fieldName, "number.minimum", new Object[] {minValue}, null);
        }

        if (maxValue != null && value.compareTo(maxValue) == 1) {
            errors.rejectValue(fieldName, "number.maximum", new Object[] {maxValue}, null);
        }
    }


    protected void validateWhiteSpace(Errors errors, String fieldName, String value) {
        if (StringUtils.isBlank(value)) {
            return;
        }

        if (WHITE_SPACE.matcher(value).find()){
            errors.rejectValue(fieldName, "white_space");
        }
    }

    @Override
    public final void validate(SaveState saveState, T target, Errors errors) {
        if (saveState == SaveState.UPDATE) {
            onUpdate(target, errors);
            return;
        }

        onCreate(target, errors);
    }

    abstract protected void onUpdate(T target, Errors errors);

    abstract protected void onCreate(T target, Errors errors);

}
