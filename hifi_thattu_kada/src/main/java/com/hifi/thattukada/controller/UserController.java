package com.hifi.thattukada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hifi.thattukada.variety.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/login")
	public void list(){
		System.out.println("USER CONTROLLER LIST -->"+ userDao.userLogin());
	}
}
