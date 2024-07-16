package com.musinsa.codi.admin.product.controller;

import com.musinsa.codi.admin.brand.controller.dto.BrandInfoAdminRes;
import com.musinsa.codi.admin.brand.controller.dto.BrandRegisterAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandSearchAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandUpdateAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import com.musinsa.codi.admin.product.controller.dto.ProductRegisterAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductSearchAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductUpdateAdminReq;
import com.musinsa.codi.admin.product.service.ProductAdminService;
import com.musinsa.codi.core.response.CommonPageResponse;
import com.musinsa.codi.core.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codi/admin")
public class ProductAdminController {

    private final ProductAdminService productAdminService;

    /**
     * 상품 단일 조회
     * @param productId
     * @return
     */
    @GetMapping(value = "/v1/product/{productId}", produces = "application/json")
    public CommonResponse<ProductInfoAdminRes> getProduct(@PathVariable Long productId) {
        return CommonResponse.success(productAdminService.getProduct(productId));
    }

    /**
     * 상품 등록
     * @param req
     * @return
     */
    @PostMapping(value = "/v1/product")
    public CommonResponse<ProductInfoAdminRes> registerProduct(@RequestBody @Valid ProductRegisterAdminReq req) {
        return CommonResponse.success(productAdminService.registerProduct(req));
    }

    /**
     * 상품 수정
     * @param productId
     * @param req
     * @return
     */
    @PatchMapping(value = "/v1/product/{productId}")
    public CommonResponse<String> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductUpdateAdminReq req) {
        productAdminService.updateProduct(productId, req);
        return CommonResponse.success("Success");
    }

    /**
     * 상품 삭제
     * @param productId
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/v1/product/{productId}")
    public CommonResponse<String> deleteProduct(@PathVariable Long productId, @RequestParam(value = "userId") String userId) {
        productAdminService.deleteProduct(productId, userId);
        return CommonResponse.success("Success");
    }

    /**
     * 상품 리스트 조회
     * @param req
     * @return
     */
    @PostMapping(value = "/v1/product/list")
    public CommonResponse<CommonPageResponse> getProductList(@RequestBody @Valid ProductSearchAdminReq req) {
        return CommonResponse.success(productAdminService.getProductList(req));
    }
}
