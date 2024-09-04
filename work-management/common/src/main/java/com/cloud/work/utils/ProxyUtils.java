package com.cloud.work.utils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ProxyUtils {

    public static String prepareParam(String url, Map<String, Object> param) {
        if (param != null && param.containsKey("param")) {
            Map<String, String> header = (Map<String, String>) param.get("param");
            StringBuilder urlBuilder = new StringBuilder(url);
            for (Map.Entry<String, String> entry : header.entrySet()) {
                if (urlBuilder.toString().contains("?")) {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                } else {
                    urlBuilder.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
            url = urlBuilder.toString();
        }
        return url;
    }

    public static Map<String, String> prepareHeader(Map<String, Object> param) {
        if (param != null && param.containsKey("header")) {
            return (Map<String, String>) param.get("header");
        }
        return new HashMap<>();
    }

    public static Object prepareBody(Map<String, Object> param) {
        if (param != null && param.containsKey("body")) {
            return param.getOrDefault("body", null);
        }
        return null;
    }
}
