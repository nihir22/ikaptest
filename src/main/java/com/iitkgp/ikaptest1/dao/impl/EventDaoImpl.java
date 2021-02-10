/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.dao.impl;

import com.iitkgp.ikaptest1.dao.EventDao;
import com.iitkgp.ikaptest1.model.Event;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nihir
 */
@Repository("eventDao")
public class EventDaoImpl implements EventDao{
    
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
    public boolean insertEvent(Event event) {
        int event_id= (Integer)hibernateTemplate.save(event);
        if(event_id>0)
            return true;
        return false;
        
    }

    //Update
    @Override
    public void updateEvent(Event event) {
        this.hibernateTemplate.update(event);
    }
    
    //Save or Update
    @Override
    public void saveOrUpdateEvent(Event event) {
        this.hibernateTemplate.saveOrUpdate(event);
    }
    

    //get all alumni
    @Override
    public List<Event> getEvents() {
        List<Event> events = this.hibernateTemplate.loadAll(Event.class);
        return events;
    }

    //get one alum
    @Override
    public Event getEvent(int event_id) {
		return this.hibernateTemplate.get(Event.class, event_id);
	}
    
    //get Events by alum_id
    @Override
    public List<Event> getEventByAlumId(Integer alum_id){
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Event> events= (List<Event>) hibernateTemplate.find("from event where alum_id=?",alum_id);
		return events;
	}
    
}
