package com.danlu.dmall.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.danlu.dlcodis.ICodisSerivce;
import com.danlu.dlcommon.logger.Logger;
import com.danlu.dlcommon.logger.LoggerFactory;
import com.danlu.dlcommon.utils.DlBeanUtils;
import com.danlu.dmall.client.entity.ItemInfo;
import com.danlu.dmall.core.ItemBaseManager;
import com.danlu.dmall.core.ProductExtendManager;
import com.danlu.dmall.persist.entity.ItemBase;
import com.danlu.dmall.persist.entity.ProductExtend;
import com.danlu.dmall.service.ItemService;
import com.danlu.dmall.service.SolrService;

public class ItemServiceImpl implements ItemService
{

    private final static Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemBaseManager itemManager;
    @Autowired
    private ProductExtendManager productExtendManager;
    @Autowired
    private ICodisSerivce codisService;
    @Autowired
    private SolrService solrService;

    @Override
    public ItemInfo getItemById(Long itemId)
    {
        ItemInfo itemInfo = null;
        if (null != itemId && itemId > 0)
        {
            itemInfo = codisService.get(String.valueOf(itemId), new TypeReference<ItemInfo>()
            {
            });
            if (null == itemInfo)
            {
                itemInfo = getItemInfo(itemId);
                if (null != itemInfo)
                {
                    codisService.set(String.valueOf(itemId), itemInfo, 600);
                }
                else
                {
                    log.info("getItemById id is null|id:" + itemId);
                }
            }
        }
        return itemInfo;
    }

    @Override
    public List<ItemInfo> getItemsByParams(Map<String, Object> inputData)
    {

        return new ArrayList<ItemInfo>();
    }

    private ItemInfo getItemInfo(Long itemId)
    {
        ItemInfo itemInfo = null;
        ProductExtend productExtend = null;
        try
        {
            ItemBase itemBase = itemManager.getItemBaseById(itemId);
            if (null != itemBase)
            {
                Long productId = itemBase.getItemProductId();
                itemInfo = new ItemInfo();
                DlBeanUtils.copyProperties(itemBase, itemInfo);
                productExtend = codisService.get(String.valueOf(productId) + "-extend",
                    new TypeReference<ProductExtend>()
                    {
                    });
                if (null == productExtend)
                {
                    productExtend = productExtendManager.getProductExtendByProductId(productId);
                    if (null != productExtend)
                    {
                        codisService
                            .set(String.valueOf(productId) + "-extend", productExtend, 3600);
                    }
                }
                if (null != productExtend)
                {
                    itemInfo.setItemCoverPic(productExtend.getProductCoverPic());
                    itemInfo.setItemDetailPic(productExtend.getProductDetailPic());
                    itemInfo.setItemDetailInfo(productExtend.getProductDetailInfo());
                }
            }
        }
        catch (Exception e)
        {
            log.error("getItemInfo is Exception:" + e.getMessage());
        }
        return itemInfo;
    }

    @Override
    public JSONObject getItemsByParamsFromSolr(Map<String, Object> inputData)
    {
        return solrService.searchItemInfos(inputData);
    }

}
