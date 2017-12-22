package com.danlu.dmall.core.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.danlu.dmall.core.ItemBaseManager;
import com.danlu.dmall.persist.dao.ItemBaseMapper;
import com.danlu.dmall.persist.entity.ItemBase;

public class ItemBaseManagerImpl implements ItemBaseManager {

    @Autowired
    private ItemBaseMapper itemBaseMapper;

    @Override
    public List<ItemBase> getItemBasesByParams(Map<String, Object> map) {
        if (!CollectionUtils.isEmpty(map)) {
            return itemBaseMapper.selectByParams(map);
        }
        return null;
    }

    @Override
    public ItemBase getItemBaseById(Long itemId) {
        if (null != itemId && itemId > 0) {
            return itemBaseMapper.selectByPrimaryKey(itemId);
        }
        return null;
    }

}
