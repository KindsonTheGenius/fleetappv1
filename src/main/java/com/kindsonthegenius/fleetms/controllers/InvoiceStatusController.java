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

import com.kindsonthegenius.fleetms.models.InvoiceStatus;
import com.kindsonthegenius.fleetms.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired private InvoiceStatusService invoiceStatusService;
	
	//Get All InvoiceStatuss
	@GetMapping("invoiceStatuses")
	public String findAll(Model model){		
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "invoiceStatus";
	}	
	
	@RequestMapping("invoiceStatuses/findById") 
	@ResponseBody
	public Optional<InvoiceStatus> findById(Integer id)
	{
		return invoiceStatusService.findById(id);
	}
	
	//Add InvoiceStatus
	@PostMapping(value="invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}	
	
	@RequestMapping(value="invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping(value="invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
