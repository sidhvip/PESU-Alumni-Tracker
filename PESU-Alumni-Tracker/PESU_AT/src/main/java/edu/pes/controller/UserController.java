package edu.pes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pes.entity.Alumni;
import edu.pes.service.AlumniService;


@Controller
@RequestMapping("/user")
public class UserController {
	

	private AlumniService alumniService;
	@Autowired   
	public UserController(AlumniService obj)
	{
		this.alumniService=obj;
	
	}

	
	
	@GetMapping("/alumni")
	public String Allalumni(@RequestParam("id") int theId,Model theModel) {

		Alumni list=(Alumni) alumniService.findById(theId);
		
		int click=list.getClick();
		
		click++;
		
		list.setClick(click);
		

		alumniService.save(list);
	
		
		theModel.addAttribute("list",list);
		
		System.out.println(list);
		return "user/alumni-details";
	}



	@GetMapping("/index")
	public String all(Model theModel) {

		List<Alumni> list=alumniService.findAll();
		
		theModel.addAttribute("allalumni",list);
		
		return "user/index";
	}
	
}
