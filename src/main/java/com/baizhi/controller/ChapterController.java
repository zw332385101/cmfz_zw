package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.AlbumUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/addChapter")
    public @ResponseBody
    void addChapter(Chapter chapter, MultipartFile aas, HttpServletRequest request) throws IOException {
        String realPaths = request.getSession().getServletContext().getRealPath("back/images");
        aas.transferTo(new File(realPaths, aas.getOriginalFilename()));
        String Filename = aas.getOriginalFilename();
        chapter.setDownPath(Filename);
        //获取大小
        double size = AlbumUtil.LongTime(realPaths,Filename);
        //获取时长
        double a = AlbumUtil.Mp3size(realPaths,Filename);
        chapter.setDuration(a);
        System.out.println("获取的时间"+a);
        chapter.setSize(size);
        chapterService.addChapter(chapter);
    }

    /*
    * 查询到的专辑
    * */
    @RequestMapping("/findByChapter")
    public @ResponseBody
    List<Chapter> findByChapter(String id) {
        List<Chapter> byChapter = chapterService.findByChapter(id);
        return byChapter;
    }


    /*
    * 下载专辑
    * */
    @RequestMapping("/downloadchapter")
    public void download(String fileName,String openStyle,HttpServletRequest request,HttpServletResponse response) throws Exception {

        openStyle="attachment";
        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/back/images");
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //2.1 设置响应头
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);
    }
}