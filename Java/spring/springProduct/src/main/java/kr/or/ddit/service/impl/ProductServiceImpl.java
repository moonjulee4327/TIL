package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ProductDao;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public int insertProduct(ProductVO productVO) {	
		return this.productDao.insertProduct(productVO);
	}
	
	@Override
	public List<ProductVO> list(String keyword) {
		return this.productDao.list(keyword);
	}
	
	@Override
	public ProductVO detail(ProductVO productVO) {
		return this.productDao.detail(productVO);
	}
	
	@Override
	public ProductVO cartSelect(String productId) {
		return this.productDao.cartSelect(productId);
	}
	
	@Override
	public int update(ProductVO productVO) {
		return productDao.update(productVO);
	}
	
	@Override
	public int delete(String productId) {
		return productDao.delete(productId);
	}
}
