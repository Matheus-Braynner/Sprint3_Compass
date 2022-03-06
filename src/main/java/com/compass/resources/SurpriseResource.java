package com.compass.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SurpriseResource {

	@RequestMapping("/")
	@ResponseBody
	public String Surprise() {
		return "Hire me, please";
	}
}
