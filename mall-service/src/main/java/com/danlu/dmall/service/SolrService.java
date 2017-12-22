package com.danlu.dmall.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface SolrService
{
    JSONObject searchItemInfos(Map<String, Object> map);
}
