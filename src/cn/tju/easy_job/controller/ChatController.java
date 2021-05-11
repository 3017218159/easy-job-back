package cn.tju.easy_job.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.entity.MyMessage;
import cn.tju.easy_job.entity.MyCallback;
import cn.tju.easy_job.entity.MySession;
import cn.tju.easy_job.entity.StudentUserInfo;
import cn.tju.easy_job.service.ChatService;
import cn.tju.easy_job.service.UserInfoService;

@Controller
@RequestMapping("/Chat")
public class ChatController {
	@Autowired
	private ChatService chatService;
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/getChatList", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getChatList(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		
		List<MySession> sessionList = chatService.getChatList(id);
		
		String msg = "[";
		
		for(int i=0; i<sessionList.size(); ++i) {
			MySession session = sessionList.get(i);
			int sessionId = session.getId();
			int userId = session.getUser1Id() == id ? session.getUser2Id() : session.getUser1Id();
			String message = session.getMessage();
			Date datetime = session.getDatetime();
			
			msg += "{\"sessionId\":\"" + sessionId + "\",\"userId\":\"" + userId + "\",\"message\":\"" + message 
					+ "\", \"datetime\":\"" + datetime + "\",";
			if (status.equals("STUDENT")) {
				EnterpriseUserInfo userInfo = userInfoService.getEnterpriseInfoByUserId(userId);
				String avatar = userInfo.getAvatar();
				String name = userInfo.getName();
				msg += "\"name\":\"" + name + "\",\"avatar\":\"" + avatar + "\"},";
			} else {
				StudentUserInfo userInfo = userInfoService.getStudentInfoByUserId(userId);
				String avatar = userInfo.getAvatar();
				String name = userInfo.getName();
				msg += "\"name\":\"" + name + "\",\"avatar\":\"" + avatar + "\"},";
			}
		}
		if (sessionList.size() != 0) {
			msg = msg.substring(0, msg.length() - 1);
		}
		msg += "]";
		MyCallback callback = new MyCallback(msg, "success");
		return callback.toString();
	}
	
	@RequestMapping(value="/getHistory", produces = "text/html; charset=UTF-8")
	public @ResponseBody String getHistory(HttpServletRequest request) {
		String sessionId = request.getParameter("sessionId");
		String user1Id = request.getParameter("user1Id");
		String user2Id = request.getParameter("user2Id");
		
		if (sessionId == null) {
			sessionId = chatService.getSessionId(user1Id, user2Id);
			if (sessionId == null) {
				chatService.createSession(user1Id, user2Id);
				sessionId = chatService.getSessionId(user1Id, user2Id);
			}
		}
		
		List<MyMessage> messageList = chatService.getHistory(sessionId);
		String msg = "[";
		
		for (int i=0; i<messageList.size(); ++i) {
			MyMessage message = messageList.get(i);
			String content = message.getMessage();
			int isMine = message.getFromId() == Integer.parseInt(user1Id) ? 1 : 0;
			msg += "{\"isMine\":\"" + isMine + "\",\"content\":\"" + content + "\"},";
		}
		if (messageList.size() != 0) {
			msg = msg.substring(0, msg.length() - 1);
		}
		msg += "]";
		System.out.println("getHistory: " + sessionId + ", " + user1Id + ", " + user2Id);
		MyCallback callback = new MyCallback(msg, "success");
		return callback.toString();
	}

}
