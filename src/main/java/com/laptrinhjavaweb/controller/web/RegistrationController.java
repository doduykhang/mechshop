package com.laptrinhjavaweb.controller.web;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.RegistrationRequest;
import com.laptrinhjavaweb.exception.InvalidTokenException;
import com.laptrinhjavaweb.service.IRegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	IRegistrationService registrationService;
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("request") RegistrationRequest request) {
		ModelAndView mav = new ModelAndView("web/user/SendConfirmMail");
		try {
			mav.addObject("message",registrationService.resgister(request));
		}catch(ConstraintViolationException ex) {
			System.out.println(ex);
			mav.setViewName("login");
			mav.addObject("errorMessage",ex.getConstraintViolations());

		}
		catch(RuntimeException ex) {
			ModelAndView mav2 = new ModelAndView("web/user/SendConfirmMail");
			mav2.addObject("message",ex.getMessage());
			return mav2;
		}
		return mav;
	}
	
	@RequestMapping(value = "/kich-hoat", method = RequestMethod.GET)
	public ModelAndView activate(@RequestParam("token") String jwt) {
		ModelAndView mav = new ModelAndView("web/user/SendConfirmMail");
		try {
			mav.addObject("message",registrationService.activateUser(jwt));
		}catch(InvalidTokenException ex) {
			mav.addObject("message",ex.getMessage());
		}
		return mav;
	}
}
