package com.project.loveandpeace.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T, U> {

    private final String wildcard = "%";

    public abstract Specification<T> getFilterForList(U request);

    String containsLowerCase(String searchField) {
        return wildcard + searchField.toLowerCase() + wildcard;
    }

    Specification<T> attributeEquals(String attribute, Object value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }

            if (value instanceof String) {
                if (StringUtils.isBlank((String) value)) {
                    return null;
                }
            }

            return cb.and(cb.equal(root.get(attribute), value));
        };
    }
}
