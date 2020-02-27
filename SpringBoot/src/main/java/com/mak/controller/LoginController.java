package com.mak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin(){
		
		System.out.println("login");
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession session){
		System.out.println("logout");
		
//		HttpSession session = request.getSession();
		session.invalidate();
		 return "redirect:/login";
//		return "login-page";
	}
}
