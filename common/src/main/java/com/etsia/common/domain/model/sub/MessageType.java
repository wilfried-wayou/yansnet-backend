package com.etsia.common.domain.model.sub;

import lombok.Getter;

@Getter
public enum MessageType {
    TEXT("text"),
    IMAGE("image"),
    VIDEO("video"),
    AUDIO("audio"),
    FILE("file");

    private final String value;

    MessageType(String value) {
        this.value = value;
    }
}
