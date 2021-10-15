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

import com.kindsonthegenius.fleetms.models.VehicleStatus;
import com.kindsonthegenius.fleetms.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired private VehicleStatusService vehicleStatusService;
	
	//Get All VehicleStatuss
	@GetMapping("vehicleStatuses")
	public String findAll(Model model){		
		model.addAttribute("vehicleStatuses", vehicleStatusService.findAll());
		return "vehicleStatus";
	}	
	
	@RequestMapping("vehicleStatuses/findById") 
	@ResponseBody
	public Optional<VehicleStatus> findById(Integer id)
	{
		return vehicleStatusService.findById(id);
	}
	
	//Add VehicleStatus
	@PostMapping(value="vehicleStatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}	
	
	@RequestMapping(value="vehicleStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping(value="vehicleStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	}


}
