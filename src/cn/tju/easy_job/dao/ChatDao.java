package cn.tju.easy_job.dao;

import java.util.List;

import cn.tju.easy_job.entity.MyMessage;
import cn.tju.easy_job.entity.MySession;

public interface ChatDao {

	List<MySession> getChatList(int id);

	List<MyMessage> getHistory(String sessionId);

	String getSessionId(String user1Id, String user2Id);

	void createSession(String user1Id, String user2Id);

}
