package com.musinsa.codi.core.infrastructure.repository.brand;

import com.musinsa.codi.core.domain.brand.Brand;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.enums.StatusType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandQueryRepository {

    Page<BrandInfo> findBrandList(PageRequest pageable, BrandCommand.SearchBrand req);
}
