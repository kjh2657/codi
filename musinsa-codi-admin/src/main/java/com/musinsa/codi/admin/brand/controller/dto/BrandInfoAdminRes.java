package com.musinsa.codi.admin.brand.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BrandInfoAdminRes {

    private Long brandId;
    private String brandName;
    private String brandStatus;
    private String regUser;
    private String updUser;
    private LocalDateTime regDate;
    private LocalDateTime updDate;
}
