package com.danlu.dmall.core;

import com.danlu.dmall.persist.entity.ProductExtend;

/**
 * @author chenzhuo@danlu.com
 * @date 2017-09-26 15:09
 * 
 */
public interface ProductExtendManager {

    ProductExtend getProductExtendByProductId(Long productId);

}
