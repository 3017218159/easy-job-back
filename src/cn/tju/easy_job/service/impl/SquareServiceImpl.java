package cn.tju.easy_job.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tju.easy_job.dao.SquareDao;
import cn.tju.easy_job.entity.RecruitInfo;
import cn.tju.easy_job.service.SquareService;

@Service("squareService")
public class SquareServiceImpl implements SquareService {
	@Autowired
	private SquareDao squareDao;

	@Override
	public List<RecruitInfo> getRecruitInfos(String categary, int offset, int pageSize) {
		int start = (offset - 1) * pageSize;
		int end = start + pageSize;
//		System.out.println("start:" + start + "end:" + end);
		if (categary.equals("全部")) {
			return squareDao.getRecruitInfos(start, end);
		} else {
			return squareDao.getRecruitInfosWithCate(categary, start, end);
		}
	}

	@Override
	public int getTotal(String categary) {
		if (categary.equals("全部")) {
			return squareDao.getTotal();
		} else {
			return squareDao.getTotalWithCate(categary);
		}
	}

}
