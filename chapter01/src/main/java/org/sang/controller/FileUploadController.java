package org.sang.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileUploadController.class);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile , HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        logger.info("上傳的文件名為:" + oldName);
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("創建的新文件名為:" + newName);
        try {
            uploadFile.transferTo(new File(folder,newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/uploadFile/" + format + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }


}
