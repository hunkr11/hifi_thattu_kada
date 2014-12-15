package com.hifi.thattukada.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.hifi.thattukada.config.HibernateConfigurer;
import com.hifi.thattukada.variety.dao.UserDao;

@Controller
@Import (HibernateConfigurer.class)
public class UserController {
	
	/*private final Logger logger ;
	logger = LoggerFactory.getLogger(UserController.class);
*/
	@Autowired
	    private UserDao userDao;	
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	
	@RequestMapping("/login")
	public List getList(){
	//	UserDao userDao = ctx.getBean(UserDao.class);
		List retunList =  this.userDao.userLogin();
		System.out.println("/n/n LISt--->>"+retunList);
		return retunList;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(){
		System.out.println("\n \n HOME Controller\n \n");
		return new ModelAndView("home");
	}
	
	/*@RequestMapping(value="/login")
	public void list(){
		System.out.println("USER CONTROLLER LIST -->"+ userService.getList());
	}*/
}
