package com.shashank.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.shashank.service.WishService;

@Controller
public class WishController extends AbstractController {
	@Inject
	private WishService service;

	public void setService(WishService service) {
		System.out.println("WishController::    setService()");
		this.service = service;
	}

	@RequestMapping(value="/welcome.php",method = RequestMethod.GET)
	public String homePage(){
		return "welcome";
	}

	@Override
	@RequestMapping(value = "/wish.php", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Use service class business logic
		String wmsg = service.generateWish();
		return new ModelAndView("result", "wresult", wmsg);
	}

}
