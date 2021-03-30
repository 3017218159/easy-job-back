package cn.tju.easy_job.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tju.easy_job.dao.UsersDao;
import cn.tju.easy_job.entity.Users;
import cn.tju.easy_job.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;

	@Override
	public Users getUsers(String email) {
		return usersDao.getUsers(email);
	}

	@Override
	public String login(String email, String status) {
		return usersDao.login(email, status);
	}

	@Override
	public void register(String email, String status, String username, String password) {
		usersDao.register(email, status, username, password);
	}

}
