package cn.egret.server.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * 文件上传工具类
 *
 * @author egret
 */
public class ImageUtils {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public static String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //1.确定保存的文件夹
//        String dirPath = request.getServletContext().getRealPath("upload");//会在webapp下面创建此文件夹
        //会在webapp下面创建此文件夹
        String dirPath = "C:/Images";
        System.out.println("dirPath=" + dirPath);

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //2.确定保存的文件名
        String orginalFilename = file.getOriginalFilename();
        int beginIndex = orginalFilename.lastIndexOf(".");
        String suffix = "";
        if (beginIndex != -1) {
            suffix = orginalFilename.substring(beginIndex);
        }

        String filename = UUID.randomUUID().toString() + suffix;
        //创建文件对象，表示要保存的头像文件,第一个参数表示存储的文件夹，第二个参数表示存储的文件
        File dest = new File(dir, filename);
        //执行保存
        file.transferTo(dest);

        String url = dirPath + "/" + filename;
        return url;

    }
}