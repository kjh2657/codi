package com.musinsa.codi.core.infrastructure.repository.product;

import com.musinsa.codi.core.domain.product.ProductCommand;
import com.musinsa.codi.core.domain.product.ProductInfo;
import com.musinsa.codi.core.infrastructure.repository.product.dto.BrandProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CategoryProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductQueryRepository {

    Page<ProductInfo> getProductList(PageRequest pageable, ProductCommand.SearchProduct req);

    CategoryProductDto getCategoryLowPriceProduct(String categoryName);

    CategoryProductDto getCategoryHighPriceProduct(String categoryName);

    List<BrandProductDto> getBrandLowPriceProduct(Long brandId);
}
