package com.musinsa.codi.core.infrastructure.repository.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CodiBrandDto {

    private Long brandId;
    private String brandName;
    private Long totalPrice;

}
