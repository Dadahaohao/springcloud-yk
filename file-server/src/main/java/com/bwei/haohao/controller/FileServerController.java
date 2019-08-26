package com.bwei.haohao.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
@CrossOrigin
public class FileServerController {

    @RequestMapping("fileUpload")
    public String FileUpLoad(@RequestParam(value = "file",required = false)MultipartFile file){

        boolean empty = file.isEmpty();
        if(!empty) {
            //获取到传来的文件的名称
            File file1 = new File(file.getOriginalFilename());
            //选择   存储的路径
            File file2 = new File("D:\\uppic\\" + file1.getName());
            try {
                //文件输出流
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                //文件输入流
                InputStream inputStream = file.getInputStream();
                //执行拷贝
                FileCopyUtils.copy(inputStream, fileOutputStream);
                return file2.getAbsolutePath();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  "";
    }

}
