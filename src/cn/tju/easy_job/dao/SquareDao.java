package cn.tju.easy_job.dao;

import java.util.List;

import cn.tju.easy_job.entity.RecruitInfo;

public interface SquareDao {

	List<RecruitInfo> getRecruitInfos(int start, int end);

	List<RecruitInfo> getRecruitInfosWithCate(String categary, int start, int end);

	int getTotal();

	int getTotalWithCate(String categary);

}
