package com.schoolsystem.controller;

import com.aliyuncs.exceptions.ClientException;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    /**
     * 阿里云OSS文件存储
     * @param image
     * @return
     */

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile avatar) throws IOException, ClientException {
        log.info("文件上传，文件名：{}",avatar.getOriginalFilename());

        String url = aliOSSUtils.upload(avatar);

        log.info("图片上传成功，文件访问的url为：{}",url);

        return Result.success(url);
    }
}
