package com.etsia.common.domain.model.sub;

import lombok.Getter;

@Getter
public enum MediaType {
    IMAGE("image"),
    VIDEO("video");
    private final String value;

    MediaType(String value) {
        this.value = value;
    }

}
