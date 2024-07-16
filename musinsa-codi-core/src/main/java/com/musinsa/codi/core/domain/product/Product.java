package com.musinsa.codi.core.domain.product;

import com.musinsa.codi.core.domain.common.CommonEntity;
import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MUSINSA_PRODUCT")
public class Product extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_STATUS")
    private StatusType productStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY_TYPE")
    private CategoryType categoryType;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "UPD_USER")
    private String updUser;

  /*  @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private Brand brand;*/

    @Builder
    public Product(StatusType productStatus, CategoryType categoryType, String productName, Long brandId, Long price, String regUser, String updUser) {
        this.productStatus = productStatus;
        this.categoryType = categoryType;
        this.productName = productName;
        this.brandId = brandId;
        this.price = price;
        this.regUser = regUser;
        this.updUser = updUser;
    }

    public void update(ProductCommand.UpdateProduct update) {
        this.productStatus = update.getProductStatus();
        this.categoryType = update.getCategoryType();
        this.productName = update.getProductName();
        this.brandId = update.getBrandId();
        this.price = update.getPrice();
        this.updUser = update.getUpdUser();
    }

    public void delete(String userId) {
        this.productStatus = StatusType.DELETE;
        this.updUser = userId;
    }
}
