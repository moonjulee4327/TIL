package kr.or.ddit.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.ProductVO;

@Repository
public class ProductDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertProduct(ProductVO productVO) {
		return sqlSessionTemplate.insert("product.insert", productVO);
	}
	
}
