package com.kindsonthegenius.fleetms.controllers;

import com.kindsonthegenius.fleetms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        model.addAttribute("employee", employeeService.findByUsername(un));
        return "profile";
    }

}
