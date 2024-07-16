package com.musinsa.codi.admin.product.controller.dto;

import com.musinsa.codi.core.annotation.EnumPattern;
import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchAdminReq {

    @Positive(message = "pageNo는 0보다 큰 숫자를 입력해야합니다.")
    private int pageNo;
    @Positive(message = "pageSize는 0보다 큰 숫자를 입력해야합니다.")
    private int pageSize;
    private Long brandId;
    private Long productId;
    @EnumPattern(enumClass = StatusType.class, message = "상품 상태값을 확인해주세요.")
    private String productStatus;
    private String productName;
    @EnumPattern(enumClass = CategoryType.class, message = "상품 카테고리 값을 확인해주세요.")
    private String categoryType;
}
