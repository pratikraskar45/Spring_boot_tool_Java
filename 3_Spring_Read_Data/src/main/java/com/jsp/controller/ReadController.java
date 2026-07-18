package com.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReadController {
	
	@RequestMapping("/hi")//support both get and post
	public String welcome() {
		System.out.println("index api trigerr");
		return "index.jsp";
	}
	
	@RequestMapping(value = "/read",method = RequestMethod.POST) 
	public ModelAndView readData(HttpServletRequest request) {
		System.out.println("User data is here");
		String name= request.getParameter("un");
		String email= request.getParameter("ue");

		System.out.println("name:"+name);
		System.out.println("email:"+email);
		
		
		ModelAndView mv = new ModelAndView("data.jsp");
		mv.addObject("userName", name);
		mv.addObject("userEmail", email);
		return mv;
		
	}
	
	@RequestMapping("/send")
	public String sendData(Model model) {
		String name="Pratik";
		String email="pratik@gmail.com";
		long phone=859746245;
		
		model.addAttribute("uname",name);
		model.addAttribute("uemail",email);
		model.addAttribute("uphone",phone);
		
		
		return "display.jsp";
		
	}
	
	@RequestMapping("/pass")
	public ModelAndView passData() {
		
		String userName="Rohit";
		String userId="gahhaha126";
		
		
		
		ModelAndView mv=new ModelAndView("pass.jsp");
		mv.addObject("uname",userName);
		mv.addObject("uid",userId);
		
		Employee e=new Employee();
		e.setEid("abc123");
		e.setEname("jeevan");
		e.setSalary(45000);
		
		mv.addObject("empclass",e);
//		mv.setViewName("pass.jsp");
		
		return mv;
		
		
	}

}
