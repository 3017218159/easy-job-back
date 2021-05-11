package cn.tju.easy_job.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tju.easy_job.entity.MyCallback;
import cn.tju.easy_job.entity.RecruitInfo;
import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.service.SquareService;
import cn.tju.easy_job.service.UserInfoService;

@Controller
@RequestMapping("/Square")
public class SquareController {
	@Autowired
	private SquareService squareService;
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/getInfos", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getInfos(HttpServletRequest request) {
		String categary = request.getParameter("categary");
		String userType = request.getParameter("userType");
		int offset = Integer.parseInt(request.getParameter("offset"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		String message = "";
		//学生用户的招聘广场信息
		if (userType.equals("STUDENT")) {
			List<RecruitInfo> recruitInfoList = squareService.getRecruitInfos(categary, offset, pageSize);
			int total = squareService.getTotal(categary);
			
			message = "{\"total\":\"" + total + "\", \"data\":[";
			for(int i=0; i<recruitInfoList.size(); i++) {
				message += "{";
				int userInfoId = recruitInfoList.get(i).getUserInfoId();
				EnterpriseUserInfo userInfo = userInfoService.getEnterpriseInfoByInfoId(userInfoId);
				message += "\"user\":" + userInfo.toString() + ", \"content\":" + recruitInfoList.get(i).toString();
				message += "},";
			}
			if (recruitInfoList.size() != 0) {
				message = message.substring(0, message.length() - 1);
			}
			message += "]}";
		}
		MyCallback callback = new MyCallback(message, "success");
		return callback.toString();
	}

}
