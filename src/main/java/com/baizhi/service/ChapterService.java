package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    void addChapter(Chapter chapter);
    //根据id查找章节
    List<Chapter> findByChapter(String id);
}
