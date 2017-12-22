package com.danlu.dmall.persist.dao;

import com.danlu.dmall.persist.entity.BrandBase;

public interface BrandBaseMapper {
    int deleteByPrimaryKey(Long brandId);

    int insert(BrandBase record);

    int insertSelective(BrandBase record);

    BrandBase selectByPrimaryKey(Long brandId);

    int updateByPrimaryKeySelective(BrandBase record);

    int updateByPrimaryKey(BrandBase record);
}