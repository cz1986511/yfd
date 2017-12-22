package com.danlu.dmall.persist.dao;

import com.danlu.dmall.persist.entity.ProductBase;

public interface ProductBaseMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(ProductBase record);

    int insertSelective(ProductBase record);

    ProductBase selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(ProductBase record);

    int updateByPrimaryKey(ProductBase record);
}