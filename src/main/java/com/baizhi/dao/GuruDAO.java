package com.baizhi.dao;

import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDAO {
    //查询所有
    List<Guru> queryByGuruAll();
    //增加
    void insertGuru(Guru guru);
    //修改
    void updateGuru(Guru guru);
    //删除
    void deleteGuru(String id);
    //查询一个
    Guru queryByOne(String id);
}
