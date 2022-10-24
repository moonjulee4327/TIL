package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.ProductVO;

@Repository
public class ProductDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertProduct(ProductVO productVO) {
		return this.sqlSessionTemplate.insert("product.insert", productVO);
	}
	
	public List<ProductVO> list() {
		return this.sqlSessionTemplate.selectList("product.list");
	}
	
	public ProductVO detail(ProductVO productVO) {
		return this.sqlSessionTemplate.selectOne("product.select_detail", productVO);
	}
}
