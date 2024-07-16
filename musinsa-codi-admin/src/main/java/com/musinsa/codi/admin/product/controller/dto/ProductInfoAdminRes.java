package com.musinsa.codi.admin.product.controller.dto;

import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductInfoAdminRes {

    private Long productId;
    private StatusType productStatus;
    private CategoryType categoryType;
    private String productName;
    private String brandName;
    private Long brandId;
    private Long price;
    private String regUser;
    private String updUser;
    private LocalDateTime regDate;
    private LocalDateTime updDate;
}
