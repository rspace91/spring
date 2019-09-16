package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;

public interface ILprodService {
	/**
	 * Method : getLprodPagingList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param page
	 * @return
	 * Method 설명 : Lprod 페이징 리스트 조회 
	 */
	List<Lprod> getLprodPagingList(Page page);

	
	
	List<Lprod> getLprodList() ;

	int getLprodTotalCnt();
	
	

}
