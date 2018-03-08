package com.jarry.chat.controller;

import com.jarry.chat.model.MessageData;
import com.jarry.chat.util.Constant;
import com.jarry.chat.util.FileUtil;
import com.jarry.chat.util.VideoThumbTaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static com.jarry.chat.util.Constant.CODE_FILE_UPLOAD_ERROR;
import static com.jarry.chat.util.Constant.MSG_FILE_UPLOAD_ERROR;

/**
 * Description:文件上传
 * User: Jarry
 * Date: 2018-03-08
 * Time: 22:36
 */
@RestController
public class FileController {
    static Logger logger = Logger.getLogger(FileController.class);
    private static final String FILE_PATH = "/home/file/";
    private static final String FILE_PICTURE_PATH = "/home/file/picture";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    MessageData upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = FILE_PATH;

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            //上传完成后截取第一帧图片

            String fileNameLow = fileName.toLowerCase();
            // mp4，avi，navi，dv-avi，divx，mov，asf，wmv，rm，rmvb
            // flv,wav,mpg,mpeg
            // 最后生成的视频第一帧图片
            String mvFileName = null;
            if (fileNameLow.endsWith(".mp4") || fileNameLow.endsWith(".avi")
                    || fileNameLow.endsWith(".navi")
                    || fileNameLow.endsWith(".dv-avi")
                    || fileNameLow.endsWith(".divx")
                    || fileNameLow.endsWith(".mov") || fileNameLow.endsWith(".asf")
                    || fileNameLow.endsWith(".wmv") || fileNameLow.endsWith(".rm")
                    || fileNameLow.endsWith(".flv")
                    || fileNameLow.endsWith(".rmvb")
                    || fileNameLow.endsWith(".mpg")
                    || fileNameLow.endsWith(".mpeg")
                    || fileNameLow.endsWith(".3gp")) {
                mvFileName = "";// 标识下是视频文件
                // 视频文件，获取第一帧图片
                // 图片前缀名称同视频前缀名称
                String mediaPicPath = FILE_PATH + fileName + ".jpg";
                logger.info("mediaPicPath=" + mediaPicPath);
                boolean flag = false; // 转码成功与否的标记
                flag = VideoThumbTaker.takeThumb(filePath + File.separator + fileName, mediaPicPath);
                if (flag) {
                    // 生成第一帧图片成功了
                }
            }


            return new MessageData(Constant.CODE_SUCCESS, Constant.MSG_UPLOAD_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new MessageData(CODE_FILE_UPLOAD_ERROR, MSG_FILE_UPLOAD_ERROR);
        }
    }
}
