package com.bailuning.operation.entity;

/**
 * @author bailuning
 * @email bailuning@inglemirepharm.com
 * @date 2019-03-23 12:34:00
 */
public class Link {

    private Integer id;
    private String longUrl;
    private String shortUrl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}