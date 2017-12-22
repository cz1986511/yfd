package com.danlu.dmall.persist.dao;

import com.danlu.dmall.persist.entity.CategoryBase;

public interface CategoryBaseMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(CategoryBase record);

    int insertSelective(CategoryBase record);

    CategoryBase selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(CategoryBase record);

    int updateByPrimaryKey(CategoryBase record);
}