package com.musinsa.codi.admin.brand.mapper;

import com.musinsa.codi.admin.brand.controller.dto.BrandInfoAdminRes;
import com.musinsa.codi.admin.brand.controller.dto.BrandRegisterAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandSearchAdminReq;
import com.musinsa.codi.admin.brand.controller.dto.BrandUpdateAdminReq;
import com.musinsa.codi.admin.product.controller.dto.ProductInfoAdminRes;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.domain.product.ProductInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface BrandAdminMapper {

    BrandInfoAdminRes toBrandInfoAdminRes(BrandInfo brand);
    List<BrandInfoAdminRes> toBrandInfoAdminRes(List<BrandInfo> brand);


    @Mappings({
          @Mapping(target = "regUser", source = "userId"),
          @Mapping(target = "updUser", source = "userId"),
    })
    BrandCommand.RegisterBrand toBrandRegisterCommand(BrandRegisterAdminReq req);

    @Mappings({
            @Mapping(target = "updUser", source = "userId"),
    })
    BrandCommand.UpdateBrand toBrandUpdateCommand(BrandUpdateAdminReq req);

    BrandCommand.SearchBrand toBrandSearchCommand(BrandSearchAdminReq req);
}
