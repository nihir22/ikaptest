/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.service;

import com.iitkgp.ikaptest1.model.Alum;
import java.util.List;

/**
 *
 * @author Nihir
 */
public interface AlumService {

    public abstract Alum validateAlumCredential(String alum_roll, String alum_dob);

    public abstract boolean registerAlum(Alum alum);

    public void updateAlum(Alum alum);

    public void saveOrUpdateAlum(Alum alum);

    public List<Alum> getAlums();

    public Alum getAlum(int alum_id);

    public Alum getAlumByRoll(String alum_roll);

    public List<Alum> getAlumByEventId(Integer event_id);
}
