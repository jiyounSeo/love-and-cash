package com.project.loveandpeace.common.mapper;

import com.project.loveandpeace.common.enumeration.SaveState;

public interface RequestEntityMapper<R, E> {
    E requestToEntity(SaveState state, R request);

    default E requestToEntity(R request) {
        return requestToEntity(SaveState.NEW, request);
    }
}
