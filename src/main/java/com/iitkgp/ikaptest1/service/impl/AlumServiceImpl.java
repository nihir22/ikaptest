/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.service.impl;

import com.iitkgp.ikaptest1.dao.AlumDao;
import com.iitkgp.ikaptest1.model.Alum;
import com.iitkgp.ikaptest1.service.AlumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nihir
 */
@Repository("alumService")
public class AlumServiceImpl implements AlumService {

    @Autowired
    private AlumDao alumDao;

    public AlumDao getAlumDao() {
        return alumDao;
    }

    public void setAlumDao(AlumDao alumDao) {
        this.alumDao = alumDao;
    }

    @Override
    public Alum validateAlumCredential(String alum_roll, String alum_dob) {
        Alum alum = getAlumDao().getAlumDetailsByRollAndDob(alum_roll, alum_dob);
        return alum;
    }

    @Override
    public boolean registerAlum(Alum alum) {
        boolean isRegister = false;
        boolean saveAlum = getAlumDao().insertAlum(alum);
        if (saveAlum) {
            isRegister = true;
        }
        return isRegister;
    }

    @Override
    public void updateAlum(Alum alum) {
        alumDao.updateAlum(alum);
    }

    @Override
    public void saveOrUpdateAlum(Alum alum) {
        alumDao.saveOrUpdateAlum(alum);
    }

    @Override
    public List<Alum> getAlums() {
        List<Alum> alums = alumDao.getAlums();
        return alums;
    }

    @Override
    public Alum getAlum(int alum_id) {
        Alum alum = alumDao.getAlum(alum_id);
        return alum;
    }

    @Override
    public Alum getAlumByRoll(String alum_roll) {
        Alum alum = alumDao.getAlumByRoll(alum_roll);
        return alum;
    }

    @Override
    public List<Alum> getAlumByEventId(Integer event_id) {
        List<Alum> alums = alumDao.getAlumByEventId(event_id);
        return alums;
    }

}
