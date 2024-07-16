package com.musinsa.codi.admin.brand.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BrandRegisterAdminReq {

    @NotBlank(message = "brandName은 필수입니다.")
    private String brandName;
    @NotBlank(message = "userId는 필수입니다.")
    private String userId;
}
