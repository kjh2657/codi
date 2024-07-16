package com.musinsa.codi.core.domain.category;

import com.musinsa.codi.core.domain.common.CommonEntity;
import com.musinsa.codi.core.enums.CategoryType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MUSINSA_CATEGORY")
public class Category extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY_TYPE")
    private CategoryType categoryType;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "SORT")
    private int sort;

    @Column(name = "REG_USER")
    private String regUser;

    @Column(name = "UPD_USER")
    private String updUser;


    @Builder
    public Category(CategoryType categoryType, String categoryName, int sort, String regUser, String updUser) {
        this.categoryType = categoryType;
        this.categoryName = categoryName;
        this.sort = sort;
        this.regUser = regUser;
        this.updUser = updUser;
    }
}
