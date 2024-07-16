package com.musinsa.codi.core.domain.brand;

import com.musinsa.codi.core.enums.StatusType;
import com.musinsa.codi.core.exception.BaseException;
import com.musinsa.codi.core.infrastructure.repository.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.musinsa.codi.core.response.ErrorCode.BRAND_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    /**
     * 브랜드 단일 조회
     * @param brandId
     * @return
     */
    public BrandInfo findBrand(Long brandId) {
        Brand brand = findNotDeleteBrand(brandId);
        return brandMapper.toBrandInfo(brand);
    }

    /**
     * 브랜드 등록
     * @param brand
     * @return
     */
    public BrandInfo saveBrand(BrandCommand.RegisterBrand brand) {
        Brand save = brandRepository.save(brand.toEntity());
        return brandMapper.toBrandInfo(save);
    }

    /**
     * 브랜드 수정
     * @param brandId
     * @param updateBrand
     */
    public void updateBrand(Long brandId, BrandCommand.UpdateBrand updateBrand) {
        Brand brand = findNotDeleteBrand(brandId);
        brand.update(updateBrand);
    }

    /**
     * 브랜드 삭제
     * @param brandId
     * @param userId
     */
    public void deleteBrand(Long brandId, String userId) {
        Brand brand = findNotDeleteBrand(brandId);
        brand.delete(userId);
    }


    /**
     * 브랜드 리스트 조회
     * @param pageable
     * @param req
     * @return
     */
    public Page<BrandInfo> findBrandList(PageRequest pageable, BrandCommand.SearchBrand req) {
        return brandRepository.findBrandList(pageable, req);
    }

    /**
     * 삭제되지 않은 브랜드 조회
     * @param brandId
     * @return
     */
    private Brand findNotDeleteBrand(Long brandId) {
        Brand brand = brandRepository.findByBrandIdAndBrandStatusNot(brandId, StatusType.DELETE);

        if(brand == null) {
            throw new BaseException(BRAND_NOT_FOUND);
        }
        return brand;
    }
}
