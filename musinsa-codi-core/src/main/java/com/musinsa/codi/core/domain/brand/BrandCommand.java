package com.musinsa.codi.core.domain.brand;

import com.musinsa.codi.core.enums.StatusType;
import lombok.Builder;
import lombok.Getter;

public class BrandCommand {


    @Getter
    @Builder
    public static class RegisterBrand {

        private final String brandName;
        private final String regUser;
        private final String updUser;

        public Brand toEntity() {
            return Brand.builder()
                    .brandStatus(StatusType.CREATE)
                    .brandName(brandName)
                    .regUser(regUser)
                    .updUser(updUser)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class UpdateBrand {

        private final StatusType brandStatus;
        private final String brandName;
        private final String updUser;

    }

    @Getter
    @Builder
    public static class SearchBrand {
        private final Long brandId;
        private final String brandStatus;
        private final String brandName;
    }
}
