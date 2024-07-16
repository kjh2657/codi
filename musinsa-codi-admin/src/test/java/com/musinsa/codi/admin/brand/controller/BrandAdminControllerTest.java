package com.musinsa.codi.admin.brand.controller;

import com.musinsa.codi.admin.brand.controller.dto.BrandInfoAdminRes;
import com.musinsa.codi.admin.brand.service.BrandAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BrandAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandAdminService brandAdminService;

    @Test
    void getBrand() throws Exception {
//        when(brandAdminService.getBrand(1L)).thenReturn(1L);

        BrandInfoAdminRes res = new BrandInfoAdminRes();

        when(brandAdminService.getBrand(1L)).thenReturn(res);

        String url = "/codi/admin/v1/brand/{brandId}";

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get(url, 1))
                .andExpect(status().isOk());

    }
}
