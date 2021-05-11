package cn.tju.easy_job.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.entity.MyCallback;
import cn.tju.easy_job.entity.StudentUserInfo;
import cn.tju.easy_job.service.UserInfoService;

@Controller
@RequestMapping("/Person")
public class PersonController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/getUserInfo", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getUserInfo(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String status = request.getParameter("status");
		
		String message = "";
		if (status.equals("STUDENT")) {
			StudentUserInfo userInfo = userInfoService.getStudentInfoByUserId(userId);
			message = userInfo.toString();
		} else {
			EnterpriseUserInfo userInfo = userInfoService.getEnterpriseInfoByUserId(userId);
			message = userInfo.toString();
		}
		MyCallback callback = new MyCallback(message, "success");
		return callback.toString();
	}
	
	@RequestMapping(value="/updateUserInfo", produces = "text/html; charset=UTF-8")
	public @ResponseBody String updateUserInfo(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String status = request.getParameter("status");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthString = request.getParameter("birth");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date birth = null;
		try {
			birth = simpleDateFormat.parse(birthString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String school = request.getParameter("school");
		String major = request.getParameter("major");
		String company = request.getParameter("company");
		String position = request.getParameter("position");
		
		if (status.equals("STUDENT")) {
			userInfoService.updateStudentInfo(id, userId, name, sex, birth, school, major);
		} else {
			userInfoService.updateEnterpriseInfo(id, userId, name, sex, birth, company, position);
		}
		
		MyCallback callback = new MyCallback("", "success");
		return callback.toString();
	}
	
	@RequestMapping(value="/updateAvatar", produces = "text/html; charset=UTF-8")
	public @ResponseBody String updateAvatar(HttpServletRequest request) {
		
		return "";
	}

}
