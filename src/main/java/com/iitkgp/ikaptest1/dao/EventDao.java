/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.dao;

import com.iitkgp.ikaptest1.model.Event;
import java.util.List;

/**
 *
 * @author Nihir
 */
public interface EventDao {

    public abstract boolean insertEvent(Event event);

    public void updateEvent(Event event);

    public void saveOrUpdateEvent(Event event);

    public List<Event> getEvents();

    public Event getEvent(int event_id);

    public List<Event> getEventByAlumId(Integer alum_id);

}
