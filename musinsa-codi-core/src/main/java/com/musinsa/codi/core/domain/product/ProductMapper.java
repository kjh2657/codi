package com.musinsa.codi.core.domain.product;

import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "brandName", ignore = true),
    })
    ProductInfo toProductInfo(Product product);
}
