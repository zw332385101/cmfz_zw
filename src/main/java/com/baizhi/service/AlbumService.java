package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    List<Album> findByAlbumAll();
    void addAlbum(Album album);
    //根据id查找专辑
    Album findByAlbum(String id);
}
