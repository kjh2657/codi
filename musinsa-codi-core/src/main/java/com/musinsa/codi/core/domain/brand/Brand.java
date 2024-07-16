package com.musinsa.codi.core.domain.brand;

import com.musinsa.codi.core.domain.common.CommonEntity;
import com.musinsa.codi.core.domain.product.Product;
import com.musinsa.codi.core.enums.StatusType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MUSINSA_BRAND")
public class Brand extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Enumerated(EnumType.STRING)
    @Column(name = "BRAND_STATUS")
    private StatusType brandStatus;

    @Column(name = "BRAND_NAME")
    private String brandName;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "UPD_USER")
    private String updUser;

    /*@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private List<Product> brandProductList = new ArrayList<>();
*/

    @Builder
    public Brand(StatusType brandStatus, String brandName, String regUser, String updUser) {
        this.brandStatus = brandStatus;
        this.brandName = brandName;
        this.regUser = regUser;
        this.updUser = updUser;
    }

    public void update(BrandCommand.UpdateBrand update) {
        this.brandStatus = update.getBrandStatus();
        this.brandName = update.getBrandName();
        this.updUser = update.getUpdUser();
    }

    public void delete(String userId) {
        this.brandStatus = StatusType.DELETE;
        this.updUser = userId;
    }
}
