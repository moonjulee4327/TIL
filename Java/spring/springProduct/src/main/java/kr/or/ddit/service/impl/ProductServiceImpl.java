package kr.or.ddit.service.impl;

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

}
