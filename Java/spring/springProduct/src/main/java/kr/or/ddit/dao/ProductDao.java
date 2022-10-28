package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProductDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertProduct(ProductVO productVO) {
		return this.sqlSessionTemplate.insert("product.insert", productVO);
	}
	
	public List<ProductVO> list(String keyword) {
		return this.sqlSessionTemplate.selectList("product.list", keyword);
	}
	
	public List<ProductVO> listAll() {
		return this.sqlSessionTemplate.selectList("product.listAll");
	}
	
	public ProductVO detail(ProductVO productVO) {
		return this.sqlSessionTemplate.selectOne("product.select_detail", productVO);
	}
	
	public ProductVO cartSelect(String productId) {
		return this.sqlSessionTemplate.selectOne("product.cart_select", productId);
	}
	
	public int update(ProductVO productVO) {
		return this.sqlSessionTemplate.update("product.update", productVO);
	}
	
	public int delete(String productId) {
		return this.sqlSessionTemplate.delete("product.delete", productId);
	}
	
	public int insertCart(CartVO cartVO) {
		return this.sqlSessionTemplate.insert("product.insertCart", cartVO);
	}
	
	// ATTACH 테이블 다중 INSERT
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.sqlSessionTemplate.insert("product.insertAttach", attachVOList);
	}
}
