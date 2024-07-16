package com.musinsa.codi.core.infrastructure.repository.brand;

import com.musinsa.codi.core.domain.brand.Brand;
import com.musinsa.codi.core.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, BrandQueryRepository {

    Brand findByBrandIdAndBrandStatusNot(Long brandId, StatusType statusType);
}
