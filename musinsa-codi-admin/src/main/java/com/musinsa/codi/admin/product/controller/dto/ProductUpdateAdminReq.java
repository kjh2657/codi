package com.musinsa.codi.admin.product.controller.dto;

import com.musinsa.codi.core.annotation.EnumPattern;
import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateAdminReq {

    @NotBlank(message = "상품 카테고리는 필수입니다.")
    @EnumPattern(enumClass = CategoryType.class, message = "상품 카테고리 값을 확인해주세요.")
    private String categoryType;
    @NotBlank(message = "상품 상태값은 필수입니다.")
    @EnumPattern(enumClass = StatusType.class, message = "상품 상태값을 확인해주세요.")
    private String productStatus;
    @NotBlank(message = "productName은 필수입니다.")
    private String productName;
    @Positive(message = "브랜드 ID 값은 필수입니다.")
    private Long brandId;
    @Positive(message = "상품 가격은 필수입니다.")
    private Long price;
    @NotBlank(message = "userId는 필수입니다.")
    private String userId;
}
