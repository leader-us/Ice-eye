package io.mycat.ice.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.ice.domain.User;
import io.mycat.ice.service.UserService;

//@EnableAutoConfiguration  
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{id}")
	public User view(@PathVariable("id") Long id) {
		User user = new User();
		user.setUserId("guest" + id);
		user.setAlias("zhang");
		return user;
	}
	
	/**
	 * check login username and password 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/checklogin")
	public User checkLogin(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User user = userService.getUserByUserId(username);
		if(user!=null&&password.equals(user.getPassword())){
			//success put user into Session
			request.getSession().setAttribute("user", user);
			return user;
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="/loginuser")
	public User loginuser(HttpServletRequest request){
		User user = null;
		Object obj = request.getSession().getAttribute("user");
		if(obj!=null){
			user = (User) obj;
		}
		return user;
	}
}