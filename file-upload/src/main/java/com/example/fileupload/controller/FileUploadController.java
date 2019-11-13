package com.example.fileupload.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.example.fileupload.util.FileCopy;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    /**
     * 上传文件
     * 测试方法：
     * 有界面的测试：http://localhost:8050/index.html
     * 使用命令：curl -F "file=@文件全名" localhost:8050/upload
     * ps.该示例比较简单，没有做IO异常、文件大小、文件非空等处理
     *
     * @param file 待上传的文件
     * @return 文件在服务器上的绝对路径
     * @throws IOException IO异常
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
//        File tempFile = new File(file.getOriginalFilename());
        String path = "G://upload/" + file.getOriginalFilename();
        file.transferTo(new java.io.File(path));
        return path;
    }
}
