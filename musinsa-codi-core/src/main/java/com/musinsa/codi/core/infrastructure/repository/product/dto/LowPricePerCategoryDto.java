package com.musinsa.codi.core.infrastructure.repository.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LowPricePerCategoryDto {

    private String categoryName;
    private String brandName;
    private Long price;

}
