package com.baizhi.service;

import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;

    @Override
    public List<Guru> findByGuruAll() {
        List<Guru> gurus = guruDAO.queryByGuruAll();
        return gurus;
    }

    @Override
    public void addGuru(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDAO.insertGuru(guru);

    }

    @Override
    public void motifyGuru(Guru guru) {
        guruDAO.updateGuru(guru);
    }

    @Override
    public void removeGuru(String id) {
        guruDAO.deleteGuru(id);
    }

    @Override
    public Guru findByOne(String id) {
        Guru guru = guruDAO.queryByOne(id);
        return guru;
    }
}
