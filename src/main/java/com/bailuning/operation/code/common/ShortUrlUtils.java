package com.bailuning.operation.code.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bailuning.operation.service.impl.LinkServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ShortUrlUtils {

    static Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);

    /**
     * 生成端短连接信息 app_key 202088835 2174119991
     */
    public static String getWeiBoShortUrl(String url) {
        try {
            url = URLEncoder.encode(url, "utf-8");
            String jsonStr = HttpUtils.get("https://api.weibo.com/2/short_url/shorten.json?source=202088835&url_long=" + url);
            jsonStr = shortUrl(jsonStr,url);
            System.out.println(jsonStr);
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }

    }

    /**
     *
     * @param shortUrl
     * @param longUrl
     * @return
     */
    private static String shortUrl(String shortUrl,String longUrl) {
        JSONObject respJson = JSONObject.parseObject(shortUrl);
        JSONArray jsonArray = respJson.getJSONArray("urls");
        JSONObject respJO = jsonArray.getJSONObject(0);
        String result = respJO.getString("result");
        if (StringUtils.equals("true", result)) {
            shortUrl = respJO.getString("url_short");
        } else {
            return longUrl;

        }
        return  shortUrl;
    }


    /**
     * 测试生成端连接
     *
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String urlStr = "http://test.inglemirepharmmall.com/?inviteCode=wpyatg&shareUserId=1283&share=h5#/upgradeMember?fromPage=share";
        getWeiBoShortUrl(urlStr);
    }

}
