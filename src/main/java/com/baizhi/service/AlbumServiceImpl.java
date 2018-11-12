package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;
    @Override
    public List<Album> findByAlbumAll() {
        List<Album> albums = albumDAO.queryByAlbumAll();
        return albums;
    }

    @Override
    public void addAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setPublishDate(new Date());
        albumDAO.insertAlbum(album);
    }

    @Override
    public Album findByAlbum(String id) {
        Album album = albumDAO.queryByAlbum(id);
        return album;
    }
}
