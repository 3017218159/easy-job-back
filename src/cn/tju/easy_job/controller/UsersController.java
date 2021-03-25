package cn.tju.easy_job.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tju.easy_job.entity.MyError;
import cn.tju.easy_job.entity.Users;
import cn.tju.easy_job.service.UsersService;

@Controller
@RequestMapping("/Users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/getUsers", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getUsers(HttpServletRequest request) {
		String phoneNumber = request.getParameter("phoneNumber");
		if(phoneNumber == null || phoneNumber.equals("")) {
			MyError error = new MyError("传入参数有误");
			return error.toString();
		}
		Users users = usersService.getUsers(phoneNumber);
		System.out.println(users.getUsername());
		String result = users.toString();
		return result;
	}

}
