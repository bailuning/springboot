package com.bailuning.operation.mapper;

/**
 * @author bailuning
 * @email bailuning@inglemirepharm.com
 * @date 2019-03-23 12:35:00
 */
import com.bailuning.operation.entity.Link;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinkMapper {

    Link selectByPrimaryKey(Integer id);

    int insert(Link link);

    Link findByLongUrl(String longUrl);

    String findByShortUrl(String shortUrl);
}