package com.yc.controller;

import com.yc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

//文件上传
// 数据库照片中存储路径的是不包括项目名的
@Controller
public class SavePic {
    //定义存入数据库的开头(文件夹名)
    private static final String datapath = "hdpic";

    @Autowired
    private ActivityService activityService;

    /**
     * 取得当前项目在磁盘的地址
     *
     * @return
     */
    public String getCurrentPath() {
        //取得根目录路径
        String rootPath = getClass().getResource("../../../../../").getFile().toString();
        rootPath = rootPath.substring(1) + datapath;
        return rootPath;
    }

    /**
     * 存储图片到磁盘，根据主键把地址插入到表里
     *
     * @param file
     * @param aid
     * @return
     */
    @RequestMapping(value = "/savepic", produces = {"text/plain;charset=utf-8", "text/html;charset=utf-8"})
    //produces = {"text/plain;charset=utf-8","text/html;charset=utf-8"} 防止return 到前端出现乱码
    @ResponseBody  //将数据转成json的注解
    public String savePic(@RequestParam("file") MultipartFile file, @RequestParam(value = "aid", required = false) String aid) {
        int id = Integer.parseInt(aid);
        String string = null;
        // 图片存储路径
        System.out.println("图片存储路径：" + getCurrentPath());
        // String path = "G:\\image\\factory";
        String path = getCurrentPath();
        // 判断是否有路径
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        //获取原图片名称(包括后缀)
        String fn = file.getOriginalFilename();
        //获取最后的.
        int i = fn.lastIndexOf(".");
        //截取后缀名
        String hz = fn.substring(i);
        //重新命名图片
        String fileName = UUID.randomUUID().toString().replace("-", "") + hz;
        File tempFile = new File(path, fileName);
        String linuxpath = path.replace("\\", "/");
        //拼接地址
        String savedataimg = "/" + datapath + "/" + fileName;
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
                file.transferTo(tempFile);
                //将照片地址存储在数据库里
                if (activityService.saveimg(id, savedataimg) > 0) {
                    string = "{\"code\": 1, \"msg\": \"上传成功\", \"data\": {  \"url\": [ \"" + linuxpath + "/" + fileName + "\"]}}"; //拼接 前端指定的api
                } else {
                    string = "{\"code\": 0, \"msg\": \"上传失败\", \"data\": {  \"url\": [ \"" + linuxpath + "/" + fileName + "\"]}}"; //拼接 前端指定的api
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //    System.out.println(string);
        return string;
    }
}
