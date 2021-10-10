package com.laptrinhjavaweb.controller.web;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.NewPasswordRequest;
import com.laptrinhjavaweb.dto.PasswordResetRequest;
import com.laptrinhjavaweb.service.IPasswordResetService;

@Controller
public class ResetPasswordController {
	@Autowired
	IPasswordResetService passwordResetService;
	
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.GET)
	public ModelAndView getForgotPasswordPage() {
		ModelAndView mav = new ModelAndView("web/user/ForgotPassword");
		return mav;
	}
	
	@RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
	public ModelAndView forgotPassword(@ModelAttribute("request") PasswordResetRequest request) {
		ModelAndView mav = new ModelAndView("web/user/SendConfirmMail");
		try {
			mav.addObject("message",passwordResetService.passwordReset(request));
		}catch(RuntimeException ex) {
			ModelAndView mav2 = new ModelAndView("web/user/ForgotPassword");
			mav2.addObject("message",ex.getMessage());
			return mav2;
		}
		return mav;
	}
	
	@RequestMapping(value = "/mat-khau-moi", method = RequestMethod.GET)
	public ModelAndView getNewPasswordPage(@RequestParam("token") String jwt) {
		if(passwordResetService.validateToken(jwt)) {
			ModelAndView mav = new ModelAndView("web/user/ChangePassword");
			mav.addObject("jwt",jwt);
			return mav;
		}
		else {
			ModelAndView mav2 = new ModelAndView("web/user/ForgotPassword");
			mav2.addObject("message","invalid token");
			return mav2;
		}
	}
	
	@RequestMapping(value = "/mat-khau-moi", method = RequestMethod.POST)
	public ModelAndView newPassword(@ModelAttribute("request") NewPasswordRequest request) {
		ModelAndView mav = new ModelAndView("web/user/SendConfirmMail");
		try {
			mav.addObject("message",passwordResetService.newPassword(request));
		}catch(ConstraintViolationException ex) {
			System.out.println("ConstraintViolationException");
			System.out.println(ex);
			mav.setViewName("web/user/ChangePassword");
			mav.addObject("jwt",request.getValidationToken());
			mav.addObject("errorMessage",ex.getConstraintViolations());
			return mav;
		}catch(RuntimeException ex) {
			ModelAndView mav2 = new ModelAndView("web/user/ForgotPassword");
			mav2.addObject("message",ex.getMessage());
			return mav2;
		}
		return mav;
	}
}
