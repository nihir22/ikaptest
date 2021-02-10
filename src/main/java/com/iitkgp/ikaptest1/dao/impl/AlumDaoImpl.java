/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.dao.impl;

import com.iitkgp.ikaptest1.dao.AlumDao;
import com.iitkgp.ikaptest1.model.Alum;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nihir
 */
@Repository("alumDao")
public class AlumDaoImpl implements AlumDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //Insert
    @Override
    public boolean insertAlum(Alum alum) {
        int alum_id = (Integer) hibernateTemplate.save(alum);
        if (alum_id > 0) {
            return true;
        }
        return false;
    }

    //Update
    @Override
    public void updateAlum(Alum alum) {
        this.hibernateTemplate.update(alum);
    }

    //Save or Update
    
    @Override
    public void saveOrUpdateAlum(Alum alum) {
        this.hibernateTemplate.saveOrUpdate(alum);
    }

    //get all alumni
    @Override
    public List<Alum> getAlums() {
        List<Alum> alums = this.hibernateTemplate.loadAll(Alum.class);
        return alums;
    }

    //get one alum
    @Override
    public Alum getAlum(int alum_id) {
        return this.hibernateTemplate.get(Alum.class, alum_id);
    }

    //validateAlum
//    public Alum validateAlum(String alum_roll, String alum_dob) {
//
//        Alum alum = null;
//
//        try {
//            @SuppressWarnings("unchecked")
//            List<Object> list = (List<Object>) hibernateTemplate.find("from Alum a where a.alum_roll=? AND a.alum_dob=?", alum_roll, alum_dob);
//
//            if (list != null && list.size() > 0) {
//                alum = (Alum) list.get(0);
//                return alum;
//            }
//
//        } catch (Exception e) {
//            throw e;
//        }
//        return null;
//    }
//    public Alum getAlumByRoll(String alum_roll) {
//        List<Alum> alums = new ArrayList<Alum>();
//
//        alums = hibernateTemplate.getSessionFactory().getCurrentSession()
//                .createQuery("from Alum a where a.alum_roll=?")
//                .setParameter(0, alum_roll)
//                .list();
//
//        if (alums.size() > 0) {
//            return alums.get(0);
//        } else {
//            return null;
//        }
//    }
    //get Alumni by event_id
//    public List<Alum> getAlumByEventId(Integer event_id) {
//        @SuppressWarnings({"unchecked", "deprecation"})
//        List<Alum> alums = (List<Alum>) hibernateTemplate.find("from Alum a where a.event_id=?", event_id);
//        return alums;
//    }
    @Override
    public Alum getAlumDetailsByRollAndDob(String alum_roll, String alum_dob) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Alum.class);
        detachedCriteria.add(Restrictions.eq("alum_roll", alum_roll));
        detachedCriteria.add(Restrictions.eq("alum_dob", alum_dob));
        List<Alum> findByCriteria = (List<Alum>) hibernateTemplate.findByCriteria(detachedCriteria);
        if (findByCriteria != null && findByCriteria.size() > 0) {
            return findByCriteria.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Alum getAlumByRoll(String alum_roll) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Alum.class);
        detachedCriteria.add(Restrictions.eq("alum_roll", alum_roll));
        List<Alum> findByCriteria = (List<Alum>) hibernateTemplate.findByCriteria(detachedCriteria);
        if (findByCriteria != null && findByCriteria.size() > 0) {
            return findByCriteria.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Alum> getAlumByEventId(Integer event_id) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Alum.class);
        detachedCriteria.add(Restrictions.eq("event_id", event_id));
        List<Alum> findByCriteria = (List<Alum>) hibernateTemplate.findByCriteria(detachedCriteria);
        if (findByCriteria != null && findByCriteria.size() > 0) {
            return (List<Alum>) findByCriteria.get(0);
        } else {
            return null;
        }
    }

}
