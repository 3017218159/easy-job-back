package cn.tju.easy_job.dao;

import java.util.Date;

import cn.tju.easy_job.entity.EnterpriseUserInfo;
import cn.tju.easy_job.entity.StudentUserInfo;

public interface UserInfoDao {

	StudentUserInfo getStudentInfoByInfoId(int userInfoId);

	EnterpriseUserInfo getEnterpriseInfoByUserId(int userId);

	EnterpriseUserInfo getEnterpriseInfoByInfoId(int userInfoId);

	StudentUserInfo getStudentInfoByUserId(int userId);

	void createStudentInfo(int id);

	void createEnterpriseInfo(int id);

	void updateStudentInfo(int id, int userId, String name, String sex, Date birth, String school, String major);

	void updateEnterpriseInfo(int id, int userId, String name, String sex, Date birth, String company, String position);

}
