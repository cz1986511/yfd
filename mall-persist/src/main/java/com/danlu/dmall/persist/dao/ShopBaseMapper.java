package com.danlu.dmall.persist.dao;

import java.util.List;
import java.util.Map;

import com.danlu.dmall.persist.entity.ShopBase;

public interface ShopBaseMapper {
    int deleteByPrimaryKey(Long shopId);

    int insert(ShopBase shopBase);

    int insertSelective(ShopBase shopBase);

    ShopBase selectByPrimaryKey(Long shopId);

    int updateByPrimaryKeySelective(ShopBase shopBase);

    int updateByPrimaryKey(ShopBase shopBase);

    List<ShopBase> selectByParams(Map<String, Object> map);
}