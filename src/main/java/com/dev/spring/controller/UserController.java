package com.dev.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev.spring.beans.User;
import com.dev.spring.services.UserServices;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserServices services;
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public ModelAndView getUserById(HttpServletRequest req, 
			ModelAndView mv){
		Integer id = Integer.parseInt(req.getParameter("id"));
		User user = services.getUser(id);
		System.out.println(user);
		mv.addObject("user", user); //req.setAttribute("user",user)
		mv.setViewName("user");
		return mv;
	}
}
