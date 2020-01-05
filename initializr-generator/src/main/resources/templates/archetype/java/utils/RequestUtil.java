package {{packageName}}.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhayujie
 * @description 基于RestTemplates实现的http工具类
 * @date 2019/12/14
 */
@Slf4j
public class RequestUtil {
    private final static int SUCCESS_CODE = 200;

    private static SimpleClientHttpRequestFactory getFactory(int secondTimeOut) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(secondTimeOut * 1000);
        requestFactory.setReadTimeout(secondTimeOut * 1000);
        return requestFactory;
    }

    public static String doGet(String url) {
        return doGetRequest(url, null);
    }

    public static String doGet(String url, Map<String, String> headerMap) {
        return doGetRequest(url, headerMap);
    }

    private static String doGetRequest(String url, Map<String, String> headerMap) {
        // 设置超时时间
        RestTemplate client = new RestTemplate(getFactory(3));
        HttpEntity<String> requestEntity;
        if (headerMap != null) {
            HttpHeaders httpHeaders = new HttpHeaders();
            for (Map.Entry<String, String> entry: headerMap.entrySet()) {
                httpHeaders.add(entry.getKey(), entry.getValue());
            }
            requestEntity = new HttpEntity<>(httpHeaders);
        } else {
            requestEntity = new HttpEntity<>(null, null);
        }
        try {
            ResponseEntity<String> response = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
            // 注意：一般情况下状态码不为200时会直接抛出异常
            return response.getBody();
        } catch (Exception e) {
            log.error("Get调用异常： " + e.getMessage());
            return null;
        }
    }

    public static String doPostJson(String url, Object args) {
        RestTemplate client = new RestTemplate(getFactory(3));
        HttpHeaders headers = new HttpHeaders();
        // 发送格式为json
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(args, headers);
        try {
            ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);
            return response.getBody();
        } catch (Exception e) {
            log.error("Post调用异常： " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String res = RequestUtil.doGet("http://www.zhayujie.com");
        System.out.println(res);
    }
}