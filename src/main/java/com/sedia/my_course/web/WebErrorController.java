package com.sedia.my_course.web;

import com.sedia.my_course.model.user.User;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model, User user) {
		System.out.println("user: "+user);
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		model.addAttribute("status", statusCode);
		return "error/error_page";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
