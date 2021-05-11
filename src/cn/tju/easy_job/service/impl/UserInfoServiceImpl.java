package cn.tju.easy_job.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tju.easy_job.dao.UserInfoDao;
import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.entity.StudentUserInfo;
import cn.tju.easy_job.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public EnterpriseUserInfo getEnterpriseInfoByInfoId(int userInfoId) {
		return userInfoDao.getEnterpriseInfoByInfoId(userInfoId);
	}

	@Override
	public StudentUserInfo getStudentInfoByInfoId(int userInfoId) {
		return userInfoDao.getStudentInfoByInfoId(userInfoId);
	}

	@Override
	public EnterpriseUserInfo getEnterpriseInfoByUserId(int userId) {
		return userInfoDao.getEnterpriseInfoByUserId(userId);
	}

	@Override
	public StudentUserInfo getStudentInfoByUserId(int userId) {
		return userInfoDao.getStudentInfoByUserId(userId);
	}

	@Override
	public void createStudentInfo(int id) {
		userInfoDao.createStudentInfo(id);
	}

	@Override
	public void createEnterpriseInfo(int id) {
		userInfoDao.createEnterpriseInfo(id);
	}

	@Override
	public void updateStudentInfo(int id, int userId, String name, String sex, Date birth, String school,
			String major) {
		userInfoDao.updateStudentInfo(id, userId, name, sex, birth, school, major);
	}

	@Override
	public void updateEnterpriseInfo(int id, int userId, String name, String sex, Date birth, String company,
			String position) {
		userInfoDao.updateEnterpriseInfo(id, userId, name, sex, birth, company, position);
	}

}
