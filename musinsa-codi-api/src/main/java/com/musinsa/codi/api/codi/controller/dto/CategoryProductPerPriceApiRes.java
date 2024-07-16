package com.musinsa.codi.api.codi.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryProductPerPriceApiRes {

    private String categoryName;
    private ProductRes lowPriceProduct;
    private ProductRes highPriceProduct;

}
