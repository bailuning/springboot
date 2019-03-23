package com.bailuning.operation.service;

import com.bailuning.operation.entity.Link;

/**
 * @author bailuning
 * @email bailuning@inglemirepharm.com
 * @date 2019-03-23 12:36:00
 */
public interface LinkService {
    String save(Link link);

    String restoreUrl(String url);
}
