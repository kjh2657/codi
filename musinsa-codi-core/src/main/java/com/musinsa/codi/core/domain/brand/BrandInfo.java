package com.musinsa.codi.core.domain.brand;

import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BrandInfo {

    private Long brandId;
    private String brandName;
    private StatusType brandStatus;
    private String regUser;
    private String updUser;
    private LocalDateTime regDate;
    private LocalDateTime updDate;

}
