package com.danlu.dmall.service.center;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import com.danlu.dlcommon.result.JsonResult;
import com.danlu.dlcommon.utils.CenterBase;
import com.danlu.dlhttpx.HttpService;
import com.danlu.dlpublic.dto.AreaDTO;

public class AreaHttpService extends HttpBaseService {

    @Autowired
    private HttpService httpService;

    public List<AreaDTO> getAreaListByAmapCodeList(List<String> amapCodeList) {
        List<AreaDTO> result = new ArrayList<AreaDTO>();
        JsonResult<List<AreaDTO>> responseBody = null;

        responseBody = this.postJson4Entity(this.getUrl("/public/V1/area_list/amap"),
            this.getHttpHeaders(), amapCodeList,
            new ParameterizedTypeReference<JsonResult<List<AreaDTO>>>() {
            }, null);
        if (null != responseBody) {
            result = responseBody.getData();
        }
        return result;
    }

    public List<AreaDTO> getAreaListByParentCode(String areaParentCode) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("areaParentCode", areaParentCode);
        JsonResult<List<AreaDTO>> result = this.getText4Entity(
            this.getUrl("/public/V1/area_list/code"), this.getHttpHeaders(), paramMap,
            new ParameterizedTypeReference<JsonResult<List<AreaDTO>>>() {
            }, null);
        if (null != result) {
            return result.getData();
        } else {
            return null;
        }
    }

    @Override
    protected String getRootPath() {
        return CenterBase.publicBase;
    }

    @Override
    protected HttpService getHttpService() {
        return this.httpService;
    }

}
