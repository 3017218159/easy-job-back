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
	public Users getUsers(String phoneNumber) {
		return usersDao.getUsers(phoneNumber);
	}

}
