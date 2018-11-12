package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    //查询所有
    List<Guru> findByGuruAll();
    //增加
    void addGuru(Guru guru);
    //修改
    void motifyGuru(Guru guru);
    //删除
    void removeGuru(String id);
    //查询一个
    Guru findByOne(String id);
}
