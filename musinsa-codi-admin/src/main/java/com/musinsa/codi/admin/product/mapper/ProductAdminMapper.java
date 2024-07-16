package com.musinsa.codi.admin.product.mapper;

import com.musinsa.codi.admin.brand.controller.dto.BrandRegisterAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandUpdateAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductRegisterAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductSearchAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductUpdateAdminReq;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.product.ProductCommand;
import com.musinsa.codi.core.domain.product.ProductInfo;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ProductAdminMapper {

    ProductInfoAdminRes toProductInfoAdminRes(ProductInfo product);
    List<ProductInfoAdminRes> toProductInfoAdminRes(List<ProductInfo> product);


    @Mappings({
            @Mapping(target = "regUser", source = "userId"),
            @Mapping(target = "updUser", source = "userId"),
    })
    ProductCommand.RegisterProduct toProductRegisterCommand(ProductRegisterAdminReq req);

    @Mappings({
            @Mapping(target = "updUser", source = "userId"),
    })
    ProductCommand.UpdateProduct toProductUpdateCommand(ProductUpdateAdminReq req);

    ProductCommand.SearchProduct toProductSearchCommand(ProductSearchAdminReq req);
}
