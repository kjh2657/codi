package com.musinsa.codi.admin.brand.controller;

import com.musinsa.codi.admin.brand.controller.dto.BrandInfoAdminRes;
import com.musinsa.codi.admin.brand.controller.dto.BrandRegisterAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandSearchAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandUpdateAdminReq;
import com.musinsa.codi.admin.brand.service.BrandAdminService;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import com.musinsa.codi.admin.product.service.ProductAdminService;
import com.musinsa.codi.core.response.CommonPageResponse;
import com.musinsa.codi.core.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/admin")
public class BrandAdminController {

    private final BrandAdminService brandAdminService;

    /**
     * 브랜드 단일 조회
     * @param brandId
     * @return
     */
    @GetMapping(value = "/v1/brand/{brandId}", produces = "application/json")
    public CommonResponse<BrandInfoAdminRes> getBrand(@PathVariable Long brandId) {
        return CommonResponse.success(brandAdminService.getBrand(brandId));
    }

    /**
     * 브랜드 등록
     * @param req
     * @return
     */
    @PostMapping(value = "/v1/brand")
    public CommonResponse<BrandInfoAdminRes> registerBrand(@RequestBody @Valid BrandRegisterAdminReq req) {
        return CommonResponse.success(brandAdminService.registerBrand(req));
    }

    /**
     * 브랜드 수정
     * @param brandId
     * @param req
     * @return
     */
    @PatchMapping(value = "/v1/brand/{brandId}")
    public CommonResponse<String> updateBrand(@PathVariable Long brandId, @RequestBody BrandUpdateAdminReq req) {
        brandAdminService.updateBrand(brandId, req);
        return CommonResponse.success("Success");
    }

    /**
     * 브랜드 삭제
     * @param brandId
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/v1/brand/{brandId}")
    public CommonResponse<String> deleteBrand(@PathVariable Long brandId, @RequestParam(value = "userId") String userId) {
        brandAdminService.deleteBrand(brandId, userId);
        return CommonResponse.success("Success");
    }

    /**
     * 브랜드 리스트 조회
     * @param req
     * @return
     */
    @PostMapping(value = "/v1/brand/list")
    public CommonResponse<CommonPageResponse> getBrandList(@RequestBody @Valid BrandSearchAdminReq req) {
        return CommonResponse.success(brandAdminService.getBrandList(req));
    }
}
