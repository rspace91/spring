package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.Lprod;

@Service
public class LprodService implements ILprodService{
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	
	public LprodService() {
	}
	public LprodService(ILprodDao lprodDao) {
		 this.lprodDao = lprodDao;
	}
	@Override
	public List<Lprod> getLprodPagingList(Page page) {
		return (List<Lprod>) lprodDao.getLprodPagingList(page);
	}
	@Override
	public List<Lprod> getLprodList() {
		return lprodDao.getLprodList();
	}
	@Override
	public int getLprodTotalCnt() {
		return lprodDao.getLprodTotalCnt();
	}
	

}
