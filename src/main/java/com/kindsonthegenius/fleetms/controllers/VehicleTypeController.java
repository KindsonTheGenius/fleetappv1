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

import com.kindsonthegenius.fleetms.models.VehicleType;
import com.kindsonthegenius.fleetms.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	
	@Autowired private VehicleTypeService vehicleTypeService;
	
	//Get All VehicleTypes
	@GetMapping("vehicleTypes")
	public String findAll(Model model){		
		model.addAttribute("vehicleTypes", vehicleTypeService.findAll());
		return "vehicleType";
	}	
	
	@RequestMapping("vehicleTypes/findById") 
	@ResponseBody
	public Optional<VehicleType> findById(Integer id)
	{
		return vehicleTypeService.findById(id);
	}
	
	//Add VehicleType
	@PostMapping(value="vehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}	
	
	@RequestMapping(value="vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping(value="vehicleTypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	}


}
