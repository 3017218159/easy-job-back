package cn.tju.easy_job.dao;

import java.util.List;

import cn.tju.easy_job.entity.Users;

public interface UsersDao {
	List<Users> getUsers();

	Users getUsers(String phoneNumber);

}
