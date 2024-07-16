package com.musinsa.codi.api.codi.mapper;

import com.musinsa.codi.api.codi.controller.dto.ProductRes;
import com.musinsa.codi.core.infrastructure.repository.product.dto.BrandProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CategoryProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.LowPricePerCategoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CodiApiMapper {

    ProductRes toCategoryProductRes(LowPricePerCategoryDto dto);

    @Mappings({
            @Mapping(target = "categoryName", ignore = true),
    })
    ProductRes toCategoryProductRes(CategoryProductDto dto);

    @Mappings({
            @Mapping(target = "brandName", ignore = true),
    })
    ProductRes toCategoryProductRes(BrandProductDto dto);

    List<ProductRes> toCategoryProductResList(List<BrandProductDto> dto);

}
