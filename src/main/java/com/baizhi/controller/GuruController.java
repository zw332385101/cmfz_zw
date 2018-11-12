package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("guru")
public class GuruController {

    @Autowired
    private GuruService guruService;


    @RequestMapping("/findByGuruAll")
    public @ResponseBody List<Guru> findByGuruAll(){
        List<Guru> byGuruAll = guruService.findByGuruAll();
        return byGuruAll;
    }

    @RequestMapping("/addGuru")
    public @ResponseBody void addGuru(Guru guru, MultipartFile aas, HttpServletRequest request) throws IOException {
        String realPaths = request.getRealPath("back/images");
        aas.transferTo(new File(realPaths,aas.getOriginalFilename()));
        guru.setHeadPic("/back/shangshi/"+aas.getOriginalFilename());
        guruService.addGuru(guru);
    }

    @RequestMapping("/removeGuru")
    public @ResponseBody void removeGuru(String[] id){
        for(int i=0;i<id.length;i++){
            guruService.removeGuru(id[i]);
        }
    }

    @RequestMapping("/findByOne")
    public @ResponseBody Guru findByOne(String id){
        Guru byOne = guruService.findByOne(id);
        return byOne;
    }


    @RequestMapping("/motifyGuru")
    public @ResponseBody void motifyGuru(Guru guru,MultipartFile aas, HttpServletRequest request) throws IOException {
        String realPaths = request.getRealPath("back/images");
        aas.transferTo(new File(realPaths,aas.getOriginalFilename()));
        guru.setHeadPic("/back/shangshi/"+aas.getOriginalFilename());
        guruService.motifyGuru(guru);
    }
}