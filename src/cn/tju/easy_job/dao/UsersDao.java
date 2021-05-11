package cn.tju.easy_job.dao;

import java.util.List;

import cn.tju.easy_job.entity.Users;

public interface UsersDao {
	List<Users> getUsers();

	Users getUsers(String email, String status);

	String login(String email, String status);

	void register(String email, String status, String username, String password);

}
