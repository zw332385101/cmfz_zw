package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findByAlbumAll")
    public @ResponseBody List<Album> findByAlbumAll(){
        List<Album> byAlbumAll = albumService.findByAlbumAll();
        return  byAlbumAll;
    }

    @RequestMapping("/addAlbum")
    public @ResponseBody void addAlbum(Album album){
        albumService.addAlbum(album);
    }
    @RequestMapping("/findByAlbum")
    public @ResponseBody Album findByAlbum(String id){
        Album byAlbum = albumService.findByAlbum(id);
        return byAlbum;
    }

}
