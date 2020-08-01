package com.wushen.ossservice.controller;

import com.wushen.commonutils.R;
import com.wushen.ossservice.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 @descriptions
 @author wushen
 @create 2020-08-01 7:47
 */
@Api(value = "头像上传",tags = "根据OSS进行头像上传")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    @ApiOperation(value = "文件上传至阿里OSS")
    @PostMapping
    /**
     * @Description: 上传图像方法,存储到阿里OSS中
     * @Author: wushen @RequestParam (value = "file")必须和请求参数的file名称一致！！！
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date:  2020/7/16 8:19
     * @Parameters:  * @param file 要上传的文件
     * @Return com.wushen.commonutils.R 返回文件路径
     * @Throws
     */
    public R uploadOssFill(@ApiParam(name = "file",value = "文件上传",required = true)
                           MultipartFile file){
        String url = ossService.uploadAvatarFill(file);
        return R.ok().data("url",url);
    }
}
