package com.wushen.ossservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 @descriptions
 @author wushen
 @create 2020-08-01 7:49
 */
public interface OssService {
    String uploadAvatarFill(MultipartFile file);
}
