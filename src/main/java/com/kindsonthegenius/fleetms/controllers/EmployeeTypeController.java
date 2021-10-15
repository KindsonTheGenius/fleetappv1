package com.kindsonthegenius.fleetms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kindsonthegenius.fleetms.models.EmployeeType;
import com.kindsonthegenius.fleetms.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	
	@Autowired private EmployeeTypeService employeeTypeService;
	
	//Get All EmployeeTypes
	@GetMapping("employeeTypes")
	public String findAll(Model model){		
		model.addAttribute("employeeTypes", employeeTypeService.findAll());
		return "employeeType";
	}	
	
	@RequestMapping("employeeTypes/findById") 
	@ResponseBody
	public Optional<EmployeeType> findById(Integer id)
	{
		return employeeTypeService.findById(id);
	}
	
	//Add EmployeeType
	@PostMapping(value="employeeTypes/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}	
	
	@RequestMapping(value="employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping(value="employeeTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	}

}
