package com.musinsa.codi.core.domain.product;

import com.musinsa.codi.core.enums.CategoryType;
import com.musinsa.codi.core.enums.StatusType;
import lombok.Builder;
import lombok.Getter;

public class ProductCommand {

    @Getter
    @Builder
    public static class RegisterProduct {

        private final CategoryType categoryType;
        private final String productName;
        private final Long brandId;
        private final Long price;
        private final String regUser;
        private final String updUser;

        public Product toEntity() {
            return Product.builder()
                    .productStatus(StatusType.CREATE)
                    .categoryType(categoryType)
                    .productName(productName)
                    .brandId(brandId)
                    .price(price)
                    .regUser(regUser)
                    .updUser(updUser)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class UpdateProduct {

        private final StatusType productStatus;
        private final CategoryType categoryType;
        private final String productName;
        private final Long brandId;
        private final Long price;
        private final String updUser;

    }

    @Getter
    @Builder
    public static class SearchProduct {
        private final Long productId;
        private final String productStatus;
        private final String productName;
        private final Long brandId;
        private final String categoryType;
    }
}
