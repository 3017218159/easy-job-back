package cn.tju.easy_job.service;

import java.util.List;

import cn.tju.easy_job.entity.RecruitInfo;

public interface SquareService {

	List<RecruitInfo> getRecruitInfos(String categary, int offset, int pageSize);

	int getTotal(String categary);

}
