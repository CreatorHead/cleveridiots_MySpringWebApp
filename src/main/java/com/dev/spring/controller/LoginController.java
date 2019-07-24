package com.dev.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.spring.beans.User;
import com.dev.spring.services.UserServices;

@Controller
public class LoginController {
	
	@Autowired
	UserServices services;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req,
			ModelAndView mv){
		int userId = Integer.parseInt(req.getParameter("user_id"));
		String passwd = req.getParameter("passwd");
		
		User user = services.login(userId, passwd);
		if(user != null){
			HttpSession session = req.getSession();	
			session.setAttribute("user", user);
			mv.setViewName("redirect:./userHome");
		}else{
			mv.setViewName("redirect:./login");
		}
		return mv;
	}
}
