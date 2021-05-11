package cn.tju.easy_job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tju.easy_job.dao.ChatDao;
import cn.tju.easy_job.entity.MyMessage;
import cn.tju.easy_job.entity.MySession;
import cn.tju.easy_job.service.ChatService;

@Service("chatService")
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatDao chatDao;

	@Override
	public List<MySession> getChatList(int id) {
		return chatDao.getChatList(id);
	}

	@Override
	public List<MyMessage> getHistory(String sessionId) {
		return chatDao.getHistory(sessionId);
	}

	@Override
	public String getSessionId(String user1Id, String user2Id) {
		return chatDao.getSessionId(user1Id, user2Id);
	}

	@Override
	public void createSession(String user1Id, String user2Id) {
		chatDao.createSession(user1Id, user2Id);
	}

}
