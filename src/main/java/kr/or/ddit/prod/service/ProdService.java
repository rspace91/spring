package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.model.Prod;

@Service
public class ProdService implements IProdService {
	private static final Logger logger = LoggerFactory.getLogger(ProdService.class);
	
	@Resource(name="prodDao")
	private IProdDao prodDao;
	
	public ProdService() {
	}
	
	public ProdService(IProdDao prodDao) {
		this.prodDao = prodDao;
	}
	
	@Override
	public List<Prod> getProdList(String prodId) {
		List<Prod> prodList = prodDao.getProdList(prodId);
		return prodList;
	}

}
