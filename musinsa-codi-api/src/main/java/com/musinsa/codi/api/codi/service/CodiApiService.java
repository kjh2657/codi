package com.musinsa.codi.api.codi.service;

import com.musinsa.codi.api.codi.controller.dto.CategoryProductPerPriceApiRes;
import com.musinsa.codi.api.codi.controller.dto.CategoryProductPerPriceReq;
import com.musinsa.codi.api.codi.controller.dto.LowPricePerBrandApiRes;
import com.musinsa.codi.api.codi.controller.dto.LowPricePerBrandCategoryApiRes;
import com.musinsa.codi.api.codi.mapper.CodiApiMapper;
import com.musinsa.codi.core.domain.product.ProductService;
import com.musinsa.codi.core.exception.BaseException;
import com.musinsa.codi.core.infrastructure.repository.product.dto.BrandProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CategoryProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CodiBrandDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.LowPricePerCategoryDto;
import com.musinsa.codi.core.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodiApiService {

    private final ProductService productService;
    private final CodiApiMapper codiApiMapper;


    /**
     * 카테고리별 최저가 브랜드 조회
     * @return
     */
    public LowPricePerBrandCategoryApiRes getLowPriceBrandPerCategory() {

        LowPricePerBrandCategoryApiRes response = new LowPricePerBrandCategoryApiRes();

        //카테고리 별 최저가 상품 조회
        List<LowPricePerCategoryDto> lowPricePerCategory = productService.getLowPriceBrandPerCategory();

        //총 가격
        long totalPrice = 0;

        // response로 변환할 때 가격 계산
        for (LowPricePerCategoryDto dto : lowPricePerCategory) {
            totalPrice += dto.getPrice();
            response.getCategoryProductList().add(codiApiMapper.toCategoryProductRes(dto));
        }

        response.setTotalPrice(totalPrice);


        return response;
    }


    /**
     * 코디 가능한 단일 브랜드의 최저가 상품 및 브랜드 조회
     * @return
     */
    public LowPricePerBrandApiRes getLowTotalPriceBrand() {

        LowPricePerBrandApiRes response = new LowPricePerBrandApiRes();

        // 코디가 가능한 브랜드 가격순 조회(모든 카테고리가 존재하는 브랜드)
        List<CodiBrandDto> codiEnableBrandList = productService.getCodiEnableBrandList();

        // 첫 번째 브랜드 선택 없을 경우 코디 불가능 응답
        CodiBrandDto codiBrandDto = codiEnableBrandList.stream()
                .findFirst()
                .orElseThrow(() -> new BaseException(ErrorCode.CODI_ENABLE_BRAND_NOT_FOUND));

        // 브랜드 세팅
        response.setBrandName(codiBrandDto.getBrandName());
        response.setTotalPrice(codiBrandDto.getTotalPrice());

        // 해당 브랜드의 최저가 상품들 조회
        List<BrandProductDto> lowPriceProduct = productService.findLowPriceProduct(codiBrandDto.getBrandId());

        response.setCategoryProductList(codiApiMapper.toCategoryProductResList(lowPriceProduct));

        return response;
    }

    /**
     * 특정 카테고리의 최고/최저가 상품 조회
     * @param req
     * @return
     */
    public CategoryProductPerPriceApiRes getCategoryMinMaxProduct(CategoryProductPerPriceReq req) {
        CategoryProductPerPriceApiRes response = new CategoryProductPerPriceApiRes();

        // 특정 카테고리 최저가 상품 조회
        CategoryProductDto lowPriceProduct = productService.getCategoryLowPriceProduct(req.getCategoryName());

        // 특정 카테고리 최조가 상품 조회
        CategoryProductDto highPriceProduct = productService.getCategoryHighPriceProduct(req.getCategoryName());

        // 상품이 없을 경우 카테고리 내 상품 없음 응답
        if ( lowPriceProduct == null && highPriceProduct == null) {
            throw new BaseException(ErrorCode.CATEGORY_PRODUCT_NOT_FOUND);
        }

        response.setCategoryName(req.getCategoryName());
        response.setLowPriceProduct(codiApiMapper.toCategoryProductRes(lowPriceProduct));
        response.setHighPriceProduct(codiApiMapper.toCategoryProductRes(highPriceProduct));

        return response;
    }
}
