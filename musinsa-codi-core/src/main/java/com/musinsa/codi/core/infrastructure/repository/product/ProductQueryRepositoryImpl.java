package com.musinsa.codi.core.infrastructure.repository.product;

import com.musinsa.codi.core.domain.brand.BrandInfo;
import com.musinsa.codi.core.domain.product.ProductCommand;
import com.musinsa.codi.core.domain.product.ProductInfo;
import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import com.musinsa.codi.core.infrastructure.repository.product.dto.BrandProductDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CategoryProductDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static com.musinsa.codi.core.domain.brand.QBrand.brand;
import static com.musinsa.codi.core.domain.category.QCategory.category;
import static com.musinsa.codi.core.domain.product.QProduct.product;

@RequiredArgsConstructor
public class ProductQueryRepositoryImpl implements ProductQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Page<ProductInfo> getProductList(PageRequest pageable, ProductCommand.SearchProduct req) {
        Long count = jpaQueryFactory
                .select(product.count())
                .from(product)
                .join(brand)
                .on(brand.brandId.eq(product.brandId),
                        brand.brandStatus.ne(StatusType.DELETE))
                .where(
                        eqBrandId(req.getBrandId()),
                        eqProductStatus(req.getProductStatus()),
                        eqProductId(req.getProductId()),
                        containProductName(req.getProductName()),
                        eqCategoryType(req.getCategoryType())
                )
                .fetchOne();

        List<ProductInfo> result = jpaQueryFactory
                .select(Projections.fields(ProductInfo.class,
                        product.productId,
                        product.productStatus,
                        product.categoryType,
                        product.productName,
                        product.brandId,
                        brand.brandName,
                        product.price,
                        product.regUser,
                        product.updUser,
                        product.regDate,
                        product.updDate))
                .from(product)
                .join(brand)
                .on(brand.brandId.eq(product.brandId),
                        brand.brandStatus.ne(StatusType.DELETE))
                .where(
                        eqBrandId(req.getBrandId()),
                        eqProductStatus(req.getProductStatus()),
                        eqProductId(req.getProductId()),
                        containProductName(req.getProductName()),
                        eqCategoryType(req.getCategoryType())
                )
                .orderBy(product.regDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(result, pageable, count);
    }

    @Override
    public CategoryProductDto getCategoryLowPriceProduct(String categoryName) {
        Tuple result = jpaQueryFactory
                .select(brand.brandName
                        , product.price.min()
                )
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .join(category)
                .on(product.categoryType.eq(category.categoryType))
                .where(product.productStatus.eq(StatusType.USE),
                        brand.brandStatus.eq(StatusType.USE),
                        category.categoryName.eq(categoryName)
                )
                .groupBy(brand.brandName)
                .orderBy(product.price.min().asc())
                .fetchFirst();

        if (result != null) {
            return new CategoryProductDto(result.get(brand.brandName), result.get(product.price.min()));
        } else {
            return null;
        }
    }

    @Override
    public CategoryProductDto getCategoryHighPriceProduct(String categoryName) {
        Tuple result = jpaQueryFactory
                .select(brand.brandName
                        , product.price.max()
                )
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .join(category)
                .on(product.categoryType.eq(category.categoryType))
                .where(product.productStatus.eq(StatusType.USE),
                        brand.brandStatus.eq(StatusType.USE),
                        category.categoryName.eq(categoryName)
                )
                .groupBy(brand.brandName)
                .orderBy(product.price.max().desc())
                .fetchFirst();

        if (result != null) {
            return new CategoryProductDto(result.get(brand.brandName), result.get(product.price.max()));
        } else {
            return null;
        }
    }

    @Override
    public List<BrandProductDto> getBrandLowPriceProduct(Long brandId) {
        List<Tuple> resultList = jpaQueryFactory
                .select(category.categoryName
                        , product.price.min()
                )
                .from(product)
                .join(brand)
                .on(product.brandId.eq(brand.brandId))
                .join(category)
                .on(product.categoryType.eq(category.categoryType))
                .where(product.productStatus.eq(StatusType.USE),
                        brand.brandStatus.eq(StatusType.USE),
                        brand.brandId.eq(brandId)
                )
                .groupBy(category.categoryName)
                .orderBy(category.sort.asc())
                .fetch();

        List<BrandProductDto> result = new ArrayList<>();

        for (Tuple tuple : resultList) {
            result.add(new BrandProductDto(tuple.get(category.categoryName), tuple.get(product.price.min())));
        }

        return result;
    }


    private BooleanExpression containProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            return null;
        }
        return product.productName.contains(productName);
    }

    private BooleanExpression eqProductStatus(String productStatus) {
        if (productStatus == null) {
            return null;
        }
        return product.productStatus.eq(StatusType.valueOf(productStatus));
    }

    private BooleanExpression eqBrandId(Long brandId) {
        if(brandId == null) {
            return null;
        }
        return product.brandId.eq(brandId);
    }

    private BooleanExpression eqProductId(Long productId) {
        if(productId == null) {
            return null;
        }
        return product.productId.eq(productId);
    }

    private BooleanExpression eqCategoryType(String categoryType) {
        if (categoryType == null) {
            return null;
        }
        return product.categoryType.eq(CategoryType.valueOf(categoryType));
    }
}
