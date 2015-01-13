package com.hifi.thattukada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TilesController {

	@RequestMapping("/tiles")
	public String tiles(){
		System.out.println("\n\n tiles activTED \n ");
		return "tiles1";
	}
}
