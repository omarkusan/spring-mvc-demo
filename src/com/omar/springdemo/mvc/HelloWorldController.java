package com.omar.springdemo.mvc;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processFrom(){
		return "helloworld";
	}
	// new a controller method to read form data and 
	// add data to the model
	@RequestMapping("/precessFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model){
		//read the request parameters from the HTML form
		String theName = request.getParameter("studentName");
		//convert the data to all caps
		theName = theName.toUpperCase();
		//create the message 
		String  result = "Yo! "+theName;
		//add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("/precessFormVersionThree")
	public String precessFormVersionThree(@RequestParam("studentName")String theName,Model model){
		//read the request parameters from the HTML form
		theName = theName.toUpperCase();
		//create the message 
		String  result = "Hey my Friend from Omar:! "+theName;
		//add message to the model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
}
