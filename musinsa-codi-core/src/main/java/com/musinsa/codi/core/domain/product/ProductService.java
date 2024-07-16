package com.musinsa.codi.core.domain.product;

import com.musinsa.codi.core.enums.StatusType;
import com.musinsa.codi.core.exception.BaseException;
import com.musinsa.codi.core.infrastructure.repository.product.ProductRepository;
import com.musinsa.codi.core.infrastructure.repository.product.dto.BrandProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CategoryProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CodiBrandDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.LowPricePerCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.musinsa.codi.core.response.ErrorCode.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    /**
     * 상품 단일 조회
     * @param productId
     * @return
     */
    public ProductInfo findProduct(Long productId) {
        Product product = findNotDeleteProduct(productId);
        return productMapper.toProductInfo(product);
    }

    /**
     * 상품 저장
     * @param product
     * @return
     */
    public ProductInfo saveProduct(ProductCommand.RegisterProduct product) {
        Product save = productRepository.save(product.toEntity());
        return productMapper.toProductInfo(save);
    }

    /**
     * 상품 수정
     * @param productId
     * @param updateProduct
     */
    public void updateProduct(Long productId, ProductCommand.UpdateProduct updateProduct) {
        Product product = findNotDeleteProduct(productId);
        product.update(updateProduct);
    }

    /**
     * 상품 삭제
     * @param productId
     * @param userId
     */
    public void deleteProduct(Long productId, String userId) {
        Product product = findNotDeleteProduct(productId);
        product.delete(userId);
    }


    /**
     * 상품 리스트 조회
     * @param pageable
     * @param req
     * @return
     */
    public Page<ProductInfo> getProductList(PageRequest pageable, ProductCommand.SearchProduct req) {
        return productRepository.getProductList(pageable, req);
    }


    /**
     * 브랜드 아이디로 상품 삭제
     * @param brandId
     */
    public void deleteProductByBrandId(Long brandId) {
        productRepository.deleteProductByBrandId(brandId);
    }


    /**
     * 삭제되지 않은 상품 조회
     * @param productId
     * @return
     */
    private Product findNotDeleteProduct(Long productId) {
        Product product = productRepository.findByProductIdAndProductStatusNot(productId, StatusType.DELETE);

        if (product == null) {
            throw new BaseException(PRODUCT_NOT_FOUND);
        }

        return product;
    }

    /**
     * 카테고리 별 최저가 브랜드 조회
     * @return
     */
    public List<LowPricePerCategoryDto> getLowPriceBrandPerCategory() {
        return productRepository.getLowPriceBrandPerCategory();
    }

    /**
     * 코디가 가능한 브랜드 리스트 조회(가격 오름순 정렬)
     * @return
     */
    public List<CodiBrandDto> getCodiEnableBrandList() {
        return productRepository.getCodiEnableBrandList();
    }

    /**
     * 브랜드 내의 카테고리별 최저가 상품 조회
     * @param brandId
     * @return
     */
    public List<BrandProductDto> findLowPriceProduct(Long brandId) {
        return productRepository.getBrandLowPriceProduct(brandId);
    }



    /**
     * 특정 카테고리 이름으로 최저가 상품 조회
     * @param categoryName
     * @return
     */
    public CategoryProductDto getCategoryLowPriceProduct(String categoryName) {
        return productRepository.getCategoryLowPriceProduct(categoryName);
    }

    /**
     * 특정 카테고리 이름으로 최고가 상품 조회
     * @param categoryName
     * @return
     */
    public CategoryProductDto getCategoryHighPriceProduct(String categoryName) {
        return productRepository.getCategoryHighPriceProduct(categoryName);
    }


}
