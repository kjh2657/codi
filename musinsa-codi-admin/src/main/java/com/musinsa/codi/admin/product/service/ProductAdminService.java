package com.musinsa.codi.admin.product.service;

import com.musinsa.codi.admin.product.controller.dto.ProductRegisterAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductSearchAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductUpdateAdminReq;
import com.musinsa.codi.admin.product.mapper.ProductAdminMapper;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.domain.brand.BrandService;
import com.musinsa.codi.core.domain.product.ProductCommand;
import com.musinsa.codi.core.domain.product.ProductInfo;
import com.musinsa.codi.core.domain.product.ProductService;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import com.musinsa.codi.core.response.CommonPageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdminService {

    private final ProductService productService;
    private final BrandService brandService;
    private final ProductAdminMapper productAdminMapper;


    /**
     * 상품 단일 조회
     * @param productId
     * @return
     */
    public ProductInfoAdminRes getProduct(Long productId) {
        ProductInfo result = productService.findProduct(productId);
        return productAdminMapper.toProductInfoAdminRes(result);
    }

    /**
     * 상품 등록
     * @param req
     * @return
     */
    @Transactional
    public ProductInfoAdminRes registerProduct(ProductRegisterAdminReq req) {

        //브랜드 조회
        brandService.findBrand(req.getBrandId());

        ProductCommand.RegisterProduct registerProduct = productAdminMapper.toProductRegisterCommand(req);
        ProductInfo save = productService.saveProduct(registerProduct);
        return productAdminMapper.toProductInfoAdminRes(save);
    }

    /**
     * 상품 수정
     * @param productId
     * @param req
     */
    @Transactional
    public void updateProduct(Long productId, ProductUpdateAdminReq req) {
        ProductCommand.UpdateProduct updateProduct = productAdminMapper.toProductUpdateCommand(req);
        productService.updateProduct(productId, updateProduct);
    }

    /**
     * 상품 삭제
     * @param productId
     * @param userId
     */
    @Transactional
    public void deleteProduct(Long productId, String userId) {
        productService.deleteProduct(productId, userId);
    }

    /**
     * 상품 리스트 조회
     * @param req
     * @return
     */
    public CommonPageResponse getProductList(ProductSearchAdminReq req) {
        PageRequest pageable = PageRequest.of(req.getPageNo() - 1, req.getPageSize());

        ProductCommand.SearchProduct searchProduct = productAdminMapper.toProductSearchCommand(req);

        Page<ProductInfo> productList = productService.getProductList(pageable, searchProduct);

        return CommonPageResponse.toPage(new PageImpl<>(productAdminMapper.toProductInfoAdminRes(productList.getContent()), productList.getPageable(), productList.getTotalElements()));
    }



}
