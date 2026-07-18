package com.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {
	@RequestMapping("/msg")
	public String getmsg() {
		System.out.println("msg api trigger");
		return "msg.jsp";
		
	}
	@RequestMapping("/greet")
	public String greet() {
		System.out.println("greet api trigger");
		return "greet.jsp";
		
	}

}
