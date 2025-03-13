package edu.pes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pes.entity.Alumni;
import edu.pes.service.AlumniService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private AlumniService alumniService;

	@Autowired   
	public AdminController(AlumniService obj)
	{
		this.alumniService=obj;
	
	}

	@GetMapping("/add-alumni")
	public String Addalumni(Model theModel) {
	
		Alumni alumni=new Alumni();
		
		theModel.addAttribute("alumni",alumni);
		
		return "admin/addAlumni";
	}
	
	@PostMapping("/add-alumni")
	public String Savealumni(@ModelAttribute("alumni") Alumni alumni) {

	
		alumniService.save(alumni);
	
		return "redirect:/admin/add-alumni";
	}
	
	@GetMapping("/all-alumni")
	public String Allalumni(Model theModel) {

		List<Alumni> list=alumniService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "admin/alumniList";
	}

	
	@GetMapping("/update-alumni")
	public String Updatealumni(@RequestParam("id") int theId,Model theModel) {

		Alumni alumni=alumniService.findById(theId);
		
		theModel.addAttribute("alumni",alumni);
		
		return "admin/addAlumni";
	}
	
	@GetMapping("/delete-alumni")
	public String Deletealumni(@RequestParam("id") int theId) {

		alumniService.deleteById(theId);
	
		return "redirect:/admin/all-alumni";
	}
	
}
