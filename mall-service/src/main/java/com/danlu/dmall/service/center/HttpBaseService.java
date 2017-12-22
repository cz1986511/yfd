package com.danlu.dmall.service.center;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONObject;
import com.danlu.dlcommon.logger.Logger;
import com.danlu.dlcommon.logger.LoggerFactory;
import com.danlu.dlcommon.result.JsonPage;
import com.danlu.dlcommon.result.JsonResult;
import com.danlu.dlcommon.utils.CenterBase;
import com.danlu.dlhttpx.HttpService;

public abstract class HttpBaseService {
    private static final Logger logger = LoggerFactory.getLogger(HttpBaseService.class);
    public static final String API_VERSION_KEY = "X-ApiVersion";
    public static final String API_VERSION_VALUE = "1.0";

    public <T> T postJson4Entity(String uri, HttpHeaders requestHeaders,
                                 ParameterizedTypeReference<T> typeReference,
                                 Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().postJson4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T postJson4Entity(String uri, HttpHeaders requestHeaders, Object requestBody,
                                 ParameterizedTypeReference<T> typeReference,
                                 Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().postJson4Entity(uri,
            requestHeaders, requestBody, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T deleteJson4Entity(String uri, HttpHeaders requestHeaders,
                                   ParameterizedTypeReference<T> typeReference,
                                   Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().deleteJson4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T putJson4Entity(String uri, HttpHeaders requestHeaders,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().putJson4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T putJson4Entity(String uri, HttpHeaders requestHeaders, Object requestBody,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().putJson4Entity(uri,
            requestHeaders, requestBody, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T patchJson4Entity(String uri, HttpHeaders requestHeaders,
                                  ParameterizedTypeReference<T> typeReference,
                                  Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().patchJson4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T patchJson4Entity(String uri, HttpHeaders requestHeaders, Object requestBody,
                                  ParameterizedTypeReference<T> typeReference,
                                  Map<String, Object> uriVariables) {
        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().patchJson4Entity(uri,
            requestHeaders, requestBody, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T getJson4Entity(String uri, HttpHeaders requestHeaders,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {
        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().getJson4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T postText4Entity(String uri, HttpHeaders requestHeaders,
                                 Map<String, String> requestBody,
                                 ParameterizedTypeReference<T> typeReference,
                                 Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().postText4Entity(uri,
            requestHeaders, this.convertToMultiValueMap(requestBody), typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T deleteText4Entity(String uri, HttpHeaders requestHeaders,
                                   ParameterizedTypeReference<T> typeReference,
                                   Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().deleteText4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T deleteText4Entity(String uri, HttpHeaders requestHeaders,
                                   Map<String, String> requestBody,
                                   ParameterizedTypeReference<T> typeReference,
                                   Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().deleteText4Entity(uri,
            requestHeaders, this.convertToMultiValueMap(requestBody), typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T putText4Entity(String uri, HttpHeaders requestHeaders,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().putText4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T putText4Entity(String uri, HttpHeaders requestHeaders,
                                Map<String, String> requestBody,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().putText4Entity(uri,
            requestHeaders, this.convertToMultiValueMap(requestBody), typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    public <T> T getText4Entity(String uri, HttpHeaders requestHeaders,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, new HashMap<String, String>(), typeReference,
            uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().getText4Entity(uri,
            requestHeaders, typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    /**
     * 
     * @param uri
     * @param requestHeaders
     * @param requestBody
     * @param typeReference
     * @param uriVariables
     * @return
     */
    public <T> T getText4Entity(String uri, HttpHeaders requestHeaders,
                                Map<String, String> requestBody,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {

        this.printParms(uri, requestHeaders, requestBody, typeReference, uriVariables);
        ResponseEntity<T> responseEntity = this.getHttpService().getText4Entity(uri,
            requestHeaders, this.convertToMultiValueMap(requestBody), typeReference, uriVariables);
        this.validateHttpResult(responseEntity, uri);
        return responseEntity.getBody();
    }

    private MultiValueMap<String, String> convertToMultiValueMap(Map<String, String> requestBody) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        if (requestBody != null) {
            logger.debug("转换前requestBody参数个数=>{},requestBody=>{}", requestBody.size(), requestBody);
            body.setAll(requestBody);
            logger.debug("转换后requestBody参数个数=>{},requestBody=>{}", body.size(), body);
        }
        return body;
    }

    private <T> void printParms(String uri, HttpHeaders requestHeaders, Object requestBody,
                                ParameterizedTypeReference<T> typeReference,
                                Map<String, Object> uriVariables) {
        logger.info(
            "调用uri=> {},requestHeaders=> {},requestBody=> {},typeReference=> {},uriVariables=> {}",
            uri, requestHeaders, requestBody, typeReference, uriVariables);
    }

    protected <T> void validateHttpResult(ResponseEntity<T> responseEntity, String uri) {
        if (responseEntity == null) {
            logger.error("调用 {} 返回responseEntity为空.", uri);
            throw new NullPointerException("调用  " + uri + " 返回responseEntity为空..");
        }
        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.error("调用{} 失败.responseEntity=>{}.", uri, responseEntity);
            throw new RuntimeException("调用" + uri + "失败.http状态码=>{}:"
                                       + responseEntity.getStatusCode());
        }
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(API_VERSION_KEY, API_VERSION_VALUE);
        return headers;
    }

    public String getUrl(String uri) {
        return CenterBase.build(this.getRootPath(), uri);
    }

    /**
     * @param msg 接口名称或者接口描述
     * 
     * **/
    public <T> T parseJsonResult(JsonResult<T> result, String msg) {
        if (null != result && 0 == result.getStatus()) {
            return result.getData();
        } else {
            logger.info("{}[失败].result={}", msg, JSONObject.toJSON(result));
            throw new RuntimeException("ERROR:" + msg);
        }
    }

    /**
     * @param msg 接口名称或者接口描述
     * 
     * **/
    public <T> T parseJsonPage(JsonPage<T> result, String msg) {
        if (null != result && 0 == result.getStatus()) {
            return result.getData_list();
        } else {
            logger.info("{}[失败].result={}", msg, JSONObject.toJSON(result));
            throw new RuntimeException("ERROR:" + msg);
        }
    }

    public <T> Map<String, Object> parseJsonPageReturnMap(JsonPage<T> result, String msg) {
        if (null != result && 0 == result.getStatus()) {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("data", result.getData_list());
            resultMap.put("count", result.getTotal());
            return resultMap;
        } else {
            logger.info("{}[失败].result={}", msg, JSONObject.toJSON(result));
            throw new RuntimeException("ERROR:" + msg);
        }
    }

    protected abstract String getRootPath();

    protected abstract HttpService getHttpService();
}
