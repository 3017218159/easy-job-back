package cn.tju.easy_job.service;

import cn.tju.easy_job.entity.Users;

public interface UsersService {

	Users getUsers(String email);

	String login(String email, String status);

	void register(String email, String status, String username, String password);

}
