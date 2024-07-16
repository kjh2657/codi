package com.musinsa.codi.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusType {

    CREATE("생성"),
    USE("사용"),
    DELETE("삭제");

    private final String description;
}
