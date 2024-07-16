package com.musinsa.codi.core.infrastructure.repository.brand;


import com.musinsa.codi.core.domain.brand.Brand;
import com.musinsa.codi.core.domain.brand.BrandCommand;
import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.enums.StatusType;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static com.musinsa.codi.core.domain.brand.QBrand.brand;

@RequiredArgsConstructor
public class BrandQueryRepositoryImpl implements BrandQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Page<BrandInfo> findBrandList(PageRequest pageable, BrandCommand.SearchBrand req) {
        Long count = jpaQueryFactory
                .select(brand.count())
                .from(brand)
                .where(
                        eqBrandId(req.getBrandId()),
                        eqBrandStatus(req.getBrandStatus()),
                        containBrandName(req.getBrandName())
                )
                .fetchOne();

        List<BrandInfo> result = jpaQueryFactory
                .select(Projections.fields(BrandInfo.class,
                        brand.brandId,
                        brand.brandStatus,
                        brand.brandName,
                        brand.regUser,
                        brand.updUser,
                        brand.regDate,
                        brand.updDate))
                .from(brand)
                .where(
                        eqBrandId(req.getBrandId()),
                        eqBrandStatus(req.getBrandStatus()),
                        containBrandName(req.getBrandName())
                )
                .orderBy(brand.regDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, count);
    }

    private BooleanExpression containBrandName(String brandName) {
        if (brandName == null || brandName.isEmpty()) {
            return null;
        }
        return brand.brandName.contains(brandName);
    }

    private BooleanExpression eqBrandStatus(String brandStatus) {
        if (brandStatus == null) {
            return null;
        }
        return brand.brandStatus.eq(StatusType.valueOf(brandStatus));
    }

    private BooleanExpression eqBrandId(Long brandId) {
        if(brandId == null) {
            return null;
        }
        return brand.brandId.eq(brandId);
    }
}
