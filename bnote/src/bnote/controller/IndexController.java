package bnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	@RequestMapping({"/index","/"})
	public String IndexHandler(Model model) {
		model.addAttribute("body", "index");
		return "t_el";
	}
}
