package com.musinsa.codi.admin.brand.controller.dto;

import com.musinsa.codi.core.annotation.EnumPattern;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandSearchAdminReq {

    @Positive(message = "pageNo는 0보다 큰 숫자를 입력해야합니다.")
    private int pageNo;
    @Positive(message = "pageSize는 0보다 큰 숫자를 입력해야합니다.")
    private int pageSize;
    private Long brandId;
    @EnumPattern(enumClass = StatusType.class, message = "브랜드 상태값을 확인해주세요.")
    private String brandStatus;
    private String brandName;
}
