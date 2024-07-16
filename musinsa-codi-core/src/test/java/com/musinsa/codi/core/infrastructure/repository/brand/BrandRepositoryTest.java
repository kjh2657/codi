package com.musinsa.codi.core.infrastructure.repository.brand;

import com.musinsa.codi.core.domain.brand.Brand;
import com.musinsa.codi.core.enums.StatusType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void findBrand() {
        //given
        Brand save = brandRepository.save(Brand.builder().brandName("O").brandStatus(StatusType.CREATE).regUser("K").updUser("K").build());

        //when
        Brand findBrand = brandRepository.findById(save.getBrandId()).orElseThrow(() -> new RuntimeException("BRAND 조회 실패"));

        Assertions.assertThat(findBrand.getBrandName().equals("O"));
    }


}
