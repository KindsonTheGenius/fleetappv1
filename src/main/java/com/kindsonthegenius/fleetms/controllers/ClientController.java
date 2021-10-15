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

import com.kindsonthegenius.fleetms.models.Client;
import com.kindsonthegenius.fleetms.services.ClientService;
import com.kindsonthegenius.fleetms.services.CountryService;
import com.kindsonthegenius.fleetms.services.EmployeeTypeService;
import com.kindsonthegenius.fleetms.services.JobTitleService;
import com.kindsonthegenius.fleetms.services.StateService;

@Controller
public class ClientController {
	
	@Autowired private StateService stateService;
	@Autowired private CountryService countryService;	
	@Autowired private ClientService clientService;
	
	//Get All Clients
	@GetMapping("/clients")
	public String findAll(Model model){		
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("clients", clientService.findAll());
		return "client";
	}	
	
	@RequestMapping("clients/findById") 
	@ResponseBody
	public Optional<Client> findById(Integer id)
	{
		return clientService.findById(id);
	}
	
	//Add Client
	@PostMapping(value="clients/addNew")
	public String addNew(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}	
	
	@RequestMapping(value="clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		clientService.delete(id);
		return "redirect:/clients";
	}

}
