package com.bailuning.operation.entity;

import lombok.Data;

/**
 * @author bailuning
 * @email bailuning@inglemirepharm.com
 * @date 2019-03-23 15:27:00
 */
@Data
public class WeiBoEntity {
    /*
     *结果状态
     */
    private  boolean result;
    /**
     *短链接
     */
    private  String url_short;
    /**
     *长链接
     */
    private  String url_long;
    /**
     *类型 链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票
     */
    private  Integer type;
    /**
     *
     */
    private  String object_type;
    /**
     *
     */
    private  String object_id;
}
