package com.danlu.dmall.persist.dao;

import com.danlu.dmall.persist.entity.ProductExtend;

public interface ProductExtendMapper {
    int deleteByPrimaryKey(Long productExtendId);

    int insert(ProductExtend productExtend);

    int insertSelective(ProductExtend productExtend);

    ProductExtend selectByPrimaryKey(Long productExtendId);

    ProductExtend selectByProductId(Long productId);

    int updateByPrimaryKeySelective(ProductExtend productExtend);

    int updateByPrimaryKeyWithBLOBs(ProductExtend productExtend);

    int updateByPrimaryKey(ProductExtend productExtend);
}