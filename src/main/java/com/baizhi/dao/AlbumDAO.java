package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

public interface AlbumDAO {

    List<Album> queryByAlbumAll();

    //增加
    void insertAlbum(Album album);
    //根据id查找专辑
    Album queryByAlbum(String id);
}
