package com.hifi.thattukada.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.hifi.thattukada.config.HibernateConfigurer;
import com.hifi.thattukada.variety.dao.UserDao;
import com.hifi.thattukada.variety.entity.UserEntity;
import com.hifi.thattukada.variety.vo.UserVO;

@Controller
@Import (HibernateConfigurer.class)
public class UserController {
	
	/*private final Logger logger ;
	logger = LoggerFactory.getLogger(UserController.class);
*/
	@Autowired
	    private UserDao userDao;	
	//	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	
	@RequestMapping("/loginList")
	public List<UserEntity> getList(){
	//	UserDao userDao = ctx.getBean(UserDao.class);
		List<UserEntity> retunList =  this.userDao.userList();
		System.out.println("/n/n LISt--->>"+retunList);
		return retunList;
	}
	
	@RequestMapping("/home")
//	public ModelAndView home(Model m){
//		System.out.println("\n \n HOME Controller\n \n");
//		ModelAndView modelAndView = new ModelAndView("home");
//		// modelAndView.addObject("userEntity", new UserEntity());
//		m.addAttribute("userEntity",new UserEntity());
//		return modelAndView;
//	}
	public ModelAndView home(){
		return new ModelAndView("home", "formname", new UserEntity());
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView userRegister(@ModelAttribute("formname") UserEntity userEntity , HttpServletRequest request, BindingResult result,Model m) {
		System.out.println("\n \n REGISTER Controller\n \n");
		
		// System.out.println(userEntity.getUvc_email());
		boolean userLoginFlag = false;
		UserVO userVo = new UserVO();
		//	String uname = (String)request.getParameter("uvc_user_name").trim();
		String uname = userEntity.getUvc_user_name();
		System.out.println("\n\n uname-->>"+uname);
		//	String passwd = (String)request.getParameter("vc_passwd").trim();
		String passwd = userEntity.getVc_passwd();
		System.out.println("usrPasswd-->>"+passwd);
		//		String regEmail = (String)request.getParameter("uvc_email").trim();
		String regEmail = userEntity.getUvc_email();
		System.out.println("usrPasswd-->>"+regEmail);
		String sendUpdates = (String)request.getParameter("b_sendUpdates");
		System.out.println("sendUpdates-->"+sendUpdates);
		System.out.println("\n\n");
		
		if(!uname.equals(null) && !passwd.equals(null) && !regEmail.equals(null)){
			userVo.setUser_name(uname);
			userVo.setUser_password(passwd);
			userVo.setUser_email(regEmail);
			
			if(sendUpdates.equals(true))
				userVo.setSend_updates(true);
			
			ModelAndView mav = new ModelAndView();
			String message = this.userDao.userRegister(userVo, userEntity);
			System.out.println("\n\nMESSAGE in CONTROLLER-->>"+message);
			
			//((Model) mav).addAttribute("user", new UserEntity());
			mav.addObject("message", message);
		}
		m.addAttribute("message", "Successfully saved person: ");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request){
		System.out.println("\n \n LOGIN Controller\n \n");
		boolean userLoginFlag = false;
		UserVO userVo = new UserVO();
		String uname = (String)request.getParameter("userName").trim();
		System.out.println("\n\n uname-->>"+uname);
		String passwd = (String)request.getParameter("usrPasswd").trim();
		System.out.println("usrPasswd-->>"+passwd);
		System.out.println("\n\n");
		
		if(!uname.equals(null)&& !passwd.equals(null)) {
		userVo.setUser_name(uname);
		userVo.setUser_password(passwd);
		System.out.println("\n\nINSIDE IF CONTROLLER \n\n");
	/*	@SuppressWarnings("unchecked")
		ArrayList<UserEntity> userList =(ArrayList<UserEntity>) this.userDao.userList();
		
 if (userList.size()>0){
			 
			 for(int i = 0;i<=userList.size();i++){
				 System.out.println("list UserDao IMP-->>>"+userList.get(i));
			 }
			 
		 }
		System.out.println("USER LIST-->>"+userList);*/
		userLoginFlag = this.userDao.userLogin(userVo);
		if(userLoginFlag)
		System.out.println("\n\n  LOGIn CONTROLLER TRUE \n\n");
		else
			System.out.println("\n\n  LOGIn CONTROLLER false \n\n");
		}
		return new ModelAndView("home", "formname", new UserEntity());
	}
	
	/*@RequestMapping(value="/login")
	public void list(){
		System.out.println("USER CONTROLLER LIST -->"+ userService.getList());
	}*/
}
