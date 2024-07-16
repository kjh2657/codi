package com.musinsa.codi.api.codi.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRes {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String categoryName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String brandName;
    private Long price;
}
