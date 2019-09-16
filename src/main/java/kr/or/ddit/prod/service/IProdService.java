package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.Prod;

public interface IProdService {
	/**
	 * 
	 * Method : getProdList
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param prodId
	 * @return
	 * Method 설명 :
	 */
	List<Prod> getProdList(String prodId);
	
}
