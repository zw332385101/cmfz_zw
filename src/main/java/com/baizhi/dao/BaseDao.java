package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> queryAll();
    T queryOne(String id);

}
