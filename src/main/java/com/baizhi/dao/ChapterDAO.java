package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDAO {

    void insertChapter(Chapter chapter);

    //根据id查找章节
    List<Chapter> queryByChapter(String id);
}
