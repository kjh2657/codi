package com.musinsa.codi.core.infrastructure.repository.product;

import com.musinsa.codi.core.domain.product.Product;
import com.musinsa.codi.core.enums.StatusType;
import com.musinsa.codi.core.infrastructure.repository.product.dto.CodiBrandDto;
import com.musinsa.codi.core.infrastructure.repository.product.dto.LowPricePerCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryRepository {

    Product findByProductIdAndProductStatusNot(Long productId, StatusType productStatus);

    @Modifying
    @Query(value = "UPDATE MUSINSA_PRODUCT " +
            "       SET PRODUCT_STATUS = 'DELETE' " +
            "       WHERE BRAND_ID = :brandId " , nativeQuery = true)
    void deleteProductByBrandId(@Param("brandId") Long brandId);

    @Query(value = """
                SELECT new com.musinsa.codi.core.infrastructure.repository.product.dto.LowPricePerCategoryDto(categoryName, brandName, price)
                FROM ( SELECT CATE.categoryName as categoryName,
                              BRAND.brandName as brandName, 
                              PROD.price as price,
                              ROW_NUMBER() OVER (PARTITION BY PROD.categoryType ORDER BY PROD.price, PROD.brandId asc) AS PRANK ,
                              CATE.sort as sort
                       FROM Product PROD 
                       JOIN Brand BRAND ON BRAND.brandId = PROD.brandId
                       JOIN Category CATE ON CATE.categoryType = PROD.categoryType
                       WHERE PROD.productStatus = 'USE'
                      ) AS SUB 
                WHERE PRANK = 1 
                ORDER BY sort asc
            """
    )
    List<LowPricePerCategoryDto> getLowPriceBrandPerCategory();

    @Query(value = """
                SELECT new com.musinsa.codi.core.infrastructure.repository.product.dto.CodiBrandDto(brandId, brandName, totalPrice)
                FROM ( SELECT  brandId as brandId, brandName as brandName, sum(sub.price) as totalPrice
                       FROM (
                            SELECT PROD.brandId as brandId,
                                    BRAND.brandName as brandName,
                                    PROD.price as price,
                                    ROW_NUMBER() OVER (PARTITION BY PROD.brandId, PROD.categoryType ORDER BY PROD.price, PROD.productId asc) as priceRank,
                                    COUNT(PROD.categoryType) OVER (PARTITION BY PROD.brandId) as cnt
                            FROM Product PROD
                            JOIN Brand BRAND
                            ON PROD.brandId = BRAND.brandId
                            WHERE BRAND.brandStatus = 'USE'
                            AND PROD.productStatus = 'USE'
                       ) as sub
                       WHERE sub.priceRank = 1
                       AND sub.cnt = (SELECT COUNT(1) FROM Category)
                       GROUP BY sub.brandId, sub.brandName
                       ORDER BY sum(sub.price) asc
                ) as main
            """
    )

    List<CodiBrandDto> getCodiEnableBrandList();
}
