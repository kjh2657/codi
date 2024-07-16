package com.musinsa.codi.core.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    COMMON_SYSTEM_ERROR(20000, "일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    COMMON_INVALID_PARAMETER(20001, "요청한 값이 올바르지 않습니다,"),
    BRAND_NOT_FOUND(20100, "브랜드 정보가 없습니다."),


    PRODUCT_NOT_FOUND(20200, "상품 정보가 없습니다."),



    CATEGORY_PRODUCT_NOT_FOUND(21100, "해당 카테고리에 상품이 없습니다."),
    CODI_ENABLE_BRAND_NOT_FOUND(21101, "코디가 가능한 브랜드가 없습니다."),
    ;

    private final int errorCode;
    private final String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
