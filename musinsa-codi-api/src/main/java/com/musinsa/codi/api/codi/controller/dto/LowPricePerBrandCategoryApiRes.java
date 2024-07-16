package com.musinsa.codi.api.codi.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LowPricePerBrandCategoryApiRes {

    private long totalPrice;
    private List<ProductRes> categoryProductList = new ArrayList<>();

}
