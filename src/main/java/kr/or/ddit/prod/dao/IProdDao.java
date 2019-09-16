package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.Prod;

public interface IProdDao {
	List<Prod> getProdList(String prodId);
}
