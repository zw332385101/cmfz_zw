package com.baizhi.service;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements  ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;

    @Override
    public void addChapter(Chapter chapter) {
        chapter.setChapter_id(UUID.randomUUID().toString());
        chapter.setUploadTime(new Date());
        chapterDAO.insertChapter(chapter);
    }

    @Override
    public List<Chapter> findByChapter(String id) {
        List<Chapter> chapters = chapterDAO.queryByChapter(id);
        return chapters;
    }
}
