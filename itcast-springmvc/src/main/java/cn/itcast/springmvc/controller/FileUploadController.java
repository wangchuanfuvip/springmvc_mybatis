package cn.itcast.springmvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
@RequestMapping("/file")
@Controller
public class FileUploadController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        if (multipartFile != null) {
            // multipartFile.getOriginalFilename() 获取文件的原始名称
            multipartFile.transferTo(new File("C:\\tmp\\" + multipartFile.getOriginalFilename()));
        }
        //页面重定向
        return "redirect:/success.html";
    }
}
