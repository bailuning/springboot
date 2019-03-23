package com.bailuning.operation.controller;

import com.bailuning.operation.code.exception.CommonException;
import com.bailuning.operation.code.exception.LinkExceptionEnum;
import com.bailuning.operation.entity.Link;
import com.bailuning.operation.service.LinkService;
import com.bailuning.operation.service.impl.LinkServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bailuning
 * @email bailuning@inglemirepharm.com
 * @date 2019-03-23 12:50:00
 */
@Controller
public class LinkController {

    Logger logger = LoggerFactory.getLogger(LinkServiceImpl.class);
    @Autowired
    private LinkService linkService;

    /**
     * 生成短链接
     * @param url
     * @return Caron
     */
    @RequestMapping("/api")
    @ResponseBody
    public Object save(String url){

        if (StringUtils.isBlank(url)){
            throw new CommonException(LinkExceptionEnum.LONG_LINK_EXCEPTION);
        }
        if(url.startsWith("http://") || url.startsWith("https://")){
            Link link = new Link();
            link.setLongUrl("http://test.inglemirepharmmall.com/?inviteCode=wpyatg&shareUserId=1283&share=h5#/upgradeMember?fromPage=share");
            return  linkService.save(link);
        }else{
            throw new CommonException(LinkExceptionEnum.HTTP_LINK_EXCEPTION);
        }
    }

    /**
     * 301跳转
     * @param url
     * @return
     */
    @RequestMapping("/{url}")
    public String restoreUrl(@PathVariable("url") String url){

        String restoreUrl = linkService.restoreUrl("http://192.168.3.122/"+url);

        if(StringUtils.isNotBlank(restoreUrl)){
            return "redirect:"+restoreUrl;
        }else{
            return "www.baidu.com";
//            return  "forward:/404.html";    //如果要访问本地html，@RequestMapping("/{url}")前面必须加一层路径/aa/{url}
        }

    }

    /**
     * 长链接转短链接
     */
//    @ResponseBody
//    @RequestMapping(value = "/getShortUrl4Jsonp", method = {RequestMethod.GET, RequestMethod.POST})
//    public String getShortUrl4Jsonp(HttpServletRequest request, @RequestParam(value = "longUrl", required = true) String longUrl, String callback) {
//        logger.info("-----------长链接转短链接开始-----------");
//        Long startTime = System.currentTimeMillis();
//        logger.info("开始时间：" + startTime);
//        //微信长链接转短链接接口每日调用上限1000，故先使用新浪微博获取
//        String shortUrl = commonService.getShortUrlByWeiboApi(longUrl);
//        //使用新浪微博转短链接失败后，使用微信长链接转短链接
//        if (StringUtils.isEmpty(shortUrl)) {
//            //获取Spring.xml中配置的mpId
//            String mpId = ((WcGlobalVar) applicationContext.getBean("wcGlobalVar")).getInitKey();
//            try {
//                Mp mp = mpService.getMp(mpId);
//                String accessToken = mpService.getMpAccessToken(mp);
//                shortUrl = commonService.getShortUrl(accessToken, longUrl);
//                Map<String, String> jsonMap = new LinkedHashMap<>();
//                jsonMap.put("shortUrl", shortUrl);
//                jsonMap.put("longUrl", longUrl);
//                String jsonp = callback + "(" + JSON.toJSON(jsonMap) + ")";
//            }
//            Long endTime = System.currentTimeMillis();
//            logger.info("结束时间：" + endTime);
//            logger.info("耗时：" + (endTime - startTime));
//            logger.info("-----------长链接转短链接结束-----------");
//            return jsonp;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    /**
//     * 新浪微博API长链接转短链接
//     *	#新浪微博长链接转短链接请求地址
//     *	weibo.longToShortBaseUrl = http://api.weibo.com/2/short_url/shorten.json?source=APP_KEY&url_long=URL_LONG
//     *	#iPad新浪客户端App Key：2849184197 iphone新浪微博客户端 App Key：5786724301 Google.Nexus浪客户端App Key：1206405345 周博通微博管家App Key：202088835
//     *	weibo.appKey = 2849184197
//     *
//     */
//    public String getShortUrlByWeiboApi(String longUrl) {
//        String longToShortUrl = WcConfig.getInstance().getValue("weibo.longToShortBaseUrl")
//                .replace("APP_KEY", WcConfig.getInstance().getValue("weibo.appKey"))
//                .replace("URL_LONG", longUrl);
//        String shortUrl = null;
//        try {
//            logger.info("getShortUrlByWeiboApi ---- 长链接地址：" + longUrl);
//            String respJsonStr = HttpUtil.reqJsonGet(longToShortUrl);
//            logger.info("getShortUrlByWeiboApi ---- 长链接地址响应" + respJsonStr);
//            JSONObject respJson = JSONObject.parseObject(respJsonStr);
//            JSONArray jsonArray = respJson.getJSONArray("urls");
//            JSONObject respJO = jsonArray.getJSONObject(0);
//            /*url_short	string	短链接    url_long	string	原始长链接  type	int	链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票 */
//            String result = respJO.getString("result");
//            String type = respJO.getString("type");
//            logger.info("getShortUrlByWeiboApi ---- 长链接地址响应结果  result ----" + result + "-----" + type + "----url_long---" + respJO.getString("url_long") + "----url_short---" + respJO.getString("url_short"));
//            if (StringUtil.equals("true", result)) {
//                shortUrl = respJO.getString("url_short");
//            } else {
//                shortUrl = "";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            shortUrl = "";
//        }
//        return shortUrl;
//    }
}
