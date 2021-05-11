package cn.tju.easy_job.controller;

import java.security.GeneralSecurityException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.entity.MyCallback;
import cn.tju.easy_job.entity.MyEmail;
import cn.tju.easy_job.entity.StudentUserInfo;
import cn.tju.easy_job.entity.Users;
import cn.tju.easy_job.service.UserInfoService;
import cn.tju.easy_job.service.UsersService;

@Controller
@RequestMapping("/Users")
public class UsersController {
	Date date = new Date();
	Random rand = new Random(date.getTime());
	HashMap<String, String> emailCodeMap = new HashMap<String, String>();
	@Autowired
	private UsersService usersService;
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/getUsers", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getUsers(HttpServletRequest request) {
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		if(email == null || email.equals("")) {
			MyCallback error = new MyCallback("传入参数有误", "error");
			return error.toString();
		}
		Users users = usersService.getUsers(email, status);
		System.out.println(users.getUsername() + " 已登录");
		String message = users.toString();
		if (status.equals("STUDENT")) {
			StudentUserInfo userInfo = userInfoService.getStudentInfoByUserId(users.getId());
			message = message.substring(0, message.length()-1);
			message += ", \"avatar\": \"" + userInfo.getAvatar() + "\"}";
		} else {
			EnterpriseUserInfo userInfo = userInfoService.getEnterpriseInfoByUserId(users.getId());
			message = message.substring(0, message.length()-1);
			message += ", \"avatar\": \"" + userInfo.getAvatar() + "\"}";
		}
		MyCallback callback = new MyCallback(message, "success");
		return callback.toString();
	}

	@RequestMapping(value="/login", produces = "text/html; charset=UTF-8")
	public @ResponseBody String login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		String code = request.getParameter("code");
		
		//System.out.println(email + " " + password + " " + type + " " + status + " " + code);
		String pswLocal = usersService.login(email, status);
		if (pswLocal == null) {
			MyCallback error = new MyCallback("邮箱不存在，请检查输入", "error");
			return error.toString();
		}
		if (type.equals("PASS")) {
			if (!password.equals(pswLocal)) {
				MyCallback error = new MyCallback("密码错误，请检查输入", "error");
				return error.toString();
			} else {
				MyCallback callback = new MyCallback("", "success");
				return callback.toString();
			}
		} else if (type.equals("CODE")) {
			String codeLocal = emailCodeMap.get(email);
			if (!code.equals(codeLocal)) {
				MyCallback error = new MyCallback("验证码错误，请检查输入", "error");
				return error.toString();
			} else {
				emailCodeMap.remove(email);
				MyCallback callback = new MyCallback("", "success");
				return callback.toString();
			}
		}
		MyCallback error = new MyCallback("未知错误", "error");
		return error.toString();
	}
	
	@RequestMapping(value="/register", produces = "text/html; charset=UTF-8")
	public @ResponseBody String register(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String username = request.getParameter("username");
		String code = request.getParameter("code");
		
		String pswLocal = usersService.login(email, status);
		if (pswLocal != null) {
			MyCallback error = new MyCallback("邮箱已被注册", "error");
			return error.toString();
		}
		
		//System.out.println(email + " " + password + " " + username + " " + status + " " + code);
		
		String codeLocal = emailCodeMap.get(email);
		if (!code.equals(codeLocal)) {
			MyCallback error = new MyCallback("验证码错误，请检查输入", "error");
			return error.toString();
		} else {
			usersService.register(email, status, username, password);
			emailCodeMap.remove(email);
			Users users = usersService.getUsers(email, status);
			int id = users.getId();
			if (status.equals("STUDENT")) {
				userInfoService.createStudentInfo(id);
			} else {
				userInfoService.createEnterpriseInfo(id);
			}
			MyCallback callback = new MyCallback("注册成功", "success");
			return callback.toString();
		}
	}
	
	@RequestMapping(value="/getCode", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getCode(HttpServletRequest request) {
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		String action = request.getParameter("action");
		
		String pswLocal = usersService.login(email, status);
		if (action.equals("login")) {
			if (pswLocal == null) {
				MyCallback error = new MyCallback("邮箱不存在，请检查输入", "error");
				return error.toString();
			}
		} else if (action.equals("register")) {
			if (pswLocal != null) {
				MyCallback error = new MyCallback("邮箱已被注册", "error");
				return error.toString();
			}
		}
		
		DecimalFormat df = new DecimalFormat("000000");
		String code = df.format(rand.nextInt(1000000));
		System.out.println(code);
		emailCodeMap.put(email, code);
		//发送邮件
		MyEmail myEmail = new MyEmail();
		try {
			myEmail.sendEmail(email, code);
		} catch (MessagingException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		
		MyCallback callback = new MyCallback("", "success");
		return callback.toString();
	}
}
