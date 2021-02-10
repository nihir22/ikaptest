/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iitkgp.ikaptest1.Controller;

import com.iitkgp.ikaptest1.model.Alum;
import com.iitkgp.ikaptest1.model.AlumCredential;
import com.iitkgp.ikaptest1.service.AlumService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nihir
 */
@Controller
public class AlumController {

    
    @Autowired
    private AlumService alumService;

    public AlumService getAlumService() {
        return alumService;
    }

    public void setAlumService(AlumService alumService) {
        this.alumService = alumService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("alumCredential", new AlumCredential());
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("alumCredential", new AlumCredential());
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("alum", new Alum());
        return "register";
    }

    @RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
    public ModelAndView registerSuccess(@Valid @ModelAttribute("alum") Alum alum, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        getAlumService().registerAlum(alum);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("alum", alum);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") AlumCredential alumCredential, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        Alum alum = getAlumService().validateAlumCredential(alumCredential.getAlum_roll(), alumCredential.getAlum_dob());
        if (alum != null) {
            modelAndView.addObject("alum", alum);
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("notFound");
        }
        return modelAndView;
    }
    
    @RequestMapping(value = "/home/{alum_id}", method = RequestMethod.GET)
    public String alumHome(@PathVariable("alum_id") int alum_id, Model model) {
        Alum alum = alumService.getAlum(alum_id);
        model.addAttribute("alum", alum);
        return "home";
    }

    @RequestMapping(value = "/profile/{alum_id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("alum_id") int alum_id, Model model) {
        Alum alum = alumService.getAlum(alum_id);
        model.addAttribute("alum", alum);
        return "profile";
    }

    @RequestMapping(value = "/profile/profileUpdate", method = RequestMethod.POST)
    public ModelAndView updateProfile(@ModelAttribute Alum alum) {
        System.out.println("alum");
        alumService.saveOrUpdateAlum(alum);
        ModelAndView modelAndView = new ModelAndView("home");     
        return modelAndView;
    }

    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "index";
    }

}
