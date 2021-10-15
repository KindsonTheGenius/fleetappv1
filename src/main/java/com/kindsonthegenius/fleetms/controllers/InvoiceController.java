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

import com.kindsonthegenius.fleetms.models.Invoice;
import com.kindsonthegenius.fleetms.services.ClientService;
import com.kindsonthegenius.fleetms.services.InvoiceService;
import com.kindsonthegenius.fleetms.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired private InvoiceService invoiceService;
	@Autowired private InvoiceStatusService invoiceStatusService;
	@Autowired private ClientService clientService;
	
	//Get All Invoices
	@GetMapping("invoices")
	public String findAll(Model model){		
		model.addAttribute("invoices", invoiceService.findAll());
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "invoice";
	}	
	
	@RequestMapping("invoices/findById") 
	@ResponseBody
	public Optional<Invoice> findById(Integer id)
	{
		return invoiceService.findById(id);
	}
	
	//Add Invoice
	@PostMapping(value="invoices/addNew")
	public String addNew(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}	
	
	@RequestMapping(value="invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
