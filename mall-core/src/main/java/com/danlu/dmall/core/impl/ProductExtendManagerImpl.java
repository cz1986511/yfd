package com.danlu.dmall.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.danlu.dmall.core.ProductExtendManager;
import com.danlu.dmall.persist.dao.ProductExtendMapper;
import com.danlu.dmall.persist.entity.ProductExtend;

public class ProductExtendManagerImpl implements ProductExtendManager {

    @Autowired
    private ProductExtendMapper productExtendMapper;

    @Override
    public ProductExtend getProductExtendByProductId(Long productId) {
        if (null != productId && productId > 0) {
            return productExtendMapper.selectByProductId(productId);
        }
        return null;
    }

}
