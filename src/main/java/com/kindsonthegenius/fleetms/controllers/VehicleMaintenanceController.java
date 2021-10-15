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

import com.kindsonthegenius.fleetms.models.VehicleMaintenance;
import com.kindsonthegenius.fleetms.services.SupplierService;
import com.kindsonthegenius.fleetms.services.VehicleMaintenanceService;
import com.kindsonthegenius.fleetms.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	
	@Autowired private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired private VehicleService vehicleService;
	@Autowired private SupplierService supplierService;

	
	//Get All VehicleMaintenances
	@GetMapping("vehicleMaintenances")
	public String findAll(Model model){		
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.findAll());
		model.addAttribute("vehicles", vehicleService.findAll());
		model.addAttribute("suppliers", supplierService.findAll());

		return "vehicleMaintenance";
	}	
	
	@RequestMapping("vehicleMaintenances/findById") 
	@ResponseBody
	public Optional<VehicleMaintenance> findById(Integer id)
	{
		return vehicleMaintenanceService.findById(id);
	}
	
	//Add VehicleMaintenance
	@PostMapping(value="vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}	
	
	@RequestMapping(value="vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping(value="vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}

}
