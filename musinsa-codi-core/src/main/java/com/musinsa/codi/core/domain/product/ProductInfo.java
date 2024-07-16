package com.musinsa.codi.core.domain.product;

import com.musinsa.codi.core.domain.common.CommonEntity;
import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductInfo {

    private Long productId;
    private StatusType productStatus;
    private CategoryType categoryType;
    private String productName;
    private Long brandId;
    private String brandName;
    private Long price;
    private String regUser;
    private String updUser;
    private LocalDateTime regDate;
    private LocalDateTime updDate;

}
