package com.musinsa.codi.admin.brand.service;

import com.musinsa.codi.admin.brand.controller.dto.BrandInfoAdminRes;
import com.musinsa.codi.admin.brand.controller.dto.BrandRegisterAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandSearchAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandUpdateAdminReq;
import com.musinsa.codi.admin.brand.mapper.BrandAdminMapper;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import com.musinsa.codi.admin.product.mapper.ProductAdminMapper;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.domain.brand.BrandService;
import com.musinsa.codi.core.domain.product.ProductInfo;
import com.musinsa.codi.core.domain.product.ProductService;
import com.musinsa.codi.core.response.CommonPageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandAdminService {

    private final BrandService brandService;
    private final ProductService productService;
    private final BrandAdminMapper brandAdminMapper;


    /**
     * 브랜드 단일 조회
     * @param brandId
     * @return
     */
    public BrandInfoAdminRes getBrand(Long brandId) {
        BrandInfo result = brandService.findBrand(brandId);
        return brandAdminMapper.toBrandInfoAdminRes(result);
    }

    /**
     * 브랜드 등록
     * @param req
     * @return
     */
    @Transactional
    public BrandInfoAdminRes registerBrand(BrandRegisterAdminReq req) {
        BrandCommand.RegisterBrand registerBrand = brandAdminMapper.toBrandRegisterCommand(req);
        BrandInfo save = brandService.saveBrand(registerBrand);
        return brandAdminMapper.toBrandInfoAdminRes(save);
    }

    /**
     * 브랜드 수정
     * @param brandId
     * @param req
     */
    @Transactional
    public void updateBrand(Long brandId, BrandUpdateAdminReq req) {
        BrandCommand.UpdateBrand updateBrand = brandAdminMapper.toBrandUpdateCommand(req);
        brandService.updateBrand(brandId, updateBrand);
    }

    /**
     * 브랜드 삭제
     * @param brandId
     * @param userId
     */
    @Transactional
    public void deleteBrand(Long brandId, String userId) {
        // 브랜드 정보 삭제 처리
        brandService.deleteBrand(brandId, userId);
        // 관련된 상품들 삭제 처리
        productService.deleteProductByBrandId(brandId);
    }

    /**
     * 브랜드 리스트 조회
     * @param req
     * @return
     */
    public CommonPageResponse getBrandList(BrandSearchAdminReq req) {
        PageRequest pageable = PageRequest.of(req.getPageNo() - 1, req.getPageSize());

        BrandCommand.SearchBrand searchBrand = brandAdminMapper.toBrandSearchCommand(req);

        Page<BrandInfo> brandList = brandService.findBrandList(pageable, searchBrand);

        return CommonPageResponse.toPage(new PageImpl<>(brandAdminMapper.toBrandInfoAdminRes(brandList.getContent()), brandList.getPageable(), brandList.getTotalElements()));
    }
}
