package com.dekuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    /*
        单文件上传
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(String userName, MultipartFile filePic) throws IOException {

        System.out.println(userName);
        //获取表单提交参数，完成文件上传
        String originalFilename = filePic.getOriginalFilename();    //获取原始的文件上传名

        filePic.transferTo(new File("E:/upload/"+originalFilename));

        return "success";
    }
    /*
        多文件上传
     */
    @RequestMapping("/filesUpload")
    public String filesUpload(String userName, MultipartFile[] filePic) throws IOException {

        System.out.println(userName);
        for (MultipartFile multipartFile : filePic) {

            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("E:\\upload\\"+originalFilename));

        }
        return "success";
    }
}
