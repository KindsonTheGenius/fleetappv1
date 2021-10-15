package com.kindsonthegenius.fleetms.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.kindsonthegenius.fleetms.models.Employee;
import com.kindsonthegenius.fleetms.services.CountryService;
import com.kindsonthegenius.fleetms.services.EmployeeService;
import com.kindsonthegenius.fleetms.services.EmployeeTypeService;
import com.kindsonthegenius.fleetms.services.JobTitleService;
import com.kindsonthegenius.fleetms.services.StateService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
	@Autowired private StateService stateService;
	
	@Autowired private JobTitleService jobTitleService;
	
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private CountryService countryService;

	@Autowired
	private ServletContext context;
	
	//Get All Employees
	@GetMapping("employees")
	public String findAll(Model model, String keyword){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("jobTitles", jobTitleService.findAll());
		model.addAttribute("employeeTypes", employeeTypeService.findAll());		
		
		if(keyword != null) {
			model.addAttribute("employees", employeeService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("employees", employeeService.findAll());			
		}

		return "employee";
	}	
	
	@RequestMapping("employees/findById") 
	@ResponseBody
	public Optional<Employee> findById(Integer id)
	{
		return employeeService.findById(id);
	}
	
	//Add Employee
	@PostMapping(value="employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}	
	
	@RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);	
		return "redirect:/employees";
	}
	
	@RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}	

	@RequestMapping(value="/employees/uploadPhoto", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File newFile = new File("//Users//kindsonmunonye//Documents//SOLUTIONS//fleetms//uploads//" + file.getOriginalFilename());
		newFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(newFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
	}	

	@PostMapping("/employees/uploadPhoto2")
	public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal) 
			throws IllegalStateException, IOException {
			String baseDirectory = "//Users//kindsonmunonye//Documents//SOLUTIONS//fleetms//src//main//resources//static//img//photos//" ;
			file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
			return "redirect:/employees";
	}

	@PostMapping("/employees/uploadPhoto3")
	public String uploadFile3(@RequestParam("file") MultipartFile file, Principal principal)
			throws IllegalStateException, IOException {
		String photosDir = "/Users/kindsonmunonye/Documents/SOLUTIONS/fleetms/src/main/resources/static/img/photos/";
		file.transferTo(new File(photosDir + principal.getName() + ".jpg"));
		return "redirect:/employees";
	}
	//Users/kindsonmunonye/Documents/SOLUTIONS/FLEETMS/src/main/resources/static/img

	@RequestMapping(value="/employees/profile")
	public String profile(Model model, Principal principal) {
		String un = principal.getName();
		model.addAttribute("employee", employeeService.findByUsername(un));
		return "profile";
	}
	
	//Get All Employees for Filtering
	@GetMapping("employeesFilter")
	public String findByKeyword(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("jobTitles", jobTitleService.findAll());
		model.addAttribute("employeeTypes", employeeTypeService.findAll());				
		model.addAttribute("employees", employeeService.findAll());			

		return "employeesFilter";
	}

	//Assign Employee Username
	@RequestMapping(value = "/employees/assignUsername")
	public  String assignUsername(int id){
		employeeService.assignUsername(id);
		return "redirect:/employees";
	}
}
