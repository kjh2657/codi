package com.musinsa.codi.admin.brand.controller.dto;

import com.musinsa.codi.core.annotation.EnumPattern;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandUpdateAdminReq {


    @NotBlank(message = "브랜드 상태값은 필수입니다.")
    @EnumPattern(enumClass = StatusType.class, message = "브랜드 상태값을 확인해주세요.")
    private String brandStatus;
    private String brandName;

    @NotBlank(message = "userId는 필수입니다.")
    private String userId;
}
