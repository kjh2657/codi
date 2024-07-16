package com.musinsa.codi.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    TOP("상의"),
    OUTER("아우터"),
    BOTTOM("하의"),
    SNEAKERS("스니커즈"),
    BAG("가방"),
    CAP("모자"),
    SOCKS("양말"),
    ACC("악세서리");

    private final String description;
}
