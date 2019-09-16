package kr.or.ddit.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.prod.model.Prod;
import kr.or.ddit.util.MybatisUtil;
@Repository
public class ProdDao implements IProdDao{
	
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * Method : getProd
	 * 작성자 : PC-12
	 * 변경이력 :
	 * @param prodId
	 * @return
	 * Method 설명 :
	 */
	@Override
	public List<Prod> getProdList(String prodId) {
		List<Prod> list = sqlSession.selectList("prod.getProdList",prodId);
		return list;
	}

}
