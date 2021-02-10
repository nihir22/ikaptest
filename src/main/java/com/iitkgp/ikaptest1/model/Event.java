/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Nihir
 */
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String event_name;
    private String event_detail;
    private String event_time;
    private String event_location;
    private String event_subject;
    private String event_fee;
    private String event_status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "alum_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "alum_id"))
    private List<Alum> alum = new ArrayList<Alum>();

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_detail() {
        return event_detail;
    }

    public void setEvent_detail(String event_detail) {
        this.event_detail = event_detail;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public String getEvent_subject() {
        return event_subject;
    }

    public void setEvent_subject(String event_subject) {
        this.event_subject = event_subject;
    }

    public String getEvent_fee() {
        return event_fee;
    }

    public void setEvent_fee(String event_fee) {
        this.event_fee = event_fee;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public List<Alum> getAlum() {
        return alum;
    }

    public void setAlum(List<Alum> alum) {
        this.alum = alum;
    }

        
}
