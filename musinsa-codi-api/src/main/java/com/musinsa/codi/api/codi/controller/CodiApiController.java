package com.musinsa.codi.api.codi.controller;

import com.musinsa.codi.api.codi.controller.dto.CategoryProductPerPriceApiRes;
import com.musinsa.codi.api.codi.controller.dto.CategoryProductPerPriceReq;
import com.musinsa.codi.api.codi.controller.dto.LowPricePerBrandApiRes;
import com.musinsa.codi.api.codi.controller.dto.LowPricePerBrandCategoryApiRes;
import com.musinsa.codi.api.codi.service.CodiApiService;
import com.musinsa.codi.core.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/api")
public class CodiApiController {

    private final CodiApiService codiApiService;

    /**
     * 카테고리 별 최저가 브랜드
     * @return
     */
    @GetMapping(value = "/v1/codi/category/lowprice", produces = "application/json")
    public CommonResponse<LowPricePerBrandCategoryApiRes> getLowPriceBrandPerCategory() {
        return CommonResponse.success(codiApiService.getLowPriceBrandPerCategory());
    }

    /**
     * 단일 브랜드 최저가
     * @return
     */
    @GetMapping(value = "/v1/codi/brand/lowprice", produces = "application/json")
    public CommonResponse<LowPricePerBrandApiRes> getLowTotalPriceBrand() {
        return CommonResponse.success(codiApiService.getLowTotalPriceBrand());
    }

    /**
     * 특정 카테고리 최저/최고가
     * @param req
     * @return
     */
    @PostMapping(value = "/v1/codi/category/product")
    public CommonResponse<CategoryProductPerPriceApiRes> getCategoryMinMaxProduct(@RequestBody CategoryProductPerPriceReq req) {
        return CommonResponse.success(codiApiService.getCategoryMinMaxProduct(req));
    }

}
